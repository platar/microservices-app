package info.lavait.customer;

import info.lavait.clients.fraud.FraudCheckResponse;
import info.lavait.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        // check if emial valid
        // check if email not taken
        customerRepository.saveAndFlush(customer);

//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://localhost:8081/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class, customer.getId());
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class, customer.getId());

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        // check if fraudter
        if(fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("frauster");
        }

        // send notification
//        NotificationRequest notificationRequest = new NotificationRequest(
//                customer.getId(),
//                customer.getEmail(),
//                String.format("Hi %s, welcome to Amigoscode...",
//                        customer.getFirstName())
//        );
//        rabbitMQMessageProducer.publish(
//                notificationRequest,
//                "internal.exchange",
//                "internal.notification.routing-key"
//        );
    }
}
