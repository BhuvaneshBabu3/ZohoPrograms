import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static PieceStock pieceStock;
    static ArrayList<PieceStock> pieceStockArrayList=new ArrayList<PieceStock>();
    static WeigthStock weigthStock;
    static ArrayList<WeigthStock> weigthStockArrayList=new ArrayList<WeigthStock>();
    static Customer customer1;
    static ArrayList<Customer> customerArrayList=new ArrayList<Customer>();
    static Billing billing;
    static ArrayList<Billing> billingArrayList =new ArrayList<Billing>();
    static Billinghistory billinghistory;
    static ArrayList<Billinghistory> billinghistoryArrayList=new ArrayList<Billinghistory>();
    static int pro_id=0,temp_proid,pro_id_wt=0,customer_id=0,billing_id=0;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int opt,product_cnt,flag,price;
        float rate,weight;
        double tax;
        String name,design,material,phone_number;
        int size,id;
        while (true)
        {
            System.out.println("Enter 1-add piece product 2-add weight product 3-add customer");
            opt=s.nextInt();
            switch (opt)
            {
                case 1:
                    name="tumbler";
                    design="a";
                    material="bronze";
                    size=5;
                    product_cnt=25;
                    tax=0.05;
                    rate=200;

                    addpieceproduct(name,design,material,size,product_cnt,tax,rate);

                    name="tumbler";
                    design="b";
                    material="bronze";
                    size=5;
                    product_cnt=25;
                    tax=0.05;
                    rate=250;

                    addpieceproduct(name,design,material,size,product_cnt,tax,rate);

                    name="tumbler";
                    design="a";
                    material="silver";
                    size=5;
                    product_cnt=25;
                    tax=0.05;
                    rate=150;

                    addpieceproduct(name,design,material,size,product_cnt,tax,rate);

                    name="tumbler";
                    design="a";
                    material="silver";
                    size=5;
                    product_cnt=25;
                    tax=0.05;
                    rate=150;

                    addpieceproduct(name,design,material,size,product_cnt,tax,rate);

                    break;
                case 2:
                    name="anda";
                    material="bronze";
                    rate=500;
                    product_cnt=10;
                    tax=0.05;
                    weight=10;

                    addWeightproduct(name,material,rate,product_cnt,tax,weight);

                    name="anda";
                    material="bronze";
                    rate=500;
                    product_cnt=10;
                    tax=0.05;
                    weight=10;

                    addWeightproduct(name,material,rate,product_cnt,tax,weight);

                    name="paanai";
                    material="bronze";
                    rate=500;
                    product_cnt=10;
                    tax=0.05;
                    weight=10;

                    addWeightproduct(name,material,rate,product_cnt,tax,weight);

                    name="paanai";
                    material="silver";
                    rate=500;
                    product_cnt=10;
                    tax=0.05;
                    weight=10;

                    addWeightproduct(name,material,rate,product_cnt,tax,weight);

                    name="paanai";
                    material="bronze";
                    rate=500;
                    product_cnt=10;
                    tax=0.05;
                    weight=10;

                    addWeightproduct(name,material,rate,product_cnt,tax,weight);
                    name="paanai";
                    material="bronze";
                    rate=500;
                    product_cnt=10;
                    tax=0.05;
                    weight=10;

                    addWeightproduct(name,material,rate,product_cnt,tax,weight);
                    break;
                case 3:
                    name="Babu";
                    phone_number="9876543212";
                    flag=addNewCustomer(name,phone_number);
                    if (flag==1)
                    {
                        id=temp_proid;
                    }
                    else
                    {
                        id=customer_id-1;
                    }

                    buyproducts(id);

                    name="ravi";
                    phone_number="9876543202";
                    flag=addNewCustomer(name,phone_number);
                    if (flag==1)
                    {
                        id=temp_proid;
                    }
                    else
                    {
                        id=customer_id-1;
                    }

                    buyproducts(id);

                    name="ravi";
                    phone_number="9876543202";
                    flag=addNewCustomer(name,phone_number);
                    if (flag==1)
                    {
                        id=temp_proid;
                    }
                    else
                    {
                        id=customer_id-1;
                    }

                    buyproducts(id);
                    name="kumar";
                    phone_number="9876443212";
                    flag=addNewCustomer(name,phone_number);
                    if (flag==1)
                    {
                        id=temp_proid;
                    }
                    else
                    {
                        id=customer_id-1;
                    }
                    for (int j=0;j<pro_id;j++)
                    {
                        System.out.println("product id : "+pieceStockArrayList.get(j).getId()
                                +" "
                                +"product name : "+pieceStockArrayList.get(j).getName());
                    }
                    System.out.println("Weight products : ");
                    for (int j=0;j<pro_id_wt;j++)
                    {
                        System.out.println("product id: "+weigthStockArrayList.get(j).getId()+
                                " "
                        +"product name : "+weigthStockArrayList.get(j).getName());
                    }
                    System.out.println();
                    break;
            }
        }
    }

    private static void buyproducts(int id) {
        int prodid,pro_cnt;
        float amountpaid;
        int discount=3;
        double tax,price,balance;
        prodid=2;
        pro_cnt=3;
        amountpaid=150;
        tax=pieceStockArrayList.get(prodid).getTax();
        price=pieceStockArrayList.get(prodid).getRate()*pro_cnt+((tax/100)*pieceStockArrayList.get(prodid).getRate());
        balance=price-amountpaid;
        billing =new Billing(billing_id,id,price,balance,tax,discount,4,prodid,pro_cnt);
        billingArrayList.add(billing_id,billing);

        billinghistory=new Billinghistory(billing_id,id,price,tax,balance,getDate());
        billinghistoryArrayList.add(billing_id,billinghistory);
        billing_id++;
        pieceStockArrayList.get(prodid).setCount(pieceStockArrayList.get(prodid).getCount()-pro_cnt);
        System.out.println();
        System.out.println();

    }

    private static  String getDate() {
        String date1;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date1=dtf.format(now);
        return date1;
    }

    private static int addNewCustomer(String name, String phone_number) {
        boolean check=false;
        int flag;
        check=checkCustomer(name,phone_number);
        if (!check)
        {
            customer1=new Customer(customer_id,name,phone_number);
            customerArrayList.add(customer_id,customer1);
            customer_id++;
            flag=0;
        }
        else
        {
            temp_proid=customer_id;
            flag=1;
        }
        return flag;
    }

    private static boolean checkCustomer(String name, String phone_number) {
        boolean b=false;
        for (int j=0;j<customer_id;j++)
        {
            if (customerArrayList.get(j).getCustomer().equals(name) && customerArrayList.get(j).getPhone_number().equals(phone_number))
            {
                b=true;
            }
        }
        return b;
    }

    private static void addWeightproduct(String name, String material, float rate, int product_cnt, double tax, float weigth) {
        boolean check=false;
        check=checkweightProduct(name,material,weigth);
        if (check)
        {
            weigthStockArrayList.get(temp_proid).setCount(weigthStockArrayList.get(temp_proid).getCount()+product_cnt);
        }
        else
        {
            weigthStock=new WeigthStock(name,material,rate,weigth,product_cnt,pro_id_wt,tax);
            weigthStockArrayList.add(pro_id_wt,weigthStock);
            pro_id_wt++;
        }
    }

    private static boolean checkweightProduct(String name, String material, float weigth) {
        boolean b=false;
        for (int j=0;j<pro_id_wt;j++)
        {
            if (weigthStockArrayList.get(j).getName().equals(name) && weigthStockArrayList.get(j).getMaterial().equals(material) &&
                weigthStockArrayList.get(j).getWeight()>=weigth && weigthStockArrayList.get(j).getWeight()<weigth+1)
            {
                b=true;
                temp_proid=weigthStockArrayList.get(j).getId();
            }
        }
        return b;
    }


    private static void addpieceproduct(String name, String design, String material, int size, int product_cnt, double tax, float rate) {
        boolean check=false;
        check=checkproduct(name,design,material,size);
        if (check)
        {
            pieceStockArrayList.get(temp_proid).setCount(pieceStockArrayList.get(temp_proid).getCount()+product_cnt);
        }
        else
        {
            pieceStock=new PieceStock(product_cnt,tax,pro_id,rate,size,design,material,name);
            pieceStockArrayList.add(pro_id,pieceStock);
            pro_id++;
        }
    }

    private static boolean checkproduct(String name, String design, String material, int size) {
        boolean b=false;
        for (int j=0;j<pro_id;j++)
        {
            if (pieceStockArrayList.get(j).getName().equals(name) && pieceStockArrayList.get(j).getMaterial().equals(material) &&
            pieceStockArrayList.get(j).getDesign().equals(design) && pieceStockArrayList.get(j).getSize()==size)
            {
                b=true;
                temp_proid=pieceStockArrayList.get(j).getId();
            }
        }
        return b;
    }
}
