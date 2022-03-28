import Data.Customer;
import Data.Order;

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


}
