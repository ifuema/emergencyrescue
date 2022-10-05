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
     * 根据账号和密码获取用户信息
     * @param user
     * @return
     */
    @Override
    public User getUserByAccountAndPassword(User user) {
        return userMapper.selectUserByAccountAndPassword(user);
    }

    /**
     * 判断是否已存在用户
     * @param user
     * @return
     */
    @Override
    public boolean hasUser(User user) {
        User dataUser = userMapper.selectUserByAccount(user);
        if (dataUser == null) {
            return false;
        }
        return true;
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public int saveUser(User user) {
        return userMapper.insertUser(user);
    }
}
