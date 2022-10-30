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

    /**
     * 根据账号密码判断是否已存在管理员
     * @param admin
     * @return
     */
    @Override
    public boolean checkUserByAAccountAndAPassword(Admin admin) {
        Integer dataUId = adminMapper.selectAIdByAAccountAndAPassword(admin);
        if (dataUId == null) {
            return false;
        }
        return true;
    }

    /**
     * 根据id文本获取管理员信息
     * @param getaId
     * @return
     */
    @Override
    public Admin getAdminByAId(Integer aId) {
        return adminMapper.selectAdminByAId(aId);
    }
}
