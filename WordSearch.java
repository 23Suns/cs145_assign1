import java.util.Scanner;

public class WordSearch {
    private static char[][] wordSearch;
    private static char[][] solution;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        printIntro();
    }

    private static void printIntro() {
        System.out.println("Welcome to the Word Search Generator!");
        System.out.println("This program allows you to generate a word search puzzle.\n");
        System.out.println("You can perform the following actions:");
        System.out.println("g - Generate Word Search");
        System.out.println("p - Print Word Search");
        System.out.println("s - Show Solution");
        System.out.println("q - Quit");
    }

    private static void generate() {
        System.out.println("Generating a new word search...");
    
        System.out.print("Enter the number of words: ");
        int numWords = scanner.nextInt();
    
        String[] words = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            words[i] = scanner.next().toUpperCase();  
        }
        
        // initializes fixed 2D array for word search
        int rows = 10;
        int cols = 10;
        char[][] wordSearch = new char[rows][cols];

        // fill empty array with '@'
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                wordSearch[i][j] = '@';
            }
        }

        // for (String word : words) {
        //     boolean placed = false;
        //     for (int i = 0; i < 100 && !placed; i++) {
        //         int row = Math.random()
        //     }
        // }
        
        System.out.println("Word search generated successfully!");
    }
    
    // public static boolean canPlace(String word, int row, int col, int direction) {
    //     int rowStep = 0, colStep = 0;

    //     if (direction == 0) colStep = 1;
    //     else if (direction == 1) rowStep = 1;
    //     else if (direction == 2) {
    //         rowStep = 1;
    //         colStep = 1;
    //     }

    //     for (int i = 0; i < word.length(); i++) {
    //         int newRow = row + i*rowStep;
    //         int newCol = col + i*colStep;
    //         if (newRow >= row || newCol >= col) return false;
    //         if (wordSearch[newRow][newCol] != null && wordSearch[row][col] != word.charAt(i)) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    public static void print() {

    }

    public static void showSolution() {

    }
}