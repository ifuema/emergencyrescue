package team.ghjly.emergencyrescue.mapper.sql;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import team.ghjly.emergencyrescue.entity.Knowledge;

public class KnowledgeMapperSqlProvider {
    public static String selectKnowledgeListPageByKnowledgeSql(final Knowledge knowledge) {
        return new SQL() {{
            SELECT("*").FROM("knowledge");
            if (knowledge.getKTitle() != null) {
                knowledge.setKTitle("%" + knowledge.getKTitle() + "%");
                WHERE("k_title LIKE #{knowledge.kTitle}");
            }
            if (knowledge.getKBody() != null) {
                knowledge.setKBody("%" + knowledge.getKBody() + "%");
                WHERE("k_body LIKE #{knowledge.kBody}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
