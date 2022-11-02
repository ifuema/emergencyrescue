package team.ghjly.emergencyrescue.config.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import team.ghjly.emergencyrescue.entity.Admin;
import team.ghjly.emergencyrescue.service.AdminService;
import team.ghjly.emergencyrescue.vo.ResultCode;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Resource
    private AdminService adminService;
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
        Admin sessionAdmin = (Admin) session.getAttribute("admin");
        if (sessionAdmin == null) {
            try {
                response.getWriter().write(notLoginJson);
            } catch (IOException e) {
            }
            return false;
        } else {
            Integer dataAId = adminService.getAIdByAAccountAndAPassword(sessionAdmin);
            if (dataAId == null) {
                try {
                    response.getWriter().write(stateInvalidJson);
                } catch (IOException e) {
                }
                return false;
            } else {
                sessionAdmin.setaId(dataAId);
                return true;
            }
        }
    }
}
