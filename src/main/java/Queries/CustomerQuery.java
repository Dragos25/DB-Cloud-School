package Queries;

import Data.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerQuery {
    private static Connection connection;
    public static void setConnection(Connection _connection){
        connection = _connection;
    }
    public static Customer getById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM customers WHERE id = ?;");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
            return resultToCustomer(rs);
        return null;
    }

    public static ArrayList<Customer> getAll() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM customers;");
        ResultSet rs = ps.executeQuery();
        ArrayList<Customer> customers = new ArrayList<>();
        while(rs.next())
            customers.add(resultToCustomer(rs));
        return customers;
    }

    public static void insert(Customer customer) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into customers(last_name, first_name, phone, address, city, postalCode, country, username) values(?, ?, ?, ?, ?, ?, ?, ?);");
        ps.setString(1,customer.getLastName());
        ps.setString(2,customer.getFirstName());
        ps.setString(3,customer.getPhone());
        ps.setString(4,customer.getAddress());
        ps.setString(5,customer.getCity());
        ps.setString(6,customer.getPostalCode());
        ps.setString(7,customer.getCountry());
        ps.setString(8,customer.getUsername());
        ps.execute();
    }

    public static void update(int id, Customer customer) throws SQLException{
        PreparedStatement ps = connection.prepareStatement("update customers set username = ?," +
                "last_name = ?," +
                "first_name = ?," +
                "phone = ?," +
                "address = ?," +
                "city = ?," +
                "postalCode = ?," +
                "country = ? where id = ?");
        ps.setString(1,customer.getUsername());
        ps.setString(2,customer.getLastName());
        ps.setString(3,customer.getFirstName());
        ps.setString(4,customer.getPhone());
        ps.setString(5,customer.getAddress());
        ps.setString(6,customer.getCity());
        ps.setString(7,customer.getPostalCode());
        ps.setString(8,customer.getCountry());
        ps.setInt(9,id);
        ps.executeUpdate();


    }

    public static void delete(int id) throws SQLException{
        PreparedStatement ps = connection.prepareStatement("delete from customers where id = ?");
        ps.setInt(1,id);
        ps.execute();
    }



    public static Customer resultToCustomer(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setUsername(rs.getString("username"));
        customer.setLastName(rs.getString("last_name"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setPhone(rs.getString("phone"));
        customer.setAddress(rs.getString("address"));
        customer.setCity(rs.getString("city"));
        customer.setPostalCode(rs.getString("postalCode"));
        customer.setCountry(rs.getString("country"));
        return customer;
    }
}
