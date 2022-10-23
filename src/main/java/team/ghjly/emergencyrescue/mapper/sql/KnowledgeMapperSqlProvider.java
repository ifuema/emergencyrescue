package team.ghjly.emergencyrescue.mapper.sql;

import org.apache.ibatis.jdbc.SQL;
import team.ghjly.emergencyrescue.entity.Knowledge;

public class KnowledgeMapperSqlProvider {
    public static String selectKnowledgeListPageByKnowledgeSql(final Knowledge knowledge) {
        return new SQL() {{
            SELECT("*").FROM("knowledge");
            if (knowledge.getkTitle() != null && knowledge.getkTitle() != "") {
                knowledge.setkTitle("%" + knowledge.getkTitle() + "%");
                WHERE("k_title LIKE #{knowledge.kTitle}");
            }
            if (knowledge.getkBody() != null && knowledge.getkBody() != "") {
                knowledge.setkBody("%" + knowledge.getkBody() + "%");
                WHERE("k_body LIKE #{knowledge.kBody}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
