package info.lavait.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
