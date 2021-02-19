public class Location {
    static int drop_time,pick_time,drop_location,pick_location,dist,cost;
    Location()
    {

    }
    public static int getDist(int pick_location,int drop_location)
    {
        if (pick_location>drop_location)
        {
            dist=(pick_location-drop_location)*15;
        }
        else
        {
            dist=(drop_location-pick_location)*15;
        }
        return dist;
    }
    public static int getCost(int dist)
    {
        cost=(dist-5)*10+100;
        return cost;
    }
    public static int getDrop_time(int pick_time)
    {
        drop_time=pick_time+dist/15;
        if (drop_time>24)
        {
            drop_time=drop_time-24;
        }
        return drop_time;
    }


}
