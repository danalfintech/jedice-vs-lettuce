import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class LettuceTest {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create(RedisURI.create("redis://localhost/"));
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> sync = connection.sync();

        sync.set("foo", "bar");

        String result = sync.get("foo");

        connection.close();
        redisClient.shutdown();

        System.out.println(result); // "bar"
    }
}
