public class Customer {
    String customer,phone_number;
    int customer_Id;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Customer(int customer_Id, String customer, String phone_number) {
        this.customer=customer;
        this.phone_number=phone_number;
        this.customer_Id=customer_Id;
    }
}
