package jar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping(value = "sendMessage/{msg}")
    public void submitMessage(@PathVariable(value = "msg") String message) {
        redisTemplate.convertAndSend("chat", message);
    }

    @PostMapping(value = "saveValue/{value}")
    public void saveValue(@PathVariable(value = "value") String value) {
        redisTemplate.opsForValue().set(value, value + System.currentTimeMillis());
    }

    @GetMapping(value = "getValue/{value}")
    public String getValue(@PathVariable(value= "value") String value) {
        return redisTemplate.opsForValue().get(value);
    }
}
