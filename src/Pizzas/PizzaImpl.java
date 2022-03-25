package Pizzas;

import Client.Client;

import java.util.ArrayList;
import java.util.List;


public class PizzaImpl implements Pizza{
    private String newPizza;
    private List<Client> clients = new ArrayList<>();
    @Override
    public String decorate() {
        return "Pizza";
    }

    public void addObserver(Client client){
        this.clients.add(client);
    }

    public void removeObserver(Client client){
        this.clients.remove(client);
    }

    public void setNewPizza(String newPizza){
        this.newPizza=newPizza;
        for (Client client : this.clients)
            client.update(newPizza);
    }
}
