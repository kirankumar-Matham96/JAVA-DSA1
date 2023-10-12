package interfacePackage;

/**
 * If any class that implements an interface,
 * the class must either implement the methods or
 * it should declare the methods as abstract methods.
 */
//public class Vehicle implements VehicleInterface {
//    public boolean isMotorized(){return true;}
//    public String getCompany(){return "mdbchbd";}
//    public void getMe(){};
//}

// or

public abstract class Vehicle implements VehicleInterface {
    public abstract boolean isMotorized();
    public abstract String getCompany();
    public abstract void getMe();
}
