import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subscriber extends JedisPubSub implements Runnable {

    public Subscriber(Jedis jedis_, String name_,Channel channel_,PubSubReciever receiver_) {
        name = name_;
        jedis = jedis_;
        channel = channel_;
        Thread thread = new Thread(this);

    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        log("onUnsubscribe");
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        log("onSubscribe");
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
    }

    @Override
    public void onMessage(String channel, String message) {
        //messageContainer.add(message);
        log(message, this.channel.name);
        //messageReceivedLatch.countDown();
    }


    public void run() {
        try {
            log("Connecting");
            log("subscribing");
            jedis.subscribe(this, channel.name);
            log("subscribe returned, closing down");
            jedis.quit();
        } catch (Exception e) {
            log(">>> OH NOES Sub - " + e.getMessage());
            // e.printStackTrace();
        }
    }


    static final long startMillis = System.currentTimeMillis();

    private static void log(String string, Object... args) {
        long millisSinceStart = System.currentTimeMillis() - startMillis;
        System.out.printf("%20s %6d %s\n", Thread.currentThread().getName(), millisSinceStart,
                String.format(string, args));
    }


protected Channel channel;
protected Jedis jedis;
protected JedisPubSub jedisPubSub;
protected String name;
protected Thread thread;

        }
