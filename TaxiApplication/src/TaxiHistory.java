public class TaxiHistory {
    int pick_location,drop_location,pick_time,drop_time,dist,cost,taxi_Id;

    public int getPick_location() {
        return pick_location;
    }

    public void setPick_location(int pick_location) {
        this.pick_location = pick_location;
    }

    public int getDrop_location() {
        return drop_location;
    }

    public void setDrop_location(int drop_location) {
        this.drop_location = drop_location;
    }

    public int getPick_time() {
        return pick_time;
    }

    public void setPick_time(int pick_time) {
        this.pick_time = pick_time;
    }

    public int getDrop_time() {
        return drop_time;
    }

    public void setDrop_time(int drop_time) {
        this.drop_time = drop_time;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTaxi_Id() {
        return taxi_Id;
    }

    public void setTaxi_Id(int taxi_Id) {
        this.taxi_Id = taxi_Id;
    }

    public TaxiHistory(int pick_location, int drop_location, int pick_time, int drop_time, int dist, int cost, int taxi_Id) {
        this.pick_location=pick_location;
        this.dist=dist;
        this.drop_location=drop_location;
        this.pick_time=pick_time;
        this.drop_time=drop_time;
        this.cost=cost;
        this.taxi_Id=taxi_Id;
    }
}
