package team.ghjly.emergencyrescue.mapper.sql;

import org.apache.ibatis.jdbc.SQL;
import team.ghjly.emergencyrescue.entity.Essay;

public class EssayMapperSqlProvider {
    public static String selectEssayListPageByEssaySql(final Essay essay) {
        return new SQL() {{
            SELECT("*").FROM("essay");
            if (essay.geteTitle() != null && essay.geteTitle() != "") {
                essay.seteTitle("%" + essay.geteTitle() + "%");
                WHERE("e_title LIKE #{essay.eTitle}");
            }
            if (essay.geteBody() != null && essay.geteBody() != "") {
                essay.seteBody("%" + essay.geteBody() + "%");
                WHERE("e_body LIKE #{essay.eBody}");
            }
            if (essay.geteType() != null) {
                WHERE("e_type = #{essay.eType}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
