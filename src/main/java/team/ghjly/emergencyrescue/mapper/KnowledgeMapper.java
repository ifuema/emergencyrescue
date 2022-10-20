package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import team.ghjly.emergencyrescue.entity.Knowledge;
import team.ghjly.emergencyrescue.mapper.sql.EssayMapperSqlProvider;
import team.ghjly.emergencyrescue.mapper.sql.KnowledgeMapperSqlProvider;

import java.util.List;

@Mapper
public interface KnowledgeMapper {
    @SelectProvider(type = KnowledgeMapperSqlProvider.class, method = "selectKnowledgeListPageByKnowledgeSql")
    List<Knowledge> selectKnowledgeListPageByKnowledge(int pageSize, Integer startIndex, Knowledge knowledge);
}
