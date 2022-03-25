package Client;

public class Client {
    private String newPizza;
    public void update(Object news) {
        this.setNewPizza((String) news);
    }

    private void setNewPizza(String newPizza){
        this.newPizza=newPizza;
    }

    public String getNewPizza() {
        return newPizza;
    }
}
