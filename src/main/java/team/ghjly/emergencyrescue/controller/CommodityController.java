package team.ghjly.emergencyrescue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.ghjly.emergencyrescue.entity.Commodity;
import team.ghjly.emergencyrescue.service.CommodityService;
import team.ghjly.emergencyrescue.vo.ResultCode;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Resource
    private CommodityService commodityService;
    private int pageSize = 5;
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");

    @GetMapping("/page/{pageNum}")
    public ResultVO<?> page(@PathVariable Integer pageNum, Commodity commodity) {
        List<Commodity> dataCommodityList = commodityService.getCommodityListPageByCommodity(pageSize, pageNum, commodity);
        if (dataCommodityList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataCommodityList);
        }
    }
}
