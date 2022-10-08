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


//    /**
//     * 根据账号和密码获取用户信息
//     * @param user
//     * @return
//     */
//    @Override
//    public User getUserByAccountAndPassword(User user) {
//        return userMapper.selectUserByAccountAndPassword(user);
//    }

    /**
     * 根据账号文本判断是否已存在用户
     * @param uAccount
     * @return
     */
    @Override
    public boolean checkUserByUAccountText(Integer uAccount) {
        Integer uId = userMapper.selectUIdByAccountText(uAccount);
        if (uId == null) {
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

    /**
     * 根据账号文本获取用户隐私信息
     * @param uAccount
     * @return
     */
    @Override
    public User getUserPrivateByUAccountText(Integer uAccount) {
        return userMapper.selectUserPrivateByUAccountText(uAccount);
    }
}
