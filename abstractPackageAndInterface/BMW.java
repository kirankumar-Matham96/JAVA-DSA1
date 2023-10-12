package abstractPackageAndInterface;

public class BMW extends Car {
    public BMW(int maxSpeed, String color, int numberOfDoors, int numberOfGears) {
        super(maxSpeed, color, numberOfDoors, numberOfGears);
    }

    public String getCompany(){
        return "BMW";
    }

    @Override
    public void getMe() {

    }
}
