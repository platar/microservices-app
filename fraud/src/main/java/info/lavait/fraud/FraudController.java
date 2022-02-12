package info.lavait.fraud;

import info.lavait.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudHistoryService fraudHistoryService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {

        log.info("customer verification {}", customerId);
        boolean isFraudster = fraudHistoryService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudster);
    }

}
