package Arrays1;

public class PrintSubsetsOfAnArray {

    static void printSubsets(int set[]) {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1 << n); i++) {

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 15, 20, 12 };
        printSubsets(arr);
    }
}
