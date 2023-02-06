package gourav.studentdetailsmanager.addressservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String area;

    private String city;

    protected Address() {
    }

    public Address(String area, String city) {
        this.area = area;
        this.city = city;
    }
}
