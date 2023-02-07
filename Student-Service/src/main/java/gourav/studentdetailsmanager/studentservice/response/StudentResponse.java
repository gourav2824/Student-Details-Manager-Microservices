package gourav.studentdetailsmanager.studentservice.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StudentResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int addressId;
    private String area;
    private String city;
}
