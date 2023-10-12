package abstractPackageAndInterface;

public abstract class Bicycle extends Vehicle{
    private String metal;

    public Bicycle(String metal){
        this.metal = metal;
    }

    @Override
    public int getMaxSpeed() {
        return super.getMaxSpeed();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    public String getMetal() {
        return metal;
    }

    public void setMaxSpeed(int maxSpeed){
        super.setMaxSpeed(maxSpeed);
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public boolean isMotorized(){
        return false;
    }

    public abstract String getCompany();
}
