package gourav.studentdetailsmanager.studentservice.feignclient;

import gourav.studentdetailsmanager.studentservice.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "addressFeignClient", url = "${address-service.url}", path = "/address")
public interface AddressFeignClient {

    @GetMapping("/{id}")
    AddressDto getAddress(@PathVariable Integer id);
}
