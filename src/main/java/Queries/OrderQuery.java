package Queries;

import Data.Order;
import Data.OrderDetails;
import Queries.CustomerQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderQuery {
    private static Connection connection;
    public static void setConnection(Connection _connection){
        connection = _connection;
    }

    public static Order getById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM orders WHERE id = ?;");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
            return resultToOrder(rs);
        return null;
    }

    public static void insert (Order order) throws SQLException {

        if(CustomerQuery.getById(order.getCustomerId())==null){
            System.out.println("Customer doesn't exist!");
            return;
        }
        PreparedStatement ps = connection.prepareStatement("insert into orders(order_date, shipped_date, status, comments, customer_id) values (?,?,?,?,?);");
        ps.setDate(1, order.getOrderDate());
        ps.setDate(2, order.getShippedDate());
        ps.setString(3,order.getStatus());
        ps.setString(4,order.getComments());
        ps.setInt(5, order.getCustomerId());
        ps.execute();
    }

    public static ArrayList<Order> getAllOrderFromCustomer(int id) throws SQLException {
        if(CustomerQuery.getById(id)==null){
            System.out.println("Customer doesn't exist");
            return null;
        }
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM orders where customer_id = ?;");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        ArrayList<Order> orders = new ArrayList<>();
        while(rs.next())
            orders.add(resultToOrder(rs));
        return orders;


    }

    public static Order resultToOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setOrderDate(rs.getDate("order_date"));
        order.setShippedDate(rs.getDate("shipped_date"));
        order.setStatus(rs.getString("status"));
        order.setComments(rs.getString("comments"));
        order.setCustomerId(rs.getInt("customer_id"));
        return order;
    }

    public static void updateStatus(int id, String status) throws SQLException{
        Order order = getById(id);
        if(order==null) {
            System.out.println("The order doesn't exist");
            return;
        }
        PreparedStatement ps = connection.prepareStatement("UPDATE orders set status = ? where id = ?;");
        ps.setString(1, status);
        ps.setInt(2,id);
        ps.executeUpdate();
    }

    public static void updateComment(int id, String comment) throws SQLException{
        Order order = getById(id);
        if(order==null) {
            System.out.println("The order doesn't exist");
            return;
        }
        PreparedStatement ps = connection.prepareStatement("UPDATE orders set comments = ? where id = ?;");
        ps.setString(1, comment);
        ps.setInt(2,id);
        ps.executeUpdate();
    }

    public static void insertOrderDetails(OrderDetails orderDetails) throws SQLException{
        PreparedStatement ps = connection.prepareStatement("INSERT INTO orderdetails(quantity, priceEach, product_code, order_id) values (?, ?, ?, ?);");
        ps.setInt(1,orderDetails.getQuantity());
        ps.setFloat(2,orderDetails.getPriceEach());
        ps.setString(3,orderDetails.getProductCode());
        ps.setInt(4,orderDetails.getOrderId());
        ps.execute();
        updateStock(orderDetails.getProductCode(), orderDetails.getQuantity());
    }

    public static void updateStock(String id, int quantity) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Select stock from products where code = ?;");
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int stock = rs.getInt("stock");
            stock = stock - quantity;
            ps = connection.prepareStatement("update products set stock = ? where code = ?;");
            ps.setInt(1, stock);
            ps.setString(2, id);
            ps.executeUpdate();
        }

    }




}
