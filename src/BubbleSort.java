import java.util.Arrays;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        JDialog.setDefaultLookAndFeelDecorated(true);

        // Ask user to select execution mode
        String[] options = { "Console", "Dialog Box" };
        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose output mode:",
                "Bubble Sort",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        // Route execution based on user's choice
        if (choice == 0) {
            runConsole();
        } else if (choice == 1) {
            runDialog();
        }
    }

    static void runConsole() {
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        // Error validation for array size input
        System.out.print("How many numbers do you want to sort? ");
        size = scanner.nextInt();
        while (size <= 0) {
            System.out.println("  !!  Please enter a valid array size (positive integer).");

            System.out.print("How many numbers do you want to sort? ");
            size = scanner.nextInt();
        }

        // Populate the array
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number #" + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("\nOriginal array: " + Arrays.toString(array));
        System.out.println("\n===== Sorting Steps =====");

        // Execute sorting and get execution steps
        StringBuilder steps = new StringBuilder();
        int laps = bubbleSort(array, steps);

        // Output results to console
        System.out.println(steps.toString());
        System.out.println("===== Results =====");
        System.out.println("Sorted array : " + Arrays.toString(array));
        System.out.println("Laps taken   : " + laps);

        scanner.close();
    }

    static void runDialog() {
        int size = 0;

        // Error validation for dialog array size
        String input = JOptionPane.showInputDialog("How many numbers do you want to sort?");
        size = Integer.parseInt(input);
        while (size <= 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please enter a valid array size (positive integer).",
                    "Invalid Size",
                    JOptionPane.WARNING_MESSAGE);

            input = JOptionPane.showInputDialog("How many numbers do you want to sort?");
            size = Integer.parseInt(input);
        }

        // Populate the array
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            String numberInput = JOptionPane.showInputDialog("Enter number #" + (i + 1) + ":");
            if (numberInput == null) {
                return;
            }
            array[i] = Integer.parseInt(numberInput.trim());
        }

        String original = Arrays.toString(array);

        // Sort data and log progress
        StringBuilder steps = new StringBuilder();
        int laps = bubbleSort(array, steps);

        // Build output text formatting
        StringBuilder sb = new StringBuilder();
        sb.append("Original array: ").append(original).append("\n");
        sb.append("\n===== Sorting Steps =====\n");
        sb.append(steps);
        sb.append("\n===== Results =====\n");
        sb.append("\nSorted array: ").append(Arrays.toString(array));
        sb.append("\nLaps taken: ").append(laps);

        // Output scrollable text area container
        JTextArea textArea = new JTextArea(sb.toString(), 18, 32);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Output results in dialog box
        JOptionPane.showMessageDialog(null, scrollPane, "Bubble Sort - Steps", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "The sorted array is: " + Arrays.toString(array));
    }

    static int bubbleSort(int[] array, StringBuilder steps) {
        int laps = 0;

        // Outer loop tracks passes through the array
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            laps++;

            steps.append("\n");
            steps.append("Lap ").append(laps).append(" - before: ")
                    .append(Arrays.toString(array)).append("\n");

            // Inner loop compares adjacent elements, shrinking search space each lap
            for (int j = 0; j < array.length - i - 1; j++) {
                // Check if current item is out of order
                if (array[j] > array[j + 1]) {
                    int a = array[j];
                    int b = array[j + 1];

                    // Swap elements using temporary variable
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;

                    steps.append("  Swapped ").append(a).append(" and ").append(b)
                            .append(" --> ").append(Arrays.toString(array)).append("\n");
                }
            }

            // Early exit optimization if pass completed without swaps
            if (!swapped) {
                steps.append("  No swaps. Array is already sorted.\n");
                break;
            }
        }

        return laps;
    }
}