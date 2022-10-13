package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Essay;

import java.util.List;

public interface EssayService {
    /**
     * 根据过滤文章信息分页获取文章列表
     * @param pageSize
     * @param pageNum
     * @param essay
     * @return
     */
    List<Essay> getEssayListPageByEssay(Integer pageSize, Integer pageNum, Essay essay);

    Essay getEssayByEIdText(Integer eId);
}
