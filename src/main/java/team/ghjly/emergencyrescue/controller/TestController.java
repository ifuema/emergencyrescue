package team.ghjly.emergencyrescue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.ghjly.emergencyrescue.vo.ResultVO;

@RestController
public class TestController {
    @GetMapping("/test")
    public ResultVO test() {
        return new ResultVO();
    }
}
