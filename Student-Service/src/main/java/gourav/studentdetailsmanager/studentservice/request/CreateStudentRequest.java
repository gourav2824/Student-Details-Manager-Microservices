package gourav.studentdetailsmanager.studentservice.request;

import lombok.Getter;

@Getter
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String area;
    private String city;
}
