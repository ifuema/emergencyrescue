package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Essay;

import java.util.List;

public interface EssayService {
    List<Essay> getEssayListPageByEssay(Integer pageSize, Integer pageNum, Essay essay);
}
