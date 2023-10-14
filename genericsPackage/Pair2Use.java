package genericsPackage;

public class Pair2Use {
    public static void main(String[] args) {
        Pair2<Integer, String> p2 = new Pair2<Integer, String>();
        p2.setFirst(16);
        System.out.println(p2.getFirst());
        p2.setSecond("Hello");
        System.out.println(p2.getSecond());
    }
}
