package team.ghjly.emergencyrescue.mapper.sql;

import org.apache.ibatis.jdbc.SQL;
import team.ghjly.emergencyrescue.entity.Team;

public class TeamMapperSqlProvider {
    public static String selectTeamPublicListPageByTeamSql(final Team team) {
        return new SQL() {{
            SELECT("t_id, t_name, t_num, t_introduce, t_scope, t_img").FROM("team");
            if (team.gettName() != null && team.gettName() != "") {
                team.settName("%" + team.gettName() + "%");
                WHERE("t_name LIKE #{team.tName}");
            }
            if (team.gettScope() != null && team.gettScope() != "") {
                team.settScope("%" + team.gettScope() + "%");
                WHERE("t_scope LIKE #{team.tScope}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
