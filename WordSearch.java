/**
 * Name: Joshua Henderson
 * Date: February 12, 2023
 * Project: Word Search Program
 * Purpose: This program implements a Word Search Generator that allows users to create word search puzzles
 *          based on user-provided words. The program includes methods for printing an introduction,
 *          generating word searches, printing the current word search, showing solutions, and handling user input.
 *          It aims to reinforce key programming concepts, including printing, data types, methods, loops, arrays,
 *          and user input handling, while providing a practical application in the form of a word search generator.
 */

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
    
        System.out.print("How many words would you like to enter?: ");
        int numWords = scanner.nextInt();
        System.out.println();
    
        String[] words = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            words[i] = scanner.next().toUpperCase();  
        }
        
        // initializes dimensions for fixed 2D array in word search
        int rows = 10;
        int cols = 10;

        // fill empty array with '@'
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                wordSearch[i][j] = '@';
            }
        }

        //
        // placement logic
        //

        System.out.println("Word search generated successfully!");
    }
    
    public static boolean placeRandomPosition(String word) {
        int maxAttempts = 100;
        
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            int direction = (int) (Math.random() * 8);
            int row = (int) (Math.random() * wordSearch.length);
            int col = (int) (Math.random() * wordSearch[0].length);

            if (canPlace(word, row, col, direction)) {
                attemptToPlace(word, row, col, direction);
                return true;
            }
        }
        return false;
    }

    private static boolean canPlace(String word, int startRow, int startCol, int direction) {
        switch (direction) {
            case 0:  // Left to Right
                return startCol + word.length() <= wordSearch[0].length &&
                    checkNoOverlap(word, startRow, startCol, 1, 0);
            case 1:  // Right to Left
                return startCol - word.length() >= 0 &&
                    checkNoOverlap(word, startRow, startCol, -1, 0);
            case 2:  // Top to Bottom
                return startRow + word.length() <= wordSearch.length &&
                    checkNoOverlap(word, startRow, startCol, 0, 1);
            case 3:  // Bottom to Top
                return startRow - word.length() >= 0 &&
                    checkNoOverlap(word, startRow, startCol, 0, -1);
        }
        return false;
    }

    private static boolean checkNoOverlap(String word, int startRow, int startCol, int rowIncrement, int colIncrement) {
        for (int i = 0; i < word.length(); i++) {
            int currentRow = startRow + i * rowIncrement;
            int currentCol = startCol + i * colIncrement;
    
            // Check if indices are within bounds before accessing the array
            if (currentRow >= 0 && currentRow < wordSearch.length && currentCol >= 0 && currentCol < wordSearch[0].length) {
                char currentCell = wordSearch[currentRow][currentCol];
                if (currentCell != '@' && currentCell != word.charAt(i)) {
                    return false;  // Overlap detected
                }
            } else {
                return false;  // Out of bounds
            }
        }
        return true;  // No overlap
    }

    private static void attemptToPlace(String word, int startRow, int startCol, int direction) {
        switch (direction) {
            case 0:  // Left to Right
                placeWord(word, startRow, startCol, 1, 0);
                break;
            case 1:  // Right to Left
                placeWord(word, startRow, startCol, -1, 0);
                break;
            case 2:  // Top to Bottom
                placeWord(word, startRow, startCol, 0, 1);
                break;
            case 3:  // Bottom to Top
                placeWord(word, startRow, startCol, 0, -1);
                break;
        }
    }

    private static void placeWord(String word, int startRow, int startCol, int rowIncrement, int colIncrement) {
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            wordSearch[startRow + i * rowIncrement][startCol + i * colIncrement] = currentChar;
    
            // Update the solution array with the original character or 'X'
            if (solution != null) {
                solution[startRow + i * rowIncrement][startCol + i * colIncrement] = (currentChar != '@') ? 'X' : '@';
            }
        }
    }

    // public static void print() {

    // }

    // public static void showSolution() {

    // }
}