import java.util.*;

public class Main extends Location {
    static ArrayList<Customer> customerArrayList=new ArrayList<Customer>();
    static ArrayList<TaxiHistory> taxiHistories=new ArrayList<TaxiHistory>();
    static Map<Integer,Integer> map=new HashMap<>();
    static int customer_Id=0,taxi_Id=0,taxi_count,temptaxi,currentLocation,tempTaxinum;
    public static void main(String[] args) {
        int opt,pick_location,drop_location,pick_time;
        String customer,phone_number;
        Customer customer1;
        TaxiHistory taxiHistory;
        Location location;
        Scanner obj=new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter 1-Booking taxi 2-See taxi details");
            opt=obj.nextInt();
            switch (opt)
            {
                case 1:
                    System.out.println("Enter pick up point : \n"+"1-a 2-b 3-c 4-d 5-e 6-f");
                    pick_location=obj.nextInt();

                    System.out.println("Enter drop point : \n"+"1-a 2-b 3-c 4-d 5-e 6-f");
                    drop_location=obj.nextInt();

                    System.out.println("Enter pick time");
                    pick_time=obj.nextInt();

                    obj.nextLine();
                    System.out.println("Enter customer name");
                    customer=obj.nextLine();

                    System.out.println("Enter phone number");
                    phone_number=obj.nextLine();

                    customer1=new Customer(customer_Id,customer,phone_number);
                    addNewCustomer(customer1,customer,phone_number,customer_Id);

                    dist=getDist(pick_location,drop_location);
                    drop_time=getDrop_time(pick_time);
                    cost=getCost(dist);

                    taxiHistory=new TaxiHistory(pick_location,drop_location,pick_time,drop_time,dist,cost,taxi_Id);
                    addNewTaxi(taxiHistory,taxi_Id,pick_location,drop_location,drop_time,dist,cost,pick_time);
                    break;
                case 2:
                    for (int j=0;j<taxi_Id;j++)
                    {
                        System.out.println("id : "+taxiHistories.get(j).getTaxi_Id()+"\t"+"dropLocation : "+
                                taxiHistories.get(j).getDrop_location()+
                                "\t"+"pick time"+taxiHistories.get(j).getPick_time()+"\t"+"drop time : "+taxiHistories.get(j).getDrop_time()
                        +"amount : "+taxiHistories.get(j).getCost());
                    }
            }
        }
    }

    private static void addNewTaxi(TaxiHistory taxiHistory, int taxi_id, int pick_location, int drop_location, int drop_time, int dist, int cost, int pick_time) {
        boolean check,count_check,check_nearLocation;
        check=checkAlreadyExistTaxi(taxi_id,pick_location, pick_time);
        if (!check)
        {
            check_nearLocation=checkNearByLocation(taxi_id,pick_time,pick_location);
            if (check_nearLocation)
            {
                count_check=checkNumberofTaxiAvailbility(taxi_Id, pick_time,currentLocation);
                if (count_check)
                {
                    taxiHistories.get(taxi_count).setDrop_location(drop_location);
                    taxiHistories.get(taxi_count).setCost(cost+taxiHistories.get(taxi_count).getCost());
                    taxiHistories.get(taxi_count).setDrop_time(drop_time);
                }
                else
                {
                   check=checkAlreadyExistTaxi(taxi_id,currentLocation,pick_time);
                   if (check)
                   {
                       taxiHistories.get(temptaxi).setDrop_location(drop_location);
                       taxiHistories.get(temptaxi).setCost(cost+taxiHistories.get(temptaxi).getCost());
                       taxiHistories.get(temptaxi).setDrop_time(drop_time);
                   }
                }
            }
            else
            {
                taxiHistory=new TaxiHistory(pick_location,drop_location,pick_time,drop_time,dist,cost,taxi_id);
                taxiHistories.add(taxi_id,taxiHistory);
                taxi_id++;
                taxi_Id=taxi_id;
            }
        }
        if (check)
        {
            count_check=checkNumberofTaxiAvailbility(taxi_Id, pick_time,pick_location);
            if (count_check)
            {
                taxiHistories.get(taxi_count).setDrop_location(drop_location);
                taxiHistories.get(taxi_count).setCost(cost+taxiHistories.get(taxi_count).getCost());
                taxiHistories.get(taxi_count).setDrop_time(drop_time);
            }
            else
            {
                taxiHistories.get(temptaxi).setDrop_location(drop_location);
                taxiHistories.get(temptaxi).setCost(cost+taxiHistories.get(temptaxi).getCost());
                taxiHistories.get(temptaxi).setDrop_time(drop_time);
            }
        }
    }

    private static boolean checkNearByLocation(int taxi_id, int pick_time, int pick_location) {
        boolean b=false;
        for (int j=0;j<taxi_Id;j++)
        {
            if (pick_location+1==taxiHistories.get(j).getDrop_location() &&
                    pick_time==taxiHistories.get(j).getDrop_time())
            {
                currentLocation=taxiHistories.get(j).getDrop_location();
                b=true;
            }
            else if (pick_location-1==taxiHistories.get(j).getDrop_location() &&
                    pick_time==taxiHistories.get(j).getDrop_time())
            {
                currentLocation=taxiHistories.get(j).getDrop_location();
                b=true;
            }
            else
            {
                b=false;
            }
        }
        return b;
    }

    private static boolean checkNumberofTaxiAvailbility(int taxi_id, int pick_time, int pick_location) {
        boolean b=false;
        int min,count=1;
        for (int j=0;j<taxi_id;j++)
        {
            if (pick_location==taxiHistories.get(j).getDrop_location() && pick_time>=taxiHistories.get(j).getDrop_time())
            {
                map.put(taxiHistories.get(j).getTaxi_Id(),taxiHistories.get(j).getCost());
                count++;
            }
        }
        if (count>1) {
            min = Collections.min(map.values());
            for(Map.Entry<Integer,Integer> entry:map.entrySet())
            {
                taxi_count= entry.getKey();
            }
            b=true;
        }
        return b;
    }

    private static boolean checkAlreadyExistTaxi(int taxi_id, int pick_location, int pick_time) {
        boolean b=false;
        for (int j=0;j<taxi_id;j++)
        {
            if (pick_location==taxiHistories.get(j).getDrop_location() && pick_time>=taxiHistories.get(j).getDrop_time())
            {
                temptaxi=taxiHistories.get(j).getTaxi_Id();
                b=true;
            }
        }
        return b;
    }

    private static void addNewCustomer(Customer customer1, String customer, String phone_number, int customer_id) {
        boolean check;
        check=checkalreadyexistCustomer(customer,phone_number,customer_id);
        if (!check)
        {
            customer1=new Customer(customer_id,customer,phone_number);
            customerArrayList.add(customer_id,customer1);
            customer_id++;
            customer_Id=customer_id;
        }
    }

    private static boolean checkalreadyexistCustomer(String customer, String phone_number, int customer_id) {
        boolean b=false;
        for (int j=0;j<customer_id;j++)
        {
            if (customerArrayList.get(j).getCustomer().equals(customer) &&
                phone_number.equals(customerArrayList.get(j).getPhone_number()))
            {
                b=true;
            }
            else if (customerArrayList.get(j).getCustomer().equals(customer) || !phone_number.equals(customerArrayList.get(j).getPhone_number()))
            {
                b=false;
            }
            else
            {
                b=false;
            }
        }
        return b;
    }
}
