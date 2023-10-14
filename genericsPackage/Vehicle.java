package genericsPackage;

public class Vehicle implements PrintInterface{
    private int maxSpeed;
    private int doors;

    public Vehicle(int maxSpeed, int doors){
        this.maxSpeed = maxSpeed;
        this.doors = doors;
    }

    public Vehicle(){

    }

    public void print(){
        System.out.println(this.maxSpeed +" with "+ doors);
    }
}
