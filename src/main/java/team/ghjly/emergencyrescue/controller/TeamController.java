package team.ghjly.emergencyrescue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.ghjly.emergencyrescue.entity.Essay;
import team.ghjly.emergencyrescue.entity.ResultCode;
import team.ghjly.emergencyrescue.entity.Team;
import team.ghjly.emergencyrescue.service.TeamService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Resource
    private TeamService teamService;
    private int pageSize = 10;
    private ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");


    /**
     * 分页获取救援队
     * @param pageNum
     * @param team
     * @return
     */
    @GetMapping("/page/{pageNum}")
    public ResultVO<?> page(@PathVariable Integer pageNum, Team team) {
        List<Team> teamList = teamService.getTeamPublicListPageByTeam(pageSize, pageNum, team);
        if (teamList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(teamList);
        }
    }
}
