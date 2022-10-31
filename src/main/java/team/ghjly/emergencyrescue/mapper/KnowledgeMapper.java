package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.*;
import team.ghjly.emergencyrescue.entity.Knowledge;
import team.ghjly.emergencyrescue.mapper.sql.EssayMapperSqlProvider;
import team.ghjly.emergencyrescue.mapper.sql.KnowledgeMapperSqlProvider;

import java.util.List;

@Mapper
public interface KnowledgeMapper {
    /**
     * 根据过滤小知识信息分页查询小知识列表
     * @param pageSize
     * @param startIndex
     * @param knowledge
     * @return
     */
    @SelectProvider(type = KnowledgeMapperSqlProvider.class, method = "selectKnowledgeListPageByKnowledgeSql")
    List<Knowledge> selectKnowledgeListPageByKnowledge(int pageSize, Integer startIndex, Knowledge knowledge);

    @Select("SELECT k_id FROM knowledge WHERE k_id = #{kId}")
    Integer selectKIdByKId(Integer kId);

    @Delete("DELETE FROM knowledge WHERE k_id = #{kId}")
    Integer deleteKnowledgeByKId(Integer kId);

    @Insert("INSERT INTO knowledge (k_title, k_body) VALUES (#{kTitle}, #{kBody})")
    @Options(useGeneratedKeys = true, keyProperty = "kId", keyColumn = "k_id")
    Integer insertKnowledge(Knowledge knowledge);
}
