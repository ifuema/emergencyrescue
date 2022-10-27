package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import team.ghjly.emergencyrescue.entity.Order;

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
}
