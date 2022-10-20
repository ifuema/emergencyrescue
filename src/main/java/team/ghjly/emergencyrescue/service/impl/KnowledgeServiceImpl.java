package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.Knowledge;
import team.ghjly.emergencyrescue.mapper.KnowledgeMapper;
import team.ghjly.emergencyrescue.service.KnowledgeService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    @Resource
    private KnowledgeMapper knowledgeMapper;


    @Override
    public List<Knowledge> getKnowledgeListPageByKnowledge(int pageSize, Integer pageNum, Knowledge knowledge) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return knowledgeMapper.selectKnowledgeListPageByKnowledge(pageSize, startIndex, knowledge);
    }
}
