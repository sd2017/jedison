import redis.clients.jedis.Jedis;

public class HelloWorld
{
   public static void main (String args [])
   {
       System.out.println("jedison 0.2 in main before new jedis ");
    Jedis jedis = new Jedis("redis");

       while (true) {
        System.out.println("Server is running: "+jedis.ping());
	}
  }
}  
