import javax.swing.JOptionPane;   

public class DialogBox {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("How many numbers do you want to sort?");
        int size = Integer.parseInt(input);

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            String numberInput = JOptionPane.showInputDialog("Enter number #" + (i + 1) + ":");
            array[i] = Integer.parseInt(numberInput);
        } 

        int laps = bubbleSort(array);


        StringBuilder sorted = new StringBuilder("Sorted numbers:\n");
        for (int i : array) {
            sorted.append(i).append(" ");
        }
        sorted.append("\nLaps taken: ").append(laps);

        JOptionPane.showMessageDialog(null, sorted.toString()); 
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

            if (!swapped) break;
        }

        return laps;
    }
}