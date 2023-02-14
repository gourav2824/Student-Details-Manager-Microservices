package gourav.studentdetailsmanager.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter {
    private final Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Pre-filter
        final ServerHttpRequest request = exchange.getRequest();

        if (request.getURI().toString().contains("/address-service-api")) {
            logger.info("Request for Address Service");
        }

        logger.info("Pre-filter");
        logger.info("Authorization = " + request.getHeaders().getFirst("Authorization"));

        // This line will continue with the execution of the filter chain (route the request to appropriate service)
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    // Post-filter
                    final ServerHttpResponse response = exchange.getResponse();
                    logger.info("Post-filter");
                    logger.info("Response Status = {}", response.getStatusCode());
                }));
    }
}
