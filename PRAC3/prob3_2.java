import java.util.Scanner;

public class prob3_2 {

    // Bubble Sort
    static void bubbleSort(int arr[]) {
        int n = arr.length;
        int temp;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    static void selectionSort(int arr[]) {
        int n = arr.length;
        int temp, min;

        for (int i = 0; i < n - 1; i++) {
            min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    // Insertion Sort
    static void insertionSort(int arr[]) {
        int n = arr.length;
        int key, j;

        for (int i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Display array
    static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("Enter the number of elements:");
        n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int bubble[] = arr.clone();
        int selection[] = arr.clone();
        int insertion[] = arr.clone();

        bubbleSort(bubble);
        System.out.println("Bubble Sort:");
        display(bubble);

        selectionSort(selection);
        System.out.println("Selection Sort:");
        display(selection);

        insertionSort(insertion);
        System.out.println("Insertion Sort:");
        display(insertion);

        sc.close();
    }
}