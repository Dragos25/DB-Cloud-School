package Pizzas;

import Enums.PizzaType;

public class PizzaFactory {
    private static PizzaFactory instance = null;

    public static PizzaFactory  instance() {
        if (instance == null)
            instance = new PizzaFactory();
        return instance;
    }

    public Pizza createPizza(PizzaType pizzaType) {
        switch (pizzaType) {
            case CAPRICIOSA: {
                return new Capriciosa();
            }
            case MARGUERITA: {
                return new Marguerita();
            }
            case PROSCIUTTO_FUNGHI: {
                return new ProsciuttoFunghi();
            }
            case QUATRO_STAGIONI: {
                return new QuatroStagioni();
            }
            default:
                return null;
        }

    }
}
