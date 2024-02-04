package Backtrack;

public class ReachTheDestination {
    public static boolean isReachable(int sx, int sy, int dx, int dy) {
        if (sx > dx || sy > dy) {
            return false;
        }

        if (sx == dx && sy == dy) {
            return true;
        }

        return isReachable(sx + sy, sy, dx, dy) || isReachable(sx, sy + sx, dx, dy);
    }

    public static void main(String[] args) {
        System.out.println(isReachable(1,1,3,5));
        System.out.println(isReachable(1,1,1,4));
        System.out.println(isReachable(1,1,2,2));
    }
}
