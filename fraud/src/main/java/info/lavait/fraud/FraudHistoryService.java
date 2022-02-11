package info.lavait.fraud;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudHistoryService {

    private final FraudHistoryRepository fraudHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudHistoryRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .isFraudster(false)
                .build());
        return false;
    }
}
