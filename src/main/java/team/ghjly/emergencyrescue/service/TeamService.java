package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> getTeamPublicListPageByTeam(int pageSize, Integer pageNum, Team team);
}
