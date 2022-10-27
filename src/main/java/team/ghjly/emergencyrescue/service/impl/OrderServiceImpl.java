package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.Order;
import team.ghjly.emergencyrescue.mapper.OrderMapper;
import team.ghjly.emergencyrescue.service.OrderService;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public boolean saveOrder(Order order) {
        order.setoTime(new Timestamp(System.currentTimeMillis()));
        order.setoState("已下单");
        if (orderMapper.insertOrder(order) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkOrderByOTrade(String oTrade) {
        Integer dataOId = orderMapper.selectOIdByOTrade(oTrade);
        if (dataOId == null) {
            return false;
        }
        return true;
    }
}
