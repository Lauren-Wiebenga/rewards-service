package lw.rewardsprogram.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lw.rewardsprogram.model.MonthPoints;
import lw.rewardsprogram.model.RewardResponse;
import lw.rewardsprogram.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class RewardsService {

    private final TransactionService transactionService;

    public List<RewardResponse> getMonthlyPoints() {
        List<Transaction> transactions = transactionService.getTransactions();
        Map<String, List<Transaction>> transactionsByCustomer = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCustomer));

        return transactionsByCustomer
                .entrySet()
                .stream()
                .map(customerTransactions -> {

                    Map<Month, List<Transaction>> monthTransactions = mapMonthTransaction(customerTransactions);

                    List<MonthPoints> monthPoints = getMonthPoints(monthTransactions);

                    return RewardResponse
                            .builder()
                            .customer(customerTransactions.getKey())
                            .totalPoints(monthPoints.stream().map(MonthPoints::getTotalPoints)
                                    .reduce(0, Integer::sum))
                            .monthlyPoints(monthPoints)
                            .build();
                })
                .collect(Collectors.toList());
    }

    private Map<Month, List<Transaction>> mapMonthTransaction (Map.Entry<String, List<Transaction>> entry ) {
        return entry.getValue().stream().collect(Collectors.groupingBy(t -> t.getDate().getMonth()));
    }

    private List<MonthPoints> getMonthPoints(Map<Month, List<Transaction>> monthTransactions) {
        return monthTransactions.entrySet().stream()
                .map(monthTransaction -> MonthPoints.builder()
                        .month(monthTransaction.getKey())
                        .totalPoints(calculatePoints(collectAmounts(monthTransaction.getValue())))
                        .transactions(monthTransaction.getValue())
                        .build()
                ).sorted(Comparator.comparing(MonthPoints::getMonth))
                .collect(Collectors.toList());
    }

    private List<BigDecimal> collectAmounts(List<Transaction> transactions) {
        return transactions.stream().map(Transaction::getAmount).collect(Collectors.toList());
    }

    private int calculatePoints(List<BigDecimal> amounts) {
        int sum = 0;
        for (BigDecimal amount : amounts) {
            int dollars = amount.intValue();
            if (dollars > 100) {
                sum += ((dollars - 100) * 2) + 50;
            }
            if (dollars <= 100 && dollars > 50) {
                sum += (dollars - 50);
            }
        }
        return sum;
    }
}
