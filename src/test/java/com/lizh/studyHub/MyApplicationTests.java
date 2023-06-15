package com.lizh.studyHub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class MyApplicationTests {

    @Test
    public void testDigest(){
        String newPassword = DigestUtils.md5DigestAsHex(("abc" + "mypassword").getBytes());
        System.out.println(newPassword);
    }

    @Test
    void contextLoads() {
    }

}
