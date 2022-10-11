package team.ghjly.emergencyrescue.controller.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.ghjly.emergencyrescue.entity.ResultCode;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/vip")
public class UserVipController {
    @Resource
    UserService userService;
    private ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");



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
}
