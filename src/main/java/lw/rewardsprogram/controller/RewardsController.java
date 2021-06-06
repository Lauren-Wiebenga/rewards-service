package lw.rewardsprogram.controller;

import lombok.RequiredArgsConstructor;
import lw.rewardsprogram.model.RewardResponse;
import lw.rewardsprogram.service.RewardsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rewards")
public class RewardsController {

    private final RewardsService rewardsService;

    @GetMapping("/points")
    public List<RewardResponse> getMonthlyPoints() {
        return rewardsService.getMonthlyPoints();
    }
}
