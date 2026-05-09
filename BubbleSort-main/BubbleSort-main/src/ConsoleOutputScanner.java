import java.util.Scanner;

public class ConsoleOutputScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many numbers do you want to sort? ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter number #" + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        int laps = bubbleSort(array);

        System.out.println("\nSorted numbers:");
        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println("\nLaps taken: " + laps);

        scanner.close();
    }

    public static int bubbleSort(int[] array) {
        int laps = 0;

        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            laps++;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return laps;
    }
}