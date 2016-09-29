import redis.clients.jedis.Jedis;

public class Publisher
{
    public Publisher(String JEDIS_SERVER, String name_,Channel channel_,PubSubReciever receiver_)
    {

        name=name_;
        jedis= new Jedis(JEDIS_SERVER);;
        channel=channel_;
        receiver=receiver_;

    }

    public void Publish(String string){
        jedis.publish(channel.name, name+string+channel.inc());
        System.out.println("published:"+name+":"+channel.name);
        receiver.addPublished();
    }

    protected Jedis jedis;
    protected String name;
    protected Channel channel;
    protected PubSubReciever receiver;
}
