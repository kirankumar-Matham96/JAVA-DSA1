package genericsPackage;

public class PairUse {
    public static void main(String[] args) {
        Pair<Integer> p1 = new Pair<Integer>(2,3);
        Pair<String> p2 = new Pair<String>("TWO", "THREE");
        Pair<Double> p3 = new Pair<Double>(2.5, 3.2);

        System.out.println(p1.getFirst()+" "+p1.getSecond());
        System.out.println(p2.getFirst()+" "+p2.getSecond());
        System.out.println(p3.getFirst()+" "+p3.getSecond());
    }
}
