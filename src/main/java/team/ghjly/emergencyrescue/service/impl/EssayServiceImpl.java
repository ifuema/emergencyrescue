package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.Essay;
import team.ghjly.emergencyrescue.mapper.EssayMapper;
import team.ghjly.emergencyrescue.service.EssayService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EssayServiceImpl implements EssayService {
    @Resource
    EssayMapper essayMapper;


    /**
     * 根据过滤文章信息分页获取文章列表
     * @param pageSize
     * @param pageNum
     * @param essay
     * @return
     */
    @Override
    public List<Essay> getEssayListPageByEssay(Integer pageSize, Integer pageNum, Essay essay) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return essayMapper.selectEssayListPageByEssay(pageSize, startIndex, essay);
    }

    @Override
    public Essay getEssayByEIdText(Integer eId) {
        return essayMapper.selectEssayByEIdText(eId);
    }
}
