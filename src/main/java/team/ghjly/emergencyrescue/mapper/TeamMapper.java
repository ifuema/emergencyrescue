package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import team.ghjly.emergencyrescue.entity.Team;
import team.ghjly.emergencyrescue.mapper.sql.TeamMapperSqlProvider;

import java.util.List;

@Mapper
public interface TeamMapper {
    /**
     * 根据过滤救援队信息分页查询救援队列表
     * @param pageSize
     * @param startIndex
     * @param team
     * @return
     */
    @SelectProvider(type = TeamMapperSqlProvider.class, method = "selectTeamPublicListPageByTeamSql")
    List<Team> selectTeamPublicListPageByTeam(int pageSize, Integer startIndex, Team team);
}