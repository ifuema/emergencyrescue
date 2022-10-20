package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Knowledge;

import java.util.List;

public interface KnowledgeService {

    List<Knowledge> getKnowledgeListPageByKnowledge(int pageSize, Integer pageNum, Knowledge knowledge);
}
