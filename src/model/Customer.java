package model;
public class Customer {
    private String customerName;
    private String customerPass;
    private String phone;
    private String email;
    private String address;

    public Customer() {

    }

    public Customer(String customerName, String customerPass, String phone, String email, String address) {
        this.customerName = customerName;
        this.customerPass = customerPass;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPass() {
        return customerPass;
    }

    public void setCustomerPass(String customerPass) {
        this.customerPass = customerPass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
