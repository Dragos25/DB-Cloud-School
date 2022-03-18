public class Bus extends Vehicle{

    private int noPassengers;
    private float ticketPrice;
    private int charges=0;

    public Bus(){
        super();
        this.noPassengers=0;
        this.ticketPrice=0;
    }

    public Bus(int noPassengers, float ticketPrice){
        this.noPassengers=noPassengers;
        this.ticketPrice=ticketPrice;
    }

    public Bus(String colour, boolean functional, int noPassengers, float ticketPrice){
        super(colour, functional);
        this.noPassengers=noPassengers;
        this.ticketPrice=ticketPrice;
    }

    public void charge(){
        this.charges++;
    }

    public float profit(){
        return 0.25f*ticketPrice*(float)charges;

    }

    public String display(){
        return "Bus {Colour: " + super.getColour() +", functionalState: " + super.isFunctional()+
                ", noPassengers: "+ this.noPassengers + ", ticketPrice:" +this.ticketPrice + ", profit: " + this.profit()+"}";
    }

}
