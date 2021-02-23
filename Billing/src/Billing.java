import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Billing {
//    String date1,year,date,month,hour,min,sec;
    double price,balance,tax;
    int discount,extraService,bill_id,customer_id,prod_id,prod_cnt;

//    public Billing(int bill_id, int customer_id, String date1) {
//        this.bill_id = bill_id;
//        this.customer_id = customer_id;
//        this.date1 = date1;
//    }

    public Billing(int bill_id, int customer_id, double price, double balance, double tax, int discount, int extraService,int prod_id,int prod_cnt) {
        this.prod_cnt=prod_cnt;
        this.prod_id=prod_id;
        this.bill_id = bill_id;
        this.customer_id = customer_id;
        this.price = price;
        this.balance = balance;
        this.tax = tax;
        this.discount = discount;
        this.extraService = extraService;
    }

//    public Billing(String date1, String year, String date, String month, String hour, String min, String sec) {
//        this.date1 = date1;
//        this.year = year;
//        this.date = date;
//        this.month = month;
//        this.hour = hour;
//        this.min = min;
//        this.sec = sec;
//    }

    public int getProd_cnt() {
        return prod_cnt;
    }

    public void setProd_cnt(int prod_cnt) {
        this.prod_cnt = prod_cnt;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

   /* public String getDate1() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date1=dtf.format(now);
        return date1;
    }

    public String getYear() {
        year=getDate1().substring(0,4);
        return year;
    }

    public String getDate() {
        date=getDate1().substring(5,7);
        return date;
    }

    public String getMonth() {
        month=getDate1().substring(8,10);
        return month;
    }

    public String getHour() {
        hour=getDate1().substring(11,13);
        return hour;
    }

    public String getMin() {
        min=getDate1().substring(14,16);
        return min;
    }

    public String getSec() {
        sec=getDate1().substring(17,19);
        return sec;
    }*/

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getExtraService() {
        return extraService;
    }

    public void setExtraService(int extraService) {
        this.extraService = extraService;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }
}
