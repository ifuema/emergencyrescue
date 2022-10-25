package team.ghjly.emergencyrescue.controller.Admin;

import org.springframework.web.bind.annotation.*;
import team.ghjly.emergencyrescue.entity.Rescue;
import team.ghjly.emergencyrescue.entity.Team;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.service.RescueService;
import team.ghjly.emergencyrescue.service.TeamService;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultCode;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/vip")
public class AdminVipController {
    @Resource
    private UserService userService;
    @Resource
    private TeamService teamService;
    @Resource
    private RescueService rescueService;
    private int pageSize = 5;
    private final ResultVO<?> success = new ResultVO<>();
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");
    private final ResultVO<?> deleteFailed = new ResultVO<>(ResultCode.FAILED, "删除失败！");
    /**
     * 分页获取用户
     * @param pageNum
     * @param user
     * @return
     */
    @GetMapping("/user/page/{pageNum}")
    public ResultVO<?> userPage(@PathVariable Integer pageNum, User user) {
        List<User> dataUserList = userService.getUserListPageByUser(pageSize, pageNum, user);
        if (dataUserList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataUserList);
        }
    }

    /**
     * 删除救援队
     * @param tId
     * @return
     */
    @DeleteMapping("/team/{tId}")
    public ResultVO<?> deleteTeam(@PathVariable Integer tId) {
        if (teamService.removeTeamByTId(tId)) {
            return success;
        } else {
            return deleteFailed;
        }
    }

    @GetMapping("/rescue/page/{pageNum}")
    public ResultVO<?> rescuePage(@PathVariable Integer pageNum, Rescue rescue) {
        List<Rescue> dataRescueList = rescueService.getRescueListPageByRescue(pageSize, pageNum, rescue);
        if (dataRescueList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataRescueList);
        }
    }
}
