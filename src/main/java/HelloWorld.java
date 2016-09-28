import redis.clients.jedis.Jedis;

public class HelloWorld
{
   public static void main (String args [])
   {
       System.out.println("jedison 0.2 in main before new jedis ");
    Jedis jedis = new Jedis("redis");
       System.out.println("Server is running 1 : "+jedis.ping());
       //while (false) {
       // System.out.println("Server is running: "+jedis.ping());
	//}
  }
}  
