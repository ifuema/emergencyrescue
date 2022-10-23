package team.ghjly.emergencyrescue.mapper.sql;

import org.apache.ibatis.jdbc.SQL;
import team.ghjly.emergencyrescue.entity.Commodity;

public class CommodityMapperSqlProvider {
    public static String selectCommodityListPageByCommoditySql(final Commodity commodity) {
        return new SQL() {{
            SELECT("*").FROM("commodity");
            if (commodity.getcName() != null && commodity.getcName() != "") {
                commodity.setcName("%" + commodity.getcName() + "%");
                WHERE("c_name LIKE #{commodity.cName}");
            }
            if (commodity.getcIntroduce() != null && commodity.getcIntroduce() != "") {
                commodity.setcIntroduce("%" + commodity.getcIntroduce() + "%");
                WHERE("c_introduce LIKE #{commodity.cIntroduce}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
