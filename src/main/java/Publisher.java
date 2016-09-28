import redis.clients.jedis.Jedis;

public class Publisher
{
    public Publisher(Jedis jedis_, String name_)
    {

        name=name_;
        jedis=jedis_;


    }
    protected Jedis jedis;
    protected String name;
}
