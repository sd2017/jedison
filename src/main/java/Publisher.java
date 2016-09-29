import redis.clients.jedis.Jedis;

public class Publisher
{
    public Publisher(Jedis jedis_, String name_,Channel channel_,PubSubReciever receiver_)
    {

        name=name_;
        jedis=jedis_;
        channel=channel_;
        receiver=receiver_;

    }

    public void Publish(String string){
        jedis.publish(channel.name, name+"This is a message"+channel.inc());
        receiver.addPublished();
    }

    protected Jedis jedis;
    protected String name;
    protected Channel channel;
    protected PubSubReciever receiver;
}
