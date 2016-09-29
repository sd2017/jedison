import redis.clients.jedis.Jedis;
public class PubSubTest {
    public PubSubTest( Jedis jedis_,PubSubReciever receiver_){
        receiver=receiver_;
        jedis=jedis_;

        Channel   cp1=new Channel("white");
        Publisher p1=new Publisher(jedis,"p1",cp1,receiver);

        Channel   cp2=new Channel("white");
        Subscriber s1=new Subscriber(jedis,"s1",cp2,receiver);

        p1.Publish("white");



    }


    protected Jedis jedis;
    protected PubSubReciever receiver;
}
