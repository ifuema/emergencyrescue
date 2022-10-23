package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
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
}
