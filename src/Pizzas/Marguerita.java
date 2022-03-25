package Pizzas;

public class Marguerita extends PizzaImpl{
    @Override
    public String decorate() {
        return super.decorate() + " Marguerita";
    }
}
