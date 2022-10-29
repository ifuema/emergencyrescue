package team.ghjly.emergencyrescue.mapper.sql;

import org.apache.ibatis.jdbc.SQL;
import team.ghjly.emergencyrescue.entity.Order;

public class OrderMapperSqlProvider {
    public static String selectOrderListPageByOrderSql(final Order order) {
        return new SQL() {{
            SELECT("*").FROM("`order`");
            if (order.getcId() != null) {
                WHERE("c_id = #{order.cId}");
            }
            if (order.getuId() != null) {
                WHERE("u_id = #{order.uId}");
            }
            if (order.getoTelephone() != null) {
                WHERE("o_telephone = #{order.oTelephone}");
            }
            if (order.getoState() != null && order.getoState() != "") {
                WHERE("o_state = #{order.oState}");
            }
            if (order.getoName() != null && order.getoName() != "") {
                order.setoName("%" + order.getoName() + "%");
                WHERE("o_name LIKE #{order.oName}");
            }
            if (order.getoAddress() != null && order.getoAddress() != "") {
                order.setoAddress("%" + order.getoAddress() + "%");
                WHERE("o_address LIKE #{order.oAddress}");
            }
            if (order.getoTrade() != null && order.getoTrade() != "") {
                WHERE("o_trade = #{order.oTrade}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
