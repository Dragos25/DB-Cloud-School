import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
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
        Customer c = CustomerQuery.getById(2);
        if(c==null)
            System.out.println("Customer doesn't exist!");
        else System.out.println(c.toString());

        ArrayList<Customer> customers = CustomerQuery.getAll();
        System.out.println(customers);
        //Customer newCustomer = new Customer("gigel12", "george", "marcel", "+40543432", "aproape", "drobeta", "12343","Rep populara chineza");
        //CustomerQuery.insert(newCustomer);
        //customers = CustomerQuery.getAll();
        //System.out.println(customers);
        //CustomerQuery.delete(4);
        Customer updateCustomer = CustomerQuery.getById(2);
        System.out.println(updateCustomer.toString());
        updateCustomer.setCountry("testupdate");
        updateCustomer.setFirstName("new First name");
        CustomerQuery.update(2,updateCustomer);
        updateCustomer = CustomerQuery.getById(2);
        System.out.println(updateCustomer);
    }
}
