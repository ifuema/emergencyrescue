package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.ghjly.emergencyrescue.entity.Commodity;

import java.util.List;

@Mapper
public interface CommodityMapper {
    @Select("select * from commodity")
    List<Commodity> get();
}
