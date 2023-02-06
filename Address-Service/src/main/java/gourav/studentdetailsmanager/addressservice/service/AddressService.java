package gourav.studentdetailsmanager.addressservice.service;

import gourav.studentdetailsmanager.addressservice.model.Address;
import gourav.studentdetailsmanager.addressservice.repository.AddressRepository;
import gourav.studentdetailsmanager.addressservice.request.CreateAddressRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final Logger logger;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        this.logger = LoggerFactory.getLogger(AddressService.class);
    }

    public Address createAddress(CreateAddressRequest createAddressRequest) {
        final Address address = new Address(createAddressRequest.getArea(), createAddressRequest.getCity());
        final Address savedAddress = addressRepository.save(address);
        logger.info("Address created successfully : {}", savedAddress);
        return savedAddress;
    }

    public Address getAddress(int addressId) {
        final Optional<Address> address = addressRepository.findById(addressId);
        if (address.isPresent()) {
            logger.info("Found Address with id {} : {}", addressId, address.get());
            return address.get();
        }
        return null;
    }
}
