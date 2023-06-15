package com.lizh.studyHub.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lizh.studyHub.model.VO.TeamUserVO;
import com.lizh.studyHub.model.domain.Team;
import com.lizh.studyHub.model.domain.User;
import com.lizh.studyHub.model.dto.TeamQuery;
import com.lizh.studyHub.model.request.TeamJoinRequest;
import com.lizh.studyHub.model.request.TeamQuitRequest;
import com.lizh.studyHub.model.request.TeamUpdateRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Mr.Li
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2023-06-14 14:56:00
*/
public interface TeamService extends IService<Team> {
    /**
     * 创建队伍
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery,boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest,User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest,User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除（解散）队伍
     * @param teamId
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long teamId,User loginUser);

}
