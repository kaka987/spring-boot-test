package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created by ygzhang on 6/9/17.
 */
@SpringBootApplication
public class SampleRedisApplication implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public void run(String... args) throws Exception {
        ValueOperations<String, String> ops = this.template.opsForValue();
        String key = "spring.boot.redis.test";
        if (!this.template.hasKey(key)) {
            ops.set(key, "Hello spring boot for redis");
            System.out.printf("Found key " + key + ", value = " + ops.get(key));
        }
    }

    public static void main (String[] args) throws Exception {
        SpringApplication.run(SampleRedisApplication.class, args);
    }
}
