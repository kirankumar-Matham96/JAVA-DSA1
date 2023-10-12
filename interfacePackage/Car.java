package interfacePackage;

/**
 * A class cannot extend more than one class.
 * But it can implement more than one interface.
 * If there is a method that is present in both the interfaces,
 * then we need to implement it only once, and it will not clash or throw an error.
 */
public class Car extends Vehicle implements VehicleInterface, AnotherInterface {

    /**
     * This method is present in both the interfaces
     * @return
     */
    @Override
    public String getMyName() {
        return "Kiran";
    }

    @Override
    public boolean isMotorized() {
        return false;
    }

    @Override
    public String getCompany() {
        return null;
    }

    @Override
    public void getMe() {

    }

    public void print(){
        // printing the variables from an interface, if 2 interfaces contains the variable is not possible.
        // System.out.println(PI);
        // If we ant to print it either way, we can specify the interface name before the variable
        System.out.println(AnotherInterface.PI);

    }
}
