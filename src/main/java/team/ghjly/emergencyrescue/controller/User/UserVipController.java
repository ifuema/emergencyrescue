package team.ghjly.emergencyrescue.controller.User;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.ghjly.emergencyrescue.entity.Rescue;
import team.ghjly.emergencyrescue.entity.ResultCode;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.entity.groups.Regist;
import team.ghjly.emergencyrescue.service.RescueService;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/user/vip")
public class UserVipController {
    @Resource
    private UserService userService;
    @Resource
    private RescueService rescueService;
    private ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");
    private ResultVO<?> applyFailed = new ResultVO<>(ResultCode.FAILED, "申请失败！");

    /**
     * 获取已登录用户信息
     * @param request
     * @return
     */
    @GetMapping("/my")
    public ResultVO<?> my(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User dataUser = userService.getUserByUIdText(user.getUId());
        if (dataUser == null) {
            return userNotExist;
        }
        return new ResultVO<>(dataUser);
    }

    @PostMapping("/help")
    public ResultVO<?> help(@RequestBody @Validated({Regist.class}) Rescue rescue, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        rescue.setUId(user.getUId());
        if (rescueService.saveRescue(rescue)) {
            return new ResultVO<>(rescue.getRId());
        } else {
            return applyFailed;
        }
    }
}
