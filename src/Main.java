import Client.Client;
import Commands.CommandOrder;
import Decorators.Pepperoni;
import Decorators.Pineapple;
import Enums.PizzaType;
import Pizzas.Pizza;
import Pizzas.PizzaFactory;

public class Main {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = PizzaFactory.instance();
        Pizza p = pizzaFactory.createPizza(PizzaType.QUATRO_STAGIONI);
        p = new Pineapple(p);
        p = new Pepperoni(p);
        System.out.println(p.decorate());
        Client client= new Client();
        CommandOrder commandOrder = new CommandOrder();
        Pizza p2 = commandOrder.execute(pizzaFactory, PizzaType.CAPRICIOSA);
        p2 = new Pineapple(p2);
        System.out.println(p2.decorate());

    }
}
