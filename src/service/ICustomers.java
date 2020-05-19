package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomers {
    public List<Customer> selectAllCustomer();

    void insertCustomer(Customer customer) throws SQLException;

    Customer selectCustomer(String customerName);

    boolean updateCustomer(Customer customer) throws SQLException;

    boolean deleteCustomer(String customerName) throws SQLException;

    List<Customer> searchCustomer(String customerName) throws SQLException;


}
