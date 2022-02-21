package info.lavait.clients.notification;

import info.lavait.clients.fraud.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(
        name = "notification",
        url = "${clients.notification.url}"
)
public interface NotificationClient {

    @PostMapping(path = "api/v1/notification")
    FraudCheckResponse sendNotification(NotificationRequest notificationRequest);
}
