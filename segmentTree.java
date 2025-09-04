import java.util.*;

public class segmentTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int segment[] = new int[4 * n]; // safe size
        construct(arr, segment, 0, n - 1, 0);

        // Print the segment tree (optional)
        // for (int val : segment) {
        //     System.out.print(val + " ");
        // }
    }

    static void construct(int ar[], int[] sg, int low, int high, int index) {
        if (low == high) {
            sg[index] = ar[low];
            return;
        }

        int mid = (low + high) / 2;
        construct(ar, sg, low, mid, 2 * index + 1);
        construct(ar, sg, mid + 1, high, 2 * index + 2);

        sg[index] = Math.min(sg[2 * index + 1], sg[2 * index + 2]);
    }
}