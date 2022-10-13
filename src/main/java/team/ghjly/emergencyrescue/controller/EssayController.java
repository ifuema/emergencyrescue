package team.ghjly.emergencyrescue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.ghjly.emergencyrescue.entity.Essay;
import team.ghjly.emergencyrescue.entity.ResultCode;
import team.ghjly.emergencyrescue.service.EssayService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/essay")
public class EssayController {
    @Resource
    EssayService essayService;
    private int pageSize = 10;
    private ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");
    private ResultVO<?> essayNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "文章不存在！");

    /**
     * 分页获取文章
     * @param pageNum
     * @param essay
     * @return
     */
    @GetMapping("/page/{pageNum}")
    public ResultVO<?> page(@PathVariable Integer pageNum, Essay essay) {
        List<Essay> essayList = essayService.getEssayListPageByEssay(pageSize, pageNum, essay);
        if (essayList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(essayList);
        }
    }

    @GetMapping("/{eId}")
    public ResultVO<?> getTeam(@PathVariable Integer eId) {
        Essay essay = essayService.getEssayByEIdText(eId);
        if (essay == null) {
            return essayNotExist;
        } else {
            return new ResultVO<>(essay);
        }
    }
}
