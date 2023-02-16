package gourav.studentdetailsmanager.studentservice.service;

import gourav.studentdetailsmanager.studentservice.dto.AddressDto;
import gourav.studentdetailsmanager.studentservice.feignclient.GatewayFeignClient;
import gourav.studentdetailsmanager.studentservice.model.Student;
import gourav.studentdetailsmanager.studentservice.repository.StudentRepository;
import gourav.studentdetailsmanager.studentservice.request.CreateStudentRequest;
import gourav.studentdetailsmanager.studentservice.response.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final GatewayFeignClient feignClient;
    private final Logger logger;

    public StudentService(StudentRepository studentRepository, GatewayFeignClient feignClient) {
        this.studentRepository = studentRepository;
        this.feignClient = feignClient;
        logger = LoggerFactory.getLogger(StudentService.class);
    }

    public StudentResponse getStudent(int studentId) {
        final Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;
        logger.info("Student found with id {} : {}", studentId, student);
        final AddressDto address = feignClient.getAddress(student.getAddressId());
        return getStudentResponse(student, address);
    }

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        final AddressDto address = feignClient.createAddress(
                new AddressDto(createStudentRequest.getArea(), createStudentRequest.getCity()));

        Student student = new Student(
                createStudentRequest.getFirstName(),
                createStudentRequest.getLastName(),
                createStudentRequest.getEmail(),
                address.getId()
        );
        student = studentRepository.save(student);

        logger.info("Student created successfully : {}", student);
        return getStudentResponse(student, address);
    }

    private StudentResponse getStudentResponse(Student student, AddressDto address) {
        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                address.getId(),
                address.getArea(),
                address.getCity()
        );
    }
}
