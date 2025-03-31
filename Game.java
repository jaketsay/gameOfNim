import java.util.Scanner;

public class Game {


    private Scanner scanner;
    private static String player1;
    private static String player2;
    private int scoreP1;
    private int scoreP2;
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

        boolean player1Turn;

        int randTurn = (int)(Math.random() * 2);
        if(randTurn == 1){
            player1Turn = true;
        }
        else{
            player1Turn = false;
        }
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
            scoreP1++;

            System.out.println("Congratulations " + player1 + " You won!");
            System.out.println(player1 + "'s score: " + scoreP1);

        } else {
            scoreP2++;

 
            System.out.println("Congratulations " + player2 + " You won!");
            System.out.println(player2 + "'s score: " + scoreP2);
        }
        
        System.out.println("Do you wish to play again? YES or NO");
        String playAgain = myObj.nextLine();
        if (playAgain.equalsIgnoreCase("yes")){
            Board.populate();
            playAgain();
          
        } else {
            System.out.println("Thanks for playing!");
            
        }

    }

    private void playAgain(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    
        boolean player1Turn;

        int randTurn = (int)(Math.random() * 2);
        if(randTurn == 1){
            player1Turn = true;
        }
        else{
            player1Turn = false;
        }
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
            scoreP1++;

            System.out.println("Congratulations " + player1 + " You won!");
            System.out.println(player1 + "'s score: " + scoreP1);

        } else {
            scoreP2++;

 
            System.out.println("Congratulations " + player2 + " You won!");
            System.out.println(player2 + "'s score: " + scoreP2);
        }
        
        
        System.out.println("Do you wish to play again? YES or NO");
        String playAgain = myObj.nextLine();
        if (playAgain.equalsIgnoreCase("yes")){
            Board.populate();
            playAgain();
          
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
}
