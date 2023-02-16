package gourav.studentdetailsmanager.studentservice.feignclient;

import gourav.studentdetailsmanager.studentservice.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Note: we should not be using prefix path of Address Service while using API Gateway
// otherwise we will be able to call only Address Service from our API gateway
// as we cannot create another Feign Client with the same value i.e., "api-gateway".
// So, we should use full service path in the mappings
// and now this FeignClient will not only for Address Service,
// we can use this client to use API of any other services

@FeignClient(value = "api-gateway")
public interface GatewayFeignClient {
    String ADDRESS_SERVICE_PATH = "address-service/address-service-api/address";

    @GetMapping(ADDRESS_SERVICE_PATH + "/{id}")
    AddressDto getAddress(@PathVariable Integer id);

    @PostMapping(ADDRESS_SERVICE_PATH + "/create")
    AddressDto createAddress(@RequestBody AddressDto createAddressRequest);
}
