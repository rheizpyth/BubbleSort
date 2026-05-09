import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JDialog;

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

        System.out.println("\nOriginal array: " + arrayToString(array));
        System.out.println("\n===== Sorting Steps =====");

        StringBuilder steps = new StringBuilder();
        int laps = bubbleSort(array, steps);

        System.out.println(steps.toString());
        System.out.println("Sorted array : " + arrayToString(array));
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

        String original = arrayToString(array);

        StringBuilder steps = new StringBuilder();
        int laps = bubbleSort(array, steps);

        StringBuilder sb = new StringBuilder();
        sb.append("Original array: ").append(original).append("\n");
        sb.append("\n===== Sorting Steps =====\n");
        sb.append(steps);
        sb.append("\nLaps taken: ").append(laps);

        JTextArea textArea = new JTextArea(sb.toString(), 18, 32);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Bubble Sort - Steps", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "The sorted array is: " + arrayToString(array));
    }

    static int bubbleSort(int[] array, StringBuilder steps) {
        int laps = 0;

        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            laps++;

            steps.append("\n");
            steps.append("Lap ").append(laps).append(" - before: ").append(arrayToString(array)).append("\n");

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int a = array[j];
                    int b = array[j + 1];

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;

                    steps.append("  Swapped ").append(a).append(" and ").append(b)
                            .append(" --> ").append(arrayToString(array)).append("\n");
                }
            }

            if (!swapped) {
                steps.append("  No swaps - array is already sorted. Stopping early.\n");
                break;
            }
        }

        return laps;
    }

    static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1)
                sb.append(", ");
        }
        return sb.append("]").toString();
    }
}