package abstractPackageAndInterface;

public abstract class Vehicle {
    private int maxSpeed;
    String color;

    public Vehicle(int maxSpeed, String color){
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public Vehicle(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public Vehicle(String color){
        this.color = color;
    }

    public Vehicle(){
        this.maxSpeed = 40;
        this.color = "green";
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed(){
        return this.maxSpeed;
    }

    public String getColor(){
        return this.color;
    }

    @Override
    public String toString() {
        System.out.println("calling toString method: "+ super.toString());
        return super.toString();
    }

    public abstract boolean isMotorized();
    public abstract String getCompany();
    public abstract void getMe();

}
