    import redis.clients.jedis.Jedis;

    import java.net.URL;
    import java.net.URLClassLoader;

    public class HelloWorld
    {
       public static void main (String args []) {
           ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();


           URL[] urls = ((URLClassLoader) sysClassLoader).getURLs();

           for (int i = 0; i < urls.length; i++) {
               System.out.println("JAVA CP" + urls[i].getFile());
           }


           String env="REDIS_SERVER";
           String value = System.getenv(env);
           if (value != null) {
               System.out.format("$%s=%s%n",
                       env, value);
           } else {
               System.out.format("$%s is"
                       + " not assigned.%n", env);
           }


           String JEDIS_SERVER=null;
               if (value !=null)
               {
                    JEDIS_SERVER = "redis";
               }
               else
               {
                    JEDIS_SERVER = "localhost";
               }
           System.out.println("jedison 0.3.6 in main before new jedis :"+JEDIS_SERVER);

        Jedis jedis = new Jedis(JEDIS_SERVER);
           System.out.println("Server is running 1 : "+jedis.ping());
           //while (false) {
           // System.out.println("Server is running: "+jedis.ping());
        //}
      }
    }
