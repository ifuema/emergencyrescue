package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.KnowledgeCommodity;
import team.ghjly.emergencyrescue.mapper.KnowledgeCommodityMapper;
import team.ghjly.emergencyrescue.service.KnowledgeCommodityService;

import javax.annotation.Resource;

@Service
public class KnowledgeCommodityServiceImpl implements KnowledgeCommodityService {
    @Resource
    KnowledgeCommodityMapper knowledgeCommodityMapper;

    @Override
    public boolean saveKnowledgeCommodity(KnowledgeCommodity knowledgeCommodity) {
        if (knowledgeCommodityMapper.insertKnowledgeCommodity(knowledgeCommodity) >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
