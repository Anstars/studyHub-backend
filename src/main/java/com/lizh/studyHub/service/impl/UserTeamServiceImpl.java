package com.lizh.studyHub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lizh.studyHub.mapper.UserTeamMapper;
import com.lizh.studyHub.model.domain.UserTeam;
import com.lizh.studyHub.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author Mr.Li
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2023-06-14 14:55:32
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}




