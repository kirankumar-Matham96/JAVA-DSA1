package abstractPackageAndInterface;

public abstract class Car extends Vehicle {
    private int numberOfDoors;
    private int numberOfGears;

    public Car(int maxSpeed, String color, int numberOfDoors, int numberOfGears){
        super(maxSpeed,color);
        this.numberOfDoors = numberOfDoors;
        this.numberOfGears = numberOfGears;
    }

    @Override
    public int getMaxSpeed() {
        return super.getMaxSpeed();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        super.setMaxSpeed(maxSpeed);
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }
    public boolean isMotorized(){
        return true;
    }

    public abstract String getCompany();
}
