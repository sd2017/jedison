import redis.clients.jedis.Jedis;

import java.net.URL;
import java.net.URLClassLoader;

public class HelloWorld
{
   public static void main (String args [])
   {
       ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();


       URL[] urls = ((URLClassLoader)sysClassLoader).getURLs();

       for(int i=0; i< urls.length; i++)
       {
           System.out.println("JAVA CP"+urls[i].getFile());
       }
       System.out.println("jedison 0.3 in main before new jedis ");

    Jedis jedis = new Jedis("localhost_1");
       System.out.println("Server is running 1 : "+jedis.ping());
       //while (false) {
       // System.out.println("Server is running: "+jedis.ping());
	//}
  }
}  
