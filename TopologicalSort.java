import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        int indegree[] = new int[n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
            indegree[v]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                qu.add(i);
            }
        }

        System.out.println("Topological Sort:");
        while (!qu.isEmpty()) {
            int top = qu.poll();
            System.out.print(top + " ");
            for (int num : list.get(top)) {
                indegree[num]--;
                if (indegree[num] == 0) {
                    qu.add(num);
                }
            }
        }
    }
}