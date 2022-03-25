package Commands;

import Enums.PizzaType;
import Pizzas.Pizza;
import Pizzas.PizzaFactory;

public abstract class Command {
    public abstract Pizza execute(PizzaFactory pizzaFactory, PizzaType pizzaType);

}

