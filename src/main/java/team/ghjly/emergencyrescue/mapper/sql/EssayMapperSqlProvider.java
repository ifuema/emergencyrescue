package team.ghjly.emergencyrescue.mapper.sql;

import org.apache.ibatis.jdbc.SQL;
import team.ghjly.emergencyrescue.entity.Essay;

public class EssayMapperSqlProvider {
    public static String selectEssayListPageByEssaySql(final Essay essay) {
        return new SQL() {{
            SELECT("*").FROM("essay");
            if (essay.getETitle() != null) {
                essay.setETitle("%" + essay.getETitle() + "%");
                WHERE("e_title LIKE #{essay.eTitle}");
            }
            if (essay.getEType() != null) {
                WHERE("e_type = #{essay.eType}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
