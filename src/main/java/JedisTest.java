import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);

        jedis.set("foo", "bar");
        String result = jedis.get("foo");

        jedis.close();

        System.out.println(result); // "bar"
    }
}