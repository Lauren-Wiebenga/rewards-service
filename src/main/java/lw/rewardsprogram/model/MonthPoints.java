package lw.rewardsprogram.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.util.List;

@Component
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthPoints {
    private Month month;
    private int totalPoints;
    private List<Transaction> transactions;
}
