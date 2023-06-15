package com.lizh.studyHub.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户加入请求体
 *
 * @author Mr.Li
 * @version 2023-06-15 下午 05:11
 */
@Data
public class TeamJoinRequest implements Serializable{

    private static final long serialVersionUID = 5968917756880663990L;
    /**
     * id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;

}
