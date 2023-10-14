package genericsPackage;

public class ChainedGenericPair2Use {
    public static void main(String[] args) {
        Pair2<Pair2<Integer, String>, String> p = new Pair2<Pair2<Integer, String>, String>();
        Pair2<Integer, String> p2 = new Pair2<>();
        p2.setFirst(2);
        p2.setSecond("TWO");

        p.setFirst(p2);
        p.setSecond("Hi");

        System.out.println(p.getFirst());
        System.out.println(p.getSecond());

        // accessing the arguments of the first generic argument
        System.out.println(p.getFirst().getFirst());
        System.out.println(p.getFirst().getSecond());

    }
}
