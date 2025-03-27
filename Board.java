public class Board {
    private static int pieces;


    public static void populate() {
        pieces = (int)((Math.random() * 51) + 10); // Random number of Pieces between 10 and 150
        System.out.println("Pieces: " + pieces);
    }


    public static void printBoard() {
        System.out.println("Current board state: " + pieces);
        System.out.print("Pieces: ");
        for (int i = 0; i < pieces; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }


    public static boolean isGameOver() {
        return pieces == 0;
    }


    public static int getPieces() {
        return pieces;
    }


    public static void removePieces(int num) {
        if (num > 0 && num <= pieces) {
            pieces -= num;
        }
       
    }
}
