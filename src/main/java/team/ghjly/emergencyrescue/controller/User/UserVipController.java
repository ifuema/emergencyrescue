package team.ghjly.emergencyrescue.controller.User;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.ghjly.emergencyrescue.entity.Rescue;
import team.ghjly.emergencyrescue.vo.ResultCode;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.entity.groups.Regist;
import team.ghjly.emergencyrescue.service.RescueService;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/vip")
public class UserVipController {
    @Resource
    private UserService userService;
    @Resource
    private RescueService rescueService;
    private final ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");
    private final ResultVO<?> applyFailed = new ResultVO<>(ResultCode.FAILED, "申请失败！");

    /**
     * 获取已登录用户信息
     * @param request
     * @return
     */
    @GetMapping
    public ResultVO<?> my(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User dataUser = userService.getUserByUId(user.getuId());
        if (dataUser == null) {
            return userNotExist;
        }
        return new ResultVO<>(dataUser);
    }

    /**
     * 申请救援
     * @param rescue
     * @param request
     * @return
     */
    @PostMapping("/rescue")
    public ResultVO<?> requestRescue(@RequestBody @Validated({Regist.class}) Rescue rescue, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        rescue.setuId(user.getuId());
        if (rescueService.saveRescue(rescue)) {
            return new ResultVO<>(rescue.getrId());
        } else {
            return applyFailed;
        }
    }
}
