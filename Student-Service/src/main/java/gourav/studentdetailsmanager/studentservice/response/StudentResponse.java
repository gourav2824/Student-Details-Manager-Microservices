package gourav.studentdetailsmanager.studentservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int addressId;
    private String area;
    private String city;
}
