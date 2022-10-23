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
     * 根据账号文本判断是否已存在用户
     * @param uAccount
     * @return
     */
    @Override
    public boolean checkUserByUAccount(Integer uAccount) {
        Integer dataUId = userMapper.selectUIdByAccount(uAccount);
        if (dataUId == null) {
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
    public boolean saveUser(User user) {
        if (userMapper.insertUser(user) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据账号文本获取用户隐私信息
     * @param uAccount
     * @return
     */
    @Override
    public User getUserPrivateByUAccount(Integer uAccount) {
        return userMapper.selectUserPrivateByUAccount(uAccount);
    }

    /**
     * 根据账号密码判断是否已存在用户
     * @param user
     * @return
     */
    @Override
    public boolean checkUserByUAccountAndUPassword(User user) {
        Integer dataUId = userMapper.selectUIdByAccountAndPassword(user);
        if (dataUId == null) {
            return false;
        }
        return true;
    }

    /**
     * 根据id文本获取用户信息
     * @param uId
     * @return
     */
    @Override
    public User getUserByUId(Integer uId) {
        return userMapper.selectUserByUId(uId);
    }
}
