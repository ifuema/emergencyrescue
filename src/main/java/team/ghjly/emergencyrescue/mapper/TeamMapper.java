package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.*;
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
    @SelectProvider(type = TeamMapperSqlProvider.class, method = "selectTeamListPageByTeamSql")
    List<Team> selectTeamListPageByTeam(int pageSize, Integer startIndex, Team team);

    /**
     * 根据tid文本删除救援队
     * @param tId
     * @return
     */
    @Delete("DELETE FROM team WHERE t_id = #{tId}")
    Integer deleteTeamByTId(Integer tId);

    /**
     * 根据id文本查询救援队id
     * @param tId
     * @return
     */
    @Select("SELECT t_id FROM team WHERE t_id = #{tId}")
    Integer selectTIdByTId(Integer tId);

    /**
     * 根据id文本修改救援队
     * @param team
     * @return
     */
    @Update("UPDATE team SET t_name = #{tName}, t_num = #{tNum}, t_introduce = #{tIntroduce}, " +
            "t_scope = #{tScope}, t_img = #{tImg} WHERE t_id = #{tId}")
    Integer updateTeamByTId(Team team);
}
