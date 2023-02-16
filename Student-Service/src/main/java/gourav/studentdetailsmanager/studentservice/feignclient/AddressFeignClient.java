package gourav.studentdetailsmanager.studentservice.feignclient;

import gourav.studentdetailsmanager.studentservice.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Note: if we will do this kind of setup, then we will be able to call only Address Service from our API gateway
// as we cannot create another Feign Client with the same value i.e., "api-gateway"
@FeignClient(value = "api-gateway", path = "address-service/address-service-api/address")
public interface AddressFeignClient {

    @GetMapping("/{id}")
    AddressDto getAddress(@PathVariable Integer id);

    @PostMapping("/create")
    AddressDto createAddress(@RequestBody AddressDto createAddressRequest);
}
