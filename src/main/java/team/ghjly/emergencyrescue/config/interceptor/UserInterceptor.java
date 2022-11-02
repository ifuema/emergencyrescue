package team.ghjly.emergencyrescue.config.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import team.ghjly.emergencyrescue.vo.ResultCode;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class UserInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userService;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String stateInvalidJson = "";
    private String notLoginJson = "";

    {
        try {
            stateInvalidJson = objectMapper.writeValueAsString(new ResultVO<>(ResultCode.PERMISSION_REGECT, "登录已过期！"));
            notLoginJson = objectMapper.writeValueAsString(new ResultVO<>(ResultCode.PERMISSION_REGECT, "未登录！"));
        } catch (JsonProcessingException e) {
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        response.setContentType("application/json;charset=UTF-8");
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            try {
                response.getWriter().write(notLoginJson);
            } catch (IOException e) {
            }
            return false;
        } else {
            Integer dataUId = userService.getUIdByUAccountAndUPassword(sessionUser);
            if (dataUId == null) {
                try {
                    response.getWriter().write(stateInvalidJson);
                } catch (IOException e) {
                }
                return false;
            } else {
                sessionUser.setuId(dataUId);
                return true;
            }
        }
    }
}
