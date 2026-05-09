import java.util.Arrays;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        JDialog.setDefaultLookAndFeelDecorated(true);

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

        if (choice == 0) {
            runConsole();
        } else if (choice == 1) {
            runDialog();
        }
    }

    static void runConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many numbers do you want to sort? ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number #" + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("\nOriginal array: " + Arrays.toString(array));
        System.out.println("\n===== Sorting Steps =====");

        StringBuilder steps = new StringBuilder();
        int laps = bubbleSort(array, steps);

        System.out.println(steps.toString());
        System.out.println("===== Results =====");
        System.out.println("Sorted array : " + Arrays.toString(array));
        System.out.println("Laps taken   : " + laps);

        scanner.close();
    }

    static void runDialog() {
        String input = JOptionPane.showInputDialog("How many numbers do you want to sort?");
        if (input == null)
            return;
        int size = Integer.parseInt(input.trim());

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            String numberInput = JOptionPane.showInputDialog("Enter number #" + (i + 1) + ":");
            if (numberInput == null)
                return;
            array[i] = Integer.parseInt(numberInput.trim());
        }

        String original = Arrays.toString(array);

        StringBuilder steps = new StringBuilder();
        int laps = bubbleSort(array, steps);

        StringBuilder sb = new StringBuilder();
        sb.append("Original array: ").append(original).append("\n");
        sb.append("\n===== Sorting Steps =====\n");
        sb.append(steps);
        sb.append("\n===== Results =====\n");
        sb.append("\nSorted array: ").append(Arrays.toString(array));
        sb.append("\nLaps taken: ").append(laps);

        JTextArea textArea = new JTextArea(sb.toString(), 18, 32);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Bubble Sort - Steps", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "The sorted array is: " + Arrays.toString(array));
    }

    static int bubbleSort(int[] array, StringBuilder steps) {
        int laps = 0;

        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            laps++;

            steps.append("\n");
            steps.append("Lap ").append(laps).append(" - before: ").append(Arrays.toString(array)).append("\n");

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int a = array[j];
                    int b = array[j + 1];

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;

                    steps.append("  Swapped ").append(a).append(" and ").append(b)
                            .append(" --> ").append(Arrays.toString(array)).append("\n");
                }
            }

            if (!swapped) {
                steps.append("  No swaps. Array is already sorted.\n");
                break;
            }
        }

        return laps;
    }
}