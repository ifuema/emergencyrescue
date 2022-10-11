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


    @Override
    public List<Essay> getEssayListPageByEssay(Integer pageSize, Integer pageNum, Essay essay) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return essayMapper.selectEssayListPageByEssay(pageSize, startIndex, essay);
    }
}
