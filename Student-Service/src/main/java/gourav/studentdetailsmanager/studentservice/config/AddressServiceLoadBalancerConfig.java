// Now we don't have to add Load Balancer Client for Address Service
// as we are not using the Address Service directly from Student Service.
// Now, we are calling Address Service through API gateway
// and API gateway will automatically do the load balancing by itself.

/*
package gourav.studentdetailsmanager.studentservice.config;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@LoadBalancerClient(value = "address-service")
public class AddressServiceLoadBalancerConfig {

    @Bean
    @LoadBalanced
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
*/
