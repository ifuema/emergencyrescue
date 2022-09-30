package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.mapper.UserMapper;
import team.ghjly.emergencyrescue.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 登录功能
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userMapper.selectUserFromAccountAndPassword(user);
    }
}
