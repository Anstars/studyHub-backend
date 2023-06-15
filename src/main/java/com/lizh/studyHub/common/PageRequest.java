package com.lizh.studyHub.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用分页请求信息
 *
 * @author Mr.Li
 * @version 2023-06-14 下午 04:35
 */
@Data
public class PageRequest implements Serializable {


    private static final long serialVersionUID = 8121439134013854654L;
    /**
     * 分页大小
     */
    protected int pageSize = 10;

    /**
     * 当前是第几页
     */
    protected int pageNum = 1;
}
