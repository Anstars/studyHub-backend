package com.lizh.studyHub.once;
import java.util.Date;

import com.lizh.studyHub.mapper.UserMapper;
import com.lizh.studyHub.model.domain.User;
import com.lizh.studyHub.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * This class is for xxxx.
 *
 * @author Mr.Li
 * @version 2023-06-11 下午 04:19
 */

@Component
public class InsertUsers {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     */
   // @Scheduled(initialDelay = 5000,fixedRate = Long.MIN_VALUE)
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        System.out.println("gogogogogo");
        stopWatch.start();
        final int INSERT_NUM = 10000000;
        for (int i = 0; i < INSERT_NUM; i++){
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fakeUser");
            user.setAvatarUrl("https://img0.baidu.com/it/u=3830633511,2314021788&fm=253&fmt=auto&app=138&f=JPEG?w=569&h=500");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setProfile("123");
            user.setPhone("15012344321");
            user.setEmail("123@qq.com");
            user.setTags("[]");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("111111");
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());
    }
}
