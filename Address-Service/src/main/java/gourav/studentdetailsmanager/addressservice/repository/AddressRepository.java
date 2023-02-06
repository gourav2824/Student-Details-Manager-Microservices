package gourav.studentdetailsmanager.addressservice.repository;

import gourav.studentdetailsmanager.addressservice.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
