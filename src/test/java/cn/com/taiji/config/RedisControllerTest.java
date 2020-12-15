package cn.com.taiji.config;

import cn.com.taiji.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisControllerTest {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;// 通过构造方法注入该对象

    @GetMapping("/getdata")
    public Object getdata(){
        //测试redis

        redisUtil.set("name","小猫");
        System.out.println(redisUtil.getExpire("name"));
        return redisUtil.get("name");

    }
}
