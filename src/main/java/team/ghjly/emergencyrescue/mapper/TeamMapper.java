package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

    /**
     * 根据tid文本删除救援队
     * @param tId
     * @return
     */
    @Delete("DELETE FROM team WHERE t_id = #{tId}")
    Integer deleteTeamByTId(Integer tId);

    @Select("SELECT t_id FROM team WHERE t_id = #{tId}")
    Integer selectTIdByTId(Integer tId);
}
