package lw.rewardsprogram.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private String customer;
    private LocalDate date;
    private BigDecimal amount;
}
