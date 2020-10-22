package lessons6;

import java.util.Scanner;

public class Labyrinth {
    static char[][] labyrinth = new char[5][5];
    static Scanner scan = new Scanner(System.in);
    static boolean foundE = false;

    public static void main (String[] args){
        initLabyrinth();
        printLabyrinth();
        moveCharacter();
    }

    private static void initLabyrinth(){
        for (int i = 0; i < labyrinth.length; i++){
            for (int j = 0; j < labyrinth[0].length; j++) {
//                System.out.print("[" + i + "," + j + "]");
                labyrinth[i][j] = '-';
                labyrinth[0][2] = 'W';
                labyrinth[0][3] = 'W';
                labyrinth[1][1] = 'W';
                labyrinth[1][3] = 'W';
                labyrinth[2][0] = 'P';
                labyrinth[2][1] = 'W';
                labyrinth[2][3] = 'W';
                labyrinth[2][4] = 'W';
                labyrinth[3][2] = 'W';
                labyrinth[3][4] = 'E';
                labyrinth[4][0] = 'W';
                labyrinth[4][4] = 'W';
            }
//            System.out.println();
        }
    }

    private static void printLabyrinth(){
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                System.out.print(labyrinth[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void moveCharacter(){
        System.out.println("Enter a char: ");
        char move = scan.next().toUpperCase().charAt(0);

        switch (move){
            case 'U': moveUp(move);
                break;
            case 'D': moveDown(move);
                break;
            case 'L': moveLeft(move);
                break;
            case 'R': moveRight(move);
                break;
            default: System.out.println("You have to enter another value");
                    moveCharacter();
        }
    }

    private static void moveUp(char move){
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                if (labyrinth[i][j] == 'P' && i != 0){
                    if (labyrinth[i-1][j] == 'E'){
                        foundE = true;
                        break;
                    }
                    if (labyrinth[i-1][j] == '-'){
                        labyrinth[i][j] = '-';
                        labyrinth[i-1][j] = 'P';
                        break;
                    }
                }

            }
        }
        printLabyrinth();
        moveCharacter();
    }

    private static void moveDown(char move){
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                // If it is 4 I can not go down
                if (labyrinth[i][j] == 'P' && i != labyrinth.length - 1) {
                    if (labyrinth[i][j] == 'P' && labyrinth[i+1][j] == '-'){
                        labyrinth[i][j] = '-';
                        labyrinth[i+1][j] = 'P';
                        break;
                    }
                }
            }
        }
        printLabyrinth();
        moveCharacter();
    }

    private static void moveLeft(char move){
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                // If j == 0 I can not move to the left
                if (labyrinth[i][j] == 'P' && j != 0) {
                    if (labyrinth[i][j - 1] == '-') {
                        labyrinth[i][j] = '-';
                        labyrinth[i][j - 1] = 'P';
                        break;
                    }
                }
            }
        }
        if (foundE){
            System.out.println("You won!");
        } else {
            printLabyrinth();
            moveCharacter();
        }
    }

    private static void moveRight(char move){
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                // If j == 4 I can not go right
                if (labyrinth[i][j] == 'P' && j != labyrinth.length - 1){
                    if (labyrinth[i][j+1] == 'E'){
                        foundE = true;
                        break;
                    }
                    if (labyrinth[i][j] == 'P' && labyrinth[i][j+1] == '-'){
                        labyrinth[i][j] = '-';
                        labyrinth[i][j+1] = 'P';
                        break;
                    }
                }
            }
        }

        if (foundE){
            System.out.println("You won!");
        } else {
            printLabyrinth();
            moveCharacter();
        }
    }

//    private static void moveCharacter2() {
//        System.out.println("Enter a char: ");
//        char move = scan.next().toUpperCase().charAt(0);
//        int directRow = 0;
//        int directCol = 0;
//
//        switch (move){
//            case 'U':
//                directRow = - 1;
//                directCol = 0;
//                break;
//            case 'D':
//                directRow = + 1;
//                directCol = 0;
//                break;
//            case 'L':
//                directRow = 0;
//                directCol = - 1 ;
//                break;
//            case 'R':
//                directRow = 0;
//                directCol = + 1;
//                break;
//            default: System.out.println("You have to enter another value");
//                moveCharacter2();
//        }
//
//        for (int i = 0; i < labyrinth.length; i++) {
//            for (int j = 0; j < labyrinth[0].length; j++) {
//                // If j == 4 I can not go right
//                if (labyrinth[i][j] == 'P' && (j != labyrinth.length - 1 || i != labyrinth.length - 1) && (i != 0 || j !=0) ){
////                    if (labyrinth[i + directRow][j + directCol] == 'E'){
////                        foundE = true;
////                        break;
////                    }
//                    if (labyrinth[i][j] == 'P' && labyrinth[i + directRow][j + directCol] == '-'){
//                        labyrinth[i][j] = '-';
//                        labyrinth[i + directRow][j + directCol] = 'P';
//                        break;
//                    }
//                }
//            }
//        }
//
//        if (foundE){
//            System.out.println("You won!");
//        } else {
//            printLabyrinth();
//            moveCharacter2();
//        }
//
//    }

}
