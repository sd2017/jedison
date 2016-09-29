import redis.clients.jedis.Jedis;
public class PubSubTest {
    public PubSubTest( String  JEDIS_SERVER,PubSubReciever receiver_){
        receiver=receiver_;

        Channel   cs1=new Channel("white:");
        Channel   cs2=new Channel("black:");
        Subscriber s1=new Subscriber(JEDIS_SERVER,"s1:",cs1,receiver);
        Subscriber s2=new Subscriber(JEDIS_SERVER,"s2:",cs1,receiver);
        Subscriber s3=new Subscriber(JEDIS_SERVER,"s3:",cs2,receiver);


        Channel   cp1=new Channel("white:");
        Channel   cp2=new Channel("black:");
        Publisher p1=new Publisher(JEDIS_SERVER,"p1:",cp1,receiver);
        Publisher p2=new Publisher(JEDIS_SERVER,"p2:",cp2,receiver);
        Publisher p3=new Publisher(JEDIS_SERVER,"p3:",cp2,receiver);
try {
    Thread.sleep(1000);
}
catch (Exception ex)
{

}
        p1.Publish("[MESSAGE1]");
        p2.Publish("[MESSAGE2]");
        p3.Publish("[MESSAGE3]");
        try {
            Thread.sleep(1000);
        }
        catch (Exception ex)
        {

        }

        s1.info();
        s2.info();
        s3.info();
        System.out.println("calling unsubscribe:"+s1.name);
        s1.unsubscribe();
        s2.unsubscribe();
        s3.unsubscribe();

        System.out.println("finished PubSubTest ");


    }



    protected PubSubReciever receiver;
}
