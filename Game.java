import java.util.Scanner;

public class Game {


    private Scanner scanner;
    private static String player1;
    private static String player2;

    public Game() {
        scanner = new Scanner(System.in);
    }


    public void play() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter Player 1 username:");
        player1 = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + player1);  // Output user input

        System.out.println("Enter Player 2 username:");
        player2 = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + player2);  // Output user input

        boolean player1Turn = false;
        while (!Board.isGameOver()) {
            Board.printBoard();


            if (player1Turn) {
                player1Move();
            } else {
                player2Move();
            }


            player1Turn = !player1Turn; // Alternate turns
        }


        // The game is over
        if (player1Turn) {
            System.out.println("Congratulations " + player1 + " You won!");
        } else {
            System.out.println("Congratulations " + player2 + " You won!");
        }
        
        System.out.println("Do you wish to play again? YES or NO");
        String playAgain = myObj.nextLine();
        if (playAgain.equalsIgnoreCase("yes")){
            Board.populate();
            play();
          
        } else {
            System.out.println("Thanks for playing!");
            
        }

    }


    private void player1Move() {
        System.out.println(player1 +"'s " + "turn!");
        int pile = Board.getPieces();
        int stones = -1;


        // Ask the player how many stones to remove
        while (true) {
            System.out.print("How many pieces do you want to remove from the pile? ");
            stones = scanner.nextInt();
            if (pile == 1){
                break;
            }
            if (stones > 0 && stones <= pile/2) {
                break;
            }
            System.out.println("Invalid number of stones. Try again.");
        }


        // Remove the stones from the pile
        Board.removePieces(stones);
    }

    private void player2Move() {
        System.out.println(player2 +"'s " + "turn!");
        int pile = Board.getPieces();
        int stones = -1;


        // Ask the player how many stones to remove
        while (true) {
            System.out.print("How many pieces do you want to remove from the pile? ");
            stones = scanner.nextInt();
            if (pile == 1){
                break;
            }
            if (stones > 0 && stones <= pile/2) {
                break;
            }
            System.out.println("Invalid number of stones. Try again.");
        }


        // Remove the stones from the pile
        Board.removePieces(stones);
    }

    // private void computerMove() {
    //     System.out.println("Computer's turn...");
    //     int pile = Board.getPieces();
    //     int stones = -1;


    //     // The computer will randomly choose a number of stones to remove
    //     while (true) {
    //         stones = (int) (Math.random() * pile) + 1; // Random number between 1 and the pile size
    //         if (stones <= pile) {
    //             break;
    //         }
    //     }


    //     System.out.println("Computer removes " + stones + " stone(s).");
    //     Board.removePieces(stones);
    //}
}
