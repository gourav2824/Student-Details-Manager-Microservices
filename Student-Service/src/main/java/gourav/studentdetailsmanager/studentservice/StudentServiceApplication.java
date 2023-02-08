package gourav.studentdetailsmanager.studentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class StudentServiceApplication {

    @Value("${address-service.url}")
    private String addressServiceUrl;

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(addressServiceUrl).build();
    }
}
