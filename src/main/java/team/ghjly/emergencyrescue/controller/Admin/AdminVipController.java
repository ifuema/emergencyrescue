package team.ghjly.emergencyrescue.controller.Admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultCode;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/vip")
public class AdminVipController {
    @Resource
    UserService userService;
    private int pageSize = 5;
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");

    @GetMapping("/user/page/{pageNum}")
    public ResultVO<?> page(@PathVariable Integer pageNum, User user) {
        List<User> dataUserList = userService.getUserListPageByUser(pageSize, pageNum, user);
        if (dataUserList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataUserList);
        }
    }
}
