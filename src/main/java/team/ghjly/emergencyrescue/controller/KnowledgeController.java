package team.ghjly.emergencyrescue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.ghjly.emergencyrescue.entity.Knowledge;
import team.ghjly.emergencyrescue.vo.ResultCode;
import team.ghjly.emergencyrescue.service.KnowledgeService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/konwledge")
public class KnowledgeController {
    @Resource
    KnowledgeService knowledgeService;
    private int pageSize = 5;
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");

    /**
     * 分页获取小知识
     * @param pageNum
     * @param knowledge
     * @return
     */
    @GetMapping("/page/{pageNum}")
    public ResultVO<?> page(@PathVariable Integer pageNum, Knowledge knowledge) {
        List<Knowledge> dataKnowledgeList = knowledgeService.getKnowledgeListPageByKnowledge(pageSize, pageNum, knowledge);
        if (dataKnowledgeList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataKnowledgeList);
        }
    }
}
