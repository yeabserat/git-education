import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		
		char[][] display = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		Board(display);
		
		while (true) {
			playerTurn(display, scanner);
			if (roundEnd(display)){
				break;
			}
			Board(display);
			
			computerTurn(display);
			if (roundEnd(display)){
				break;
			}
			Board(display);
		}
		scanner.close();
	}


	private static boolean roundEnd(char[][] display) {
		
		if (Won(display, 'X')) {	
			Board(display);
			System.out.println("Player wins!");
			return true;
		}
		
		if (Won(display, 'O')) {	
			Board(display);
			System.out.println("Computer wins!");
			return true;
		}
		
		for (int i = 0; i < display.length; i++) {
			for (int j = 0; j < display[i].length; j++) {
				if (display[i][j] == ' ') {
					return false;
				}
			}
		}
		Board(display);
		System.out.println("TIE!");
		return true;
	}


	private static boolean Won(char[][] display, char symbol) {
		if ((display[0][0] == symbol && display [0][1] == symbol && display [0][2] == symbol) ||
			(display[1][0] == symbol && display [1][1] == symbol && display [1][2] == symbol) ||
			(display[2][0] == symbol && display [2][1] == symbol && display [2][2] == symbol) ||
			
			(display[0][0] == symbol && display [1][0] == symbol && display [2][0] == symbol) ||
			(display[0][1] == symbol && display [1][1] == symbol && display [2][1] == symbol) ||
			(display[0][2] == symbol && display [1][2] == symbol && display [2][2] == symbol) ||
			
			(display[0][0] == symbol && display [1][1] == symbol && display [2][2] == symbol) ||
			(display[0][2] == symbol && display [1][1] == symbol && display [2][0] == symbol) ) {
			return true;
		}
		return false;
	}


	private static void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerMove;
		while (true) {
			computerMove = rand.nextInt(9) + 1;
			if (valid(board, Integer.toString(computerMove))) {
				break;
			}
		}
		System.out.println("Computer choose " + computerMove);
		Move(board, Integer.toString(computerMove), 'O');
	}


	private static boolean valid (char[][] display, String position) {
		switch(position) {
			case "1":
				return (display[0][0] == ' ');
			case "2":
				return (display[0][1] == ' ');
			case "3":
				return (display[0][2] == ' ');
			case "4":
				return (display[1][0] == ' ');
			case "5":
				return (display[1][1] == ' ');
			case "6":
				return (display[1][2] == ' ');
			case "7":
				return (display[2][0] == ' ');
			case "8":
				return (display[2][1] == ' ');
			case "9":
				return (display[2][2] == ' ');
			default:
				return false;
		}
	}

	private static void playerTurn(char[][] display, Scanner scanner) {
		String userInput;
		while (true) {
			System.out.println("Enter a number (1-9)");
			userInput = scanner.nextLine();
			if (valid(display, userInput)){
				break;
			} else {
				System.out.println(userInput + "INVALID!");
			}
		}
		Move(display, userInput, 'X');
	}


	private static void Move(char[][] display, String position, char symbol) {
		switch(position) {
			case "1":
				display[0][0] = symbol;
				break;
			case "2":
				display[0][1] = symbol;
				break;
			case "3":
				display[0][2] = symbol;
				break;
			case "4":
				display[1][0] = symbol;
				break;
			case "5":
				display[1][1] = symbol;
				break;
			case "6":
				display[1][2] = symbol;
				break;
			case "7":
				display[2][0] = symbol;
				break;
			case "8":
				display[2][1] = symbol;
				break;
			case "9":
				display[2][2] = symbol;
				break;
			default:
				System.out.println();
		}
	}

	
	
	
	private static void Board(char[][] display) {
		System.out.println(display[0][0] + "|" +  display[0][1] + "|" +  display[0][2] );
		System.out.println("-----");
		System.out.println(display[1][0] + "|" +  display[1][1] + "|" +  display[1][2] );
		System.out.println("-----");
		System.out.println(display[2][0] + "|" +  display[2][1] + "|" +  display[2][2] );
	}
	
}