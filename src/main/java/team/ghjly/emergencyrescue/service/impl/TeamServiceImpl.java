package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.Team;
import team.ghjly.emergencyrescue.mapper.TeamMapper;
import team.ghjly.emergencyrescue.service.TeamService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamMapper teamMapper;

    /**
     * 根据过滤救援队信息分页获取救援队列表
     * @param pageSize
     * @param pageNum
     * @param team
     * @return
     */
    @Override
    public List<Team> getTeamPublicListPageByTeam(int pageSize, Integer pageNum, Team team) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return teamMapper.selectTeamPublicListPageByTeam(pageSize, startIndex, team);
    }
}
