package abstractPackageAndInterface;

public class UseVehicle {
    public static void main(String[] args) {
    // Objects for abstract methods cannot be created unless we define those abstract methods.
    // Vehicle v = new Vehicle();
    Vehicle v = new Car(200, "red", 2, 8) {
        @Override
        public String getCompany() {
            return null;
        }

        @Override
        public void getMe() {

        }
    };
    }
}
