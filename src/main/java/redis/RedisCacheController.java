package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ygzhang on 6/9/17.
 */
@RestController
@RequestMapping("/redis")
public class RedisCacheController {

    @Autowired
    private StringRedisTemplate template;

    private ValueOperations<String, String> ops;

    @RequestMapping("/test")
    public String getTestId() {
        String key = "spring.boot.redis.test";
        return this.getOps().get(key).toString();
    }

    @RequestMapping("/setUserName")
    public String setUserName(@RequestParam(value = "name", defaultValue = "kaka") String name) {
        this.getOps().set("name", name);
        return this.getOps().get("name").toString();
    }

    public ValueOperations<String, String> getOps() {
        return ops = this.template.opsForValue();
    }

}