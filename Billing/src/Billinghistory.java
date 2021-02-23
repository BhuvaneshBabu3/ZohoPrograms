import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Billinghistory {
    int billid,customer;
    double price,tax,balance;
    String date1;

    public Billinghistory(int billid, int customer, double price, double tax, double balance,String date1) {
        this.billid = billid;
        this.date1=date1;
        this.customer = customer;
        this.price = price;
        this.tax = tax;
        this.balance = balance;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
