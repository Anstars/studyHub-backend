package com.lizh.studyHub.service;

import com.lizh.studyHub.mapper.UserMapper;
import com.lizh.studyHub.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * This class is for xxxx.
 *
 * @author Mr.Li
 * @version 2023-06-11 下午 04:43
 */
@SpringBootTest
public class InsertUsersTest {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    /**
     * 批量插入用户
     */
    // @Scheduled(initialDelay = 5000,fixedRate = Long.MIN_VALUE)
    @Test
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000;
        List<User> userList = new ArrayList<>();
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
            user.setPlanetCode("1111    11");
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());
    }

    //多线程并发
    @Test
    public void doConcurrencyInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        //分十组
        int batchSize = 5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            List<User> userList = new ArrayList<>();
            while(true){
                j++;
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
                userList.add(user);
                if (j % 10000 == 0){
                    break;
                }
            }
            //异步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("ThreadName:" + Thread.currentThread().getName());
                userService.saveBatch(userList,batchSize);
            });
            futureList.add(future);

        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();


        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());
    }
}
