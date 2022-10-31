package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Team;

import java.util.List;

public interface TeamService {
    /**
     * 根据过滤救援队信息分页获取救援队列表
     * @param pageSize
     * @param pageNum
     * @param team
     * @return
     */
    List<Team> getTeamListPageByTeam(int pageSize, Integer pageNum, Team team);

    /**
     * 根据tid文本移除救援队
     * @param tId
     * @return
     */
    boolean removeTeamByTId(Integer tId);

    boolean checkTeamByTId(Integer tId);
}
