package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.*;
import team.ghjly.emergencyrescue.entity.Order;
import team.ghjly.emergencyrescue.mapper.sql.OrderMapperSqlProvider;

import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * 插入一条订单信息
     * @param order
     * @return
     */
    @Insert("INSERT INTO `order` (u_id, c_id, o_num, o_name, o_time, o_state, " +
            "o_telephone, o_address, o_price, o_trade, o_remake) VALUES " +
            "(#{uId}, #{cId}, #{oNum}, #{oName}, #{oTime}, #{oState}, " +
            "#{oTelephone}, #{oAddress}, #{oPrice}, #{oTrade}, #{oRemake})")
    @Options(useGeneratedKeys = true, keyProperty = "oId", keyColumn = "o_id")
    Integer insertOrder(Order order);

    /**
     * 根据订单编号文本查询订单id
     * @param oTrade
     * @return
     */
    @Select("SELECT o_id FROM `order` WHERE o_trade = #{oTrade}")
    Integer selectOIdByOTrade(String oTrade);

    /**
     * 根据id文本查询订单信息
     * @param uId
     * @return
     */
    @Select("SELECT * FROM `order` WHERE u_id = #{uId}")
    List<Order> selectOrderListByUId(Integer uId);

    /**
     * 根据过滤订单信息分页查询订单列表
     * @param pageSize
     * @param startIndex
     * @param order
     * @return
     */
    @SelectProvider(type = OrderMapperSqlProvider.class, method = "selectOrderListPageByOrderSql")
    List<Order> selectOrderListPageByOrder(int pageSize, Integer startIndex, Order order);
}
