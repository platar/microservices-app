package info.lavait.fraud.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
