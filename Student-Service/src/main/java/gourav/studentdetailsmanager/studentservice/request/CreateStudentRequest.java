package gourav.studentdetailsmanager.studentservice.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String area;
    private String city;
}
