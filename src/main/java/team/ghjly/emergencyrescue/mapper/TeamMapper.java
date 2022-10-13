package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import team.ghjly.emergencyrescue.entity.Team;
import team.ghjly.emergencyrescue.mapper.sql.EssayMapperSqlProvider;
import team.ghjly.emergencyrescue.mapper.sql.TeamMapperSqlProvider;

import java.util.List;

@Mapper
public interface TeamMapper {
    @SelectProvider(type = TeamMapperSqlProvider.class, method = "selectTeamPublicListPageByTeamSql")
    List<Team> selectTeamPublicListPageByTeam(int pageSize, Integer startIndex, Team team);
}
