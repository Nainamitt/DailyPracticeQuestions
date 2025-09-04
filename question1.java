import java.util.ArrayList;
import java.util.Scanner;

public class question1 {
    private ArrayList<ArrayList<Integer>> list;

    // Constructor
    question1(int n) {
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
    }

    // Add edge
    void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        list.get(u).add(v);
        list.get(v).add(u); // Since it's an undirected graph
    }

    // Print graph
    void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " --> ");
            for (int neighbor : list.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        question1 gp = new question1(n);

        System.out.println("Enter 4 edges (each as 2 space-separated integers):");
        for (int i = 0; i < 4; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            gp.addEdge(new int[]{u, v});
        }

        System.out.println("\nAdjacency List:");
        gp.print();
    }
}