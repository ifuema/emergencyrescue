package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Knowledge;

import java.util.List;

public interface KnowledgeService {
    /**
     * 根据过滤小知识信息分页获取小知识列表
     * @param pageSize
     * @param pageNum
     * @param knowledge
     * @return
     */
    List<Knowledge> getKnowledgeListPageByKnowledge(int pageSize, Integer pageNum, Knowledge knowledge);

    boolean checkKonwledgeByKId(Integer kId);

    boolean removeKonwledgeByKId(Integer kId);
}
