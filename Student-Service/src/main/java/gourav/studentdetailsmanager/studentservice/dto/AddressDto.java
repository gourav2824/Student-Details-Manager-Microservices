package gourav.studentdetailsmanager.studentservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    private int id;
    private String area;
    private String city;

    public AddressDto(String area, String city) {
        this.area = area;
        this.city = city;
    }
}
