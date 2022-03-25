package Commands;

import Enums.PizzaType;
import Pizzas.Pizza;
import Pizzas.PizzaFactory;

public class CommandOrder extends Command{

    @Override
    public Pizza execute(PizzaFactory pizzaFactory, PizzaType pizzaType) {
        return pizzaFactory.createPizza(pizzaType);

    }
}