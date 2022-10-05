package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.User;

public interface UserService {
    /**
     * 根据账号和密码获取用户信息
     * @param user
     * @return
     */
    User getUserByAccountAndPassword(User user);

    /**
     * 判断是否已存在用户
     * @param user
     * @return
     */
    boolean hasUser(User user);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int saveUser(User user);
}
