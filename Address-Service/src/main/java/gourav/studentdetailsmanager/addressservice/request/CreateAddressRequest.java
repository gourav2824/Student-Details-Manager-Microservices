package gourav.studentdetailsmanager.addressservice.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateAddressRequest {
    private String area;
    private String city;
}
