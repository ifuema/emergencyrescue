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

    /**
     * 根据id文本获取文章信息
     * @param eId
     * @return
     */
    @Override
    public Essay getEssayByEId(Integer eId) {
        return essayMapper.selectEssayByEId(eId);
    }

    @Override
    public boolean saveEssay(Essay essay) {
        if (essayMapper.insertEssay(essay) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkEssayByEId(Integer eId) {
        Integer dataEId = essayMapper.selectEIdByEId(eId);
        if (dataEId == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeEssayByEId(Integer eId) {
        if (essayMapper.deleteEssayByEId(eId) >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
