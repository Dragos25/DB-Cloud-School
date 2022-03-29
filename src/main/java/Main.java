import Data.Customer;
import Data.Order;
import Data.OrderDetails;
import Queries.CustomerQuery;
import Queries.OrderQuery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/training1";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username,password);
        CustomerQuery.setConnection(connection);
        OrderQuery.setConnection(connection);
        Customer c = CustomerQuery.getById(2);
        if(c==null)
            System.out.println("Data.Customer doesn't exist!");
        else System.out.println(c.toString());

//        ArrayList<Customer> customers = CustomerQuery.getAll();
//        System.out.println(customers);
//        Data.Customer newCustomer = new Data.Customer("gigel12", "george", "marcel", "+40543432", "aproape", "drobeta", "12343","Rep populara chineza");
//        Queries.CustomerQuery.insert(newCustomer);
//        customers = Queries.CustomerQuery.getAll();
//        System.out.println(customers);
//        Queries.CustomerQuery.delete(4);

        int idToUpdate = 2;
        Customer updateCustomer = Queries.CustomerQuery.getById(idToUpdate);
        System.out.println(updateCustomer.toString());
        updateCustomer.setCountry("testupdate");
        updateCustomer.setFirstName("new First name");
        Queries.CustomerQuery.update(idToUpdate,updateCustomer);
        updateCustomer = Queries.CustomerQuery.getById(idToUpdate);
        System.out.println(updateCustomer);

        Order order = new Order(Date.valueOf("2022-08-19"), Date.valueOf("2022-08-19"), "delivered", "no comment", 1);
        System.out.println(order.toString());
        Queries.OrderQuery.insert(order);
        ArrayList<Order> ordersFromCustomer = Queries.OrderQuery.getAllOrderFromCustomer(1);
        System.out.println(ordersFromCustomer);

        Queries.OrderQuery.updateComment(2, "testupdatecomment");
        Order order2 = Queries.OrderQuery.getById(2);
        System.out.println(order2.toString());

        OrderDetails orderDetails = new OrderDetails("COD1", 3, 10f, 1);
        OrderQuery.insertOrderDetails(orderDetails);


    }
}
