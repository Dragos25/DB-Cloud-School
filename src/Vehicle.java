public abstract class Vehicle implements Comparable<Vehicle>{

    private String colour;
    private boolean functional;

    public Vehicle(){
        this.colour = null;
        this.functional=false;
    }

    public Vehicle(String colour, boolean functional){
        this.colour=colour;
        this.functional=functional;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isFunctional() {
        return functional;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    public abstract void charge();
    public abstract float profit();
    public abstract String display();

    public int compareTo(Vehicle vehicle){
        return (int) (this.profit() - vehicle.profit());
    }

}
