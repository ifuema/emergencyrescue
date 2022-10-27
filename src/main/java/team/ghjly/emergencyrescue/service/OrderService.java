package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Order;

public interface OrderService {
    boolean saveOrder(Order order);

    boolean checkOrderByOTrade(String oTrade);
}
