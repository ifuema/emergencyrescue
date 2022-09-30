package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.User;

public interface UserService {
    /**
     * 登录功能
     * @param user
     * @return
     */
    User login(User user);
}
