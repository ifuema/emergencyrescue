package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.Admin;
import team.ghjly.emergencyrescue.mapper.AdminMapper;
import team.ghjly.emergencyrescue.service.AdminService;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    /**
     * 根据账号文本获取管理员隐私信息
     * @param aAccount
     * @return
     */
    @Override
    public Admin getAdminPrivateByAAccount(Integer aAccount) {
        return adminMapper.selectAdminPrivateByUAccount(aAccount);
    }
}
