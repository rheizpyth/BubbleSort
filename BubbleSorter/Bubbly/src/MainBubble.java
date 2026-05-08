import java.util.Scanner;

class MainBubble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter how many numbers you want to sort: ");
        int n = scanner.nextInt();
        int [] arrayBubbleSort = new int[n];
        
        System.out.println ("");
        for (int i = 0; i < arrayBubbleSort.length; i++) {
            System.out.print("Enter the numbers: ");
            arrayBubbleSort[i] = scanner.nextInt();
            while (arrayBubbleSort[i] < 0) {
                System.out.print("Please enter a whole number: ");
                arrayBubbleSort[i] = scanner.nextInt();
            }
        }
        for (int i = 0; i < arrayBubbleSort.length - 1; i++) {
            for (int j = 0; j < arrayBubbleSort.length - i - 1; j++) {
                if (arrayBubbleSort[j] > arrayBubbleSort[j + 1]) {
                    int sort = arrayBubbleSort[j];
                    arrayBubbleSort[j] = arrayBubbleSort[j + 1];
                    arrayBubbleSort[j + 1] = sort;
                }
            }
        }
        System.out.printf("\nSorted numbers: [");
        for (int i = 0; i < arrayBubbleSort.length; i++) {
             System.out.print(arrayBubbleSort[i]);
             if (i < arrayBubbleSort.length - 1) {
                System.out.print(", ");
        
    }
}                                 
        System.out.print("]");
        scanner.close();
    }
}