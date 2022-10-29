package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.Order;
import team.ghjly.emergencyrescue.mapper.OrderMapper;
import team.ghjly.emergencyrescue.service.OrderService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    /**
     * 新增订单
     * @param order
     * @return
     */
    @Override
    public boolean saveOrder(Order order) {
        order.setoTime(Instant.now());
        order.setoState("已下单");
        if (orderMapper.insertOrder(order) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据订单号文本判断是否已存在订单
     * @param oTrade
     * @return
     */
    @Override
    public boolean checkOrderByOTrade(String oTrade) {
        Integer dataOId = orderMapper.selectOIdByOTrade(oTrade);
        if (dataOId == null) {
            return false;
        }
        return true;
    }

    /**
     * 根据用户id文本获取订单列表
     * @param uId
     * @return
     */
    @Override
    public List<Order> getOrderListByUId(Integer uId) {
        return orderMapper.selectOrderListByUId(uId);
    }

    /**
     * 根据过滤订单信息分页获取订单列表
     * @param pageSize
     * @param pageNum
     * @param order
     * @return
     */
    @Override
    public List<Order> getROrderListPageByOrder(int pageSize, Integer pageNum, Order order) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return orderMapper.selectOrderListPageByOrder(pageSize, startIndex, order);
    }
}
