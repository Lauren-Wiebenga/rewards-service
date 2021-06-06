package lw.rewardsprogram.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RewardResponse {
    private String customer;
    private int totalPoints;
    private List<MonthPoints> monthlyPoints;
}
