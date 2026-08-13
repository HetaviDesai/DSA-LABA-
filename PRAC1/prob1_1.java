import java.util.Scanner;

public class prob1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long h = sc.nextLong();

        int rotation = (int)(h % n);

        for (int i = rotation; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < rotation; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}