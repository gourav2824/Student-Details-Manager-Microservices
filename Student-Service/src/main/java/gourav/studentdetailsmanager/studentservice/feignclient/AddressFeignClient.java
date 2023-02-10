package gourav.studentdetailsmanager.studentservice.feignclient;

import gourav.studentdetailsmanager.studentservice.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "address-service", path = "/address-service-api/address")
public interface AddressFeignClient {

    @GetMapping("/{id}")
    AddressDto getAddress(@PathVariable Integer id);

    @PostMapping("/create")
    AddressDto createAddress(@RequestBody AddressDto createAddressRequest);
}
