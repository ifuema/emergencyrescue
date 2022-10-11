package team.ghjly.emergencyrescue.config.interceptor;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import team.ghjly.emergencyrescue.entity.ResultCode;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class UserInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userService;
    private String stateInvalidJson = JSON.toJSONString(new ResultVO<>(ResultCode.PERMISSION_REGECT, "登录已过期！"), JSONWriter.Feature.WriteMapNullValue);
    private String notLoginJson = JSON.toJSONString(new ResultVO<>(ResultCode.PERMISSION_REGECT, "未登录！"), JSONWriter.Feature.WriteMapNullValue);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.getWriter().write(notLoginJson);
            return false;
        } else {
            boolean result = userService.checkUserByUAccountAndUPassword(user);
            if (!result) {
                response.getWriter().write(stateInvalidJson);
                return false;
            } else {
                return true;
            }
        }
    }
}
