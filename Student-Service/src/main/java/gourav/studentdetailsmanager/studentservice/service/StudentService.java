package gourav.studentdetailsmanager.studentservice.service;

import gourav.studentdetailsmanager.studentservice.dto.AddressDto;
import gourav.studentdetailsmanager.studentservice.feignclient.AddressFeignClient;
import gourav.studentdetailsmanager.studentservice.model.Student;
import gourav.studentdetailsmanager.studentservice.repository.StudentRepository;
import gourav.studentdetailsmanager.studentservice.request.CreateStudentRequest;
import gourav.studentdetailsmanager.studentservice.response.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StudentService {
    private static final String CREATE_ADDRESS_URL = "/address/create";

    private final StudentRepository studentRepository;
    private final AddressFeignClient addressFeignClient;
    private final WebClient webClient;
    private final Logger logger;

    public StudentService(StudentRepository studentRepository, AddressFeignClient addressFeignClient, WebClient webClient) {
        this.studentRepository = studentRepository;
        this.addressFeignClient = addressFeignClient;
        this.webClient = webClient;
        logger = LoggerFactory.getLogger(StudentService.class);
    }

    public StudentResponse getStudent(int studentId) {
        final Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;
        logger.info("Student found with id {} : {}", studentId, student);
        final AddressDto address = getAddressFromFeignClient(student.getAddressId());
        return getStudentResponse(student, address);
    }

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        final AddressDto address = createAddress(
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

    private AddressDto getAddressFromFeignClient(int addressId) {
        return addressFeignClient.getAddress(addressId);
    }

    private AddressDto createAddress(AddressDto addressDto) {
        return webClient.post()
                .uri(CREATE_ADDRESS_URL)
                .bodyValue(addressDto)
                .retrieve()
                .bodyToMono(AddressDto.class)
                .block();
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
