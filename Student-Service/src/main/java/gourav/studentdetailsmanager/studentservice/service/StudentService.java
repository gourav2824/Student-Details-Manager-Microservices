package gourav.studentdetailsmanager.studentservice.service;

import gourav.studentdetailsmanager.studentservice.dto.AddressDto;
import gourav.studentdetailsmanager.studentservice.model.Student;
import gourav.studentdetailsmanager.studentservice.repository.StudentRepository;
import gourav.studentdetailsmanager.studentservice.response.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StudentService {

    @Value("${address-service.url}")
    private String addressServiceUrl;

    private final StudentRepository studentRepository;
    private final WebClient webClient;
    private final Logger logger;

    public StudentService(StudentRepository studentRepository, WebClient webClient) {
        this.studentRepository = studentRepository;
        this.webClient = webClient;
        logger = LoggerFactory.getLogger(StudentService.class);
    }

    public StudentResponse getStudent(int studentId) {
        final Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;
        logger.info("Found Student with id {} : {}", studentId, student);
        final AddressDto address = getAddress(student.getAddressId());
        return getStudentResponse(student, address);
    }

    private AddressDto getAddress(int addressId) {
        return webClient.get()
                .uri(addressServiceUrl + "/address/" + addressId)
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
