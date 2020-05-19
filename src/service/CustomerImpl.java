package service;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements ICustomers {

    private String url = "jdbc:mysql://localhost:3306/lucy_shop";
    private String user = "root";
    private String pass = "";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer (customerName, customerPass,Phone,Email,Address) VALUES (?, ?, ?,?,?);";
    private static final String DELETE_Customer_SQL = "delete from customer where customerName = ?;";
    private static final String SELECT_CUSTOMER_NAME = "select customerName,customerPass,Phone,Email,Address from customer where customerName = ? ;";
    private static final String UPDATE_CUSTOMER_NAME = "update customer set  customerPass = ?,Phone = ?,Email = ? ,Address = ? where customerName = ?";

    public CustomerImpl() {

    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            printSQLException(throwables);
        }
        return connection;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customer = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("customerName");
                String pass = rs.getString("customerPass");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String address = rs.getString("Address");
                customer.add(new Customer(name, pass, phone, email, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerPass());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            printSQLException(ex);
        }
    }

    @Override
    public Customer selectCustomer(String customerName) {
        Customer customer = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_NAME);
            preparedStatement.setString(1, customerName);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("customerName");
                String pass = resultSet.getString("customerPass");
                String phone = resultSet.getString("Phone");
                String email = resultSet.getString("Email");
                String address = resultSet.getNString("Address");
                customer = new Customer(name, pass, phone, email, address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdate = false;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_NAME);
            preparedStatement.setString(5, customer.getCustomerName());
            preparedStatement.setString(1, customer.getCustomerPass());
            preparedStatement.setString(2, customer.getPhone());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getAddress());
            rowUpdate = preparedStatement.executeUpdate() > 0;
            System.out.println(preparedStatement);
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteCustomer(String customerName) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_Customer_SQL);) {
            statement.setString(1, customerName);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Customer> searchCustomer(String customerName) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = getConnection();
        String  sql = "{call getFindByName(?)}";
        CallableStatement callableStatement = connection.prepareCall(sql);
        String name1 = "%" + customerName + "%";
        callableStatement.setString(1, name1);
        ResultSet resultSet = callableStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("customerName");
            String pass = resultSet.getString("customerPass");
            String phone = resultSet.getString("Phone");
            String email = resultSet.getString("Email");
            String address = resultSet.getString("Address");
            customerList.add(new Customer(name, pass, phone, email, address));
        }
        return customerList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
