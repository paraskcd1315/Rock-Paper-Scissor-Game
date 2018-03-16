package rockpaperscissorgame;
import java.util.Scanner;
import java.util.Random;

class RockPaperScissor{
    
    private User user;
    private Computer comp;
    private int userScore;
    private int computerScore;
    private int numberOfGames;
    
    //Constructor of RockPaperScissor Class:- 
    RockPaperScissor(){
        
        user = new User();
        comp = new Computer();
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
        
    }
    
    enum Move{
        
        ROCK, PAPER, SCISSOR;
        
        public int compareMoves(Move otherMove){
            
            //tie
            if(this == otherMove){
                
                return 0;
                
            }
            
            //Rock Vs Scissor = Rock
            //Paper Vs Rock = Paper
            //Scissor Vs Paper = Scissor
            switch(this){
                
                case ROCK:
                    return (otherMove == SCISSOR ? 1 : -1);
                    
                case PAPER:
                    return (otherMove == ROCK ? 1 : -1);
                    
                case SCISSOR:
                    return(otherMove == PAPER ? 1 : -1);
                    
            }
            
            return 0;
        }
            
    }
    
    
    class User{
        
        Scanner input;
        
        //Constructor of User class:- 
        public User(){
            input = new Scanner(System.in);
        }
        
        public Move getMove(){
            
            System.out.println("Choose one:- ");
            System.out.println("1. Rock (input rock/r/R/Rock for Rock)");
            System.out.println("2. Paper (input paper/p/P/Paper for Paper)");
            System.out.println("3. Scissors (input scissor/s/S/Scissor for Scissors)");
            System.out.print("\n Your choice:- ");
            String userInput = input.nextLine();
            userInput = userInput.toUpperCase();
            
            char firstLetter = userInput.charAt(0);
            
            if(firstLetter == 'R' || firstLetter == 'P' || firstLetter == 'S'){
                switch(firstLetter){
                    case 'R':
                        return Move.ROCK;
                        
                    case 'P':
                        return Move.PAPER;
                        
                    case 'S':
                        return Move.SCISSOR;
                }
            }
            
            System.out.println("\nError! You have chosen the Wrong input, please Try again...\n");
            return getMove();
            
        }
        
        public boolean playAgain(){
            
            System.out.println("Do you want to play the Game again?\n");
            System.out.print("Press Y if yes or N if no:- ");
            String userInput = input.nextLine();
            userInput = userInput.toUpperCase();
            return userInput.charAt(0) == 'Y';
            
        }
        
    }
    
    class Computer{
        
        public Move getMove(){
            Move moves[] = Move.values();
            Random random = new Random();
            int index = random.nextInt(moves.length);
            return moves[index];
        }
        
    }
    
    public void Rules(){
        
        System.out.println("The Rules of this Game are Simple:- ");
        System.out.println("1. Choose From Rock, Paper and Scissor.\n by inputting R, P and S for the respective Values.");
        System.out.println("\n2. Computer will play his part after your Input.");
        System.out.println("\n3. If you chose Rock and the Computer chose Scissors, You win!");
        System.out.println("\n4. If you chose Paper and the Computer chose Rock, You win!");
        System.out.println("\n5. If you chose Scissors and the Computer chose Paper, You win!");
        
    }
    
    public void startGame(){
        
        System.out.println("***--- ROCK PAPER SCISSORS ---***\n");
        
        Move userMove = user.getMove();
        Move compMove = comp.getMove();
        
        System.out.println("\nYou played " + userMove + ".");
        System.out.println("Computer played " + compMove + ".\n");
        
        int compareMoves = userMove.compareMoves(compMove);
        
        switch(compareMoves){
            
            case 0:
                System.out.println("Tie!\n");
                break;
                
            case 1:
                System.out.println(userMove + " beats " + compMove + ". You Won!\n");
                userScore++;
                break;
                
            case -1:
                System.out.println(compMove + " beats " + userMove + ". You lost!\n");
                computerScore++;
                break;
            
        }
        
        numberOfGames++;
        
        if(user.playAgain()){
            
            System.out.println();
            startGame();
        
        }
        
        else{
            
            System.out.println();
            printGameStats();
            
        }
        
    }
    
    void printGameStats(){
        
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        
        System.out.print("+");
        printDashes(50);
        System.out.println("+");
        
        System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |\n", "WINS", "LOSSES", "TIES", "GAMES PLAYED");
        
        System.out.print("+");
        printDashes(50);
        System.out.println("+");
        
        System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |\n", wins, losses, ties, numberOfGames);
        
        System.out.print("+");
        printDashes(50);
        System.out.println("+\n");
        
    }
    
    private void printDashes(int numberOfDashes){
        
        for(int i = 0; i < numberOfDashes; i++){
            
            System.out.print("-");
            
        }
        
    }
    
    public int menu(){
        
        System.out.print("+");
        printDashes(46);
        System.out.println("+");
        
        System.out.println("| Welcome to the Rock, Paper and Scissors Game |");
        
        System.out.print("+");
        printDashes(46);
        System.out.println("+");
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Press Start:- ");
        String start = input.nextLine();
        start = start.toUpperCase();
        
        char firstLetter = start.charAt(0);
        
        int exit = 0;
        
        if(firstLetter == 'S'){
            
            System.out.print("+");
            printDashes(46);
            System.out.println("+\n");
            
            
            System.out.println("-------- MENU ---------\n");
            System.out.println("---- 1. New Game ------");
            System.out.println("---- 2. Continue Game -");
            System.out.println("---- 3. Rules ---------");
            System.out.println("---- 4. Exit ----------\n");
            
            System.out.print("Your choice:- ");
            int choice = input.nextInt();
            
            System.out.print("+");
            printDashes(46);
            System.out.println("+\n");
            
            switch(choice){
                
                case 1:
                    
                    userScore = 0;
                    computerScore = 0;
                    numberOfGames = 0;
                    
                    startGame();
                    break;
                    
                case 2:
                    
                    if(userScore == 0 && computerScore == 0){
                        
                        System.out.print("Play New Game First...");
                        break;
                        
                    }
                    
                    startGame();
                    break;
                    
                case 3:
                    
                    Rules();
                    break;
                    
                case 4:
                    
                    exit = 4;
                    break;
                    
            } 
            
        }
        
        return exit;
        
    }
    
}

public class RockPaperScissorGame {

    
    public static void main(String[] args) {
        RockPaperScissor game = new RockPaperScissor();
        
        while(game.menu()!=4){
            
            game.menu();
            
        }
        
    }
    
}
