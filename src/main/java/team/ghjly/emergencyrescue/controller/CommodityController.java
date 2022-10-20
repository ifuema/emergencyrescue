package team.ghjly.emergencyrescue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.ghjly.emergencyrescue.service.CommodityService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;

@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Resource
    private CommodityService commodityService;
    @GetMapping
    public ResultVO<?> get() {
        return new ResultVO<>(commodityService.get());
    }
}
