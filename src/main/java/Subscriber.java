import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subscriber implements Runnable {
    @Override
    public void run() {

    }

    public Subscriber(Channel channel_ , Jedis jedis_, String name_)
    {
      name=name_;
      jedis=jedis_;
        channel=channel_;
        jedisPubSub=new JedisPubSub() {
            @Override
            public void onMessage(String s, String s1) {

            }

            @Override
            public void onPMessage(String s, String s1, String s2) {

            }

            @Override
            public void onSubscribe(String s, int i) {

            }

            @Override
            public void onUnsubscribe(String s, int i) {

            }

            @Override
            public void onPUnsubscribe(String s, int i) {

            }

            @Override
            public void onPSubscribe(String s, int i) {

            }
        };
      jedis.subscribe(jedisPubSub,channel.name);
    }

    protected Channel channel;
    protected Jedis jedis;
    protected JedisPubSub jedisPubSub;
    protected String name;
    protected Thread thread;

}
