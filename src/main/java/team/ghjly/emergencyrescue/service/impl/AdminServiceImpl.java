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
     * 根据账号和密码获取管理员信息
     * @param admin
     * @return
     */
    @Override
    public Admin getAdminByAccountAndPassword(Admin admin) {
        return adminMapper.selectAdminByAccountAndPassword(admin);
    }
}
