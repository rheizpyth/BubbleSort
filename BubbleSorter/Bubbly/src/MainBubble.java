import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int [] arrayBubbleSort = new int[5];
        System.out.println("Enter 5 numbers to sort:");
        for (int i = 0; i < 5; i++) {
            arrayBubbleSort[i] = scanner.nextInt();
            
        }
        scanner.close();
    }
}