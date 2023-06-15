package com.lizh.studyHub.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用删除请求信息
 *
 * @author Mr.Li
 * @version 2023-06-14 下午 04:35
 */
@Data
public class DeleteRequest implements Serializable {


    private static final long serialVersionUID = 8121439134013854654L;

    private long id;
}
