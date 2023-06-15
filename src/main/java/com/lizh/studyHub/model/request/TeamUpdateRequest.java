package com.lizh.studyHub.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is for xxxx.
 *
 * @author Mr.Li
 * @version 2023-06-15 下午 05:11
 */
@Data
public class TeamUpdateRequest implements Serializable{

    private static final long serialVersionUID = 5968917756880663990L;
    /**
     * id
     */
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;

    /**
     * 密码
     */
    private String password;

}
