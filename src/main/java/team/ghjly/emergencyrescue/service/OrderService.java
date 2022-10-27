package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Order;

import java.util.List;

public interface OrderService {
    /**
     * 新增订单
     * @param order
     * @return
     */
    boolean saveOrder(Order order);

    /**
     * 根据订单号文本判断是否已存在订单
     * @param oTrade
     * @return
     */
    boolean checkOrderByOTrade(String oTrade);

    /**
     * 根据用户id文本获取订单列表
     * @param uId
     * @return
     */
    List<Order> getOrderListByUId(Integer uId);
}
