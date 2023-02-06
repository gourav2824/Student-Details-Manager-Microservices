package gourav.studentdetailsmanager.addressservice.controller;

import gourav.studentdetailsmanager.addressservice.model.Address;
import gourav.studentdetailsmanager.addressservice.request.CreateAddressRequest;
import gourav.studentdetailsmanager.addressservice.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create")
    public Address createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable Integer id) {
        return addressService.getAddress(id);
    }
}
