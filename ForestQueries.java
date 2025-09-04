import java.util.Scanner;

public class ForestQueries {
    static int[][] prefixSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // Grid size
        int q = sc.nextInt();  // Number of queries
        sc.nextLine();         // Consume the newline character

        char[][] forest = new char[n][n];

        // Read forest map (each row as a single string)
        for (int i = 0; i < n; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < n; j++) {
                forest[i][j] = row.charAt(j);
            }
        }

        // Build prefix sum matrix
        buildPrefixSum(forest);

        // Answer each query
        while (q-- > 0) {
            int x1 = sc.nextInt();  // row1
            int y1 = sc.nextInt();  // col1
            int x2 = sc.nextInt();  // row2
            int y2 = sc.nextInt();  // col2

            // Convert to 0-based indexing and print the result
            System.out.println(query(x1 - 1, y1 - 1, x2 - 1, y2 - 1));
        }
    }

    // Build 2D prefix sum for tree count
    private static void buildPrefixSum(char[][] forest) {
        int n = forest.length;
        prefixSum = new int[n + 1][n + 1];  // Extra row and column for easier handling

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int tree = forest[i - 1][j - 1] == '*' ? 1 : 0;
                prefixSum[i][j] = tree
                                + prefixSum[i - 1][j]
                                + prefixSum[i][j - 1]
                                - prefixSum[i - 1][j - 1];
            }
        }
    }

    // Query total number of trees in the given rectangular region
    private static int query(int x1, int y1, int x2, int y2) {
        return prefixSum[x2 + 1][y2 + 1]
             - prefixSum[x2 + 1][y1]
             - prefixSum[x1][y2 + 1]
             + prefixSum[x1][y1];
    }
}