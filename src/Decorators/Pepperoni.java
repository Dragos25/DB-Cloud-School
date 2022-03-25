package Decorators;

import Pizzas.Pizza;

public class Pepperoni extends PizzaDecorator{
    public Pepperoni(Pizza pizza){
        super(pizza);
    }

    public String decorate(){
        return super.decorate() + decorateWithPepperoni();
    }

    private String decorateWithPepperoni(){
        return " with Pepperoni";
    }
}
