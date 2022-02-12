package info.lavait.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
