
public class Channel {

    protected String name;
    protected int    counter;
    Channel(String name_)
    {
        counter = 0;
        name = name_;

    }

    protected synchronized int inc() {
        int counter_local = counter;
        counter = counter + 1;
        return counter_local;
    }
}
