package LLD.TicTacToe;

import java.util.Deque;
import java.util.Scanner;
import java.util.LinkedList;

import LLD.TicTacToe.model.Board;
import LLD.TicTacToe.model.Player;
import LLD.TicTacToe.model.PlayerType;

/**
 * GameManager
 */
public class GameManager {

    private Deque<Player> players;
    private Board board;
    private Scanner sc;

    public GameManager() {
        sc = new Scanner(System.in);
        this.initialize();
    }

    private void initialize() {
        System.out.println("What is the size of the board?: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        board = new Board(n);

        System.out.println("How many players?: ");
        @SuppressWarnings("unused")
        int noOfPlayers = sc.nextInt();
        sc.nextLine(); 
        
        players = new LinkedList<>();
        players.offer(new Player(null, PlayerType.X));
        players.offer(new Player(null, PlayerType.O));
    }

    public void play() {
        boolean hasMoves = true;

        while (hasMoves) {
            System.out.println(board);
            Player player = players.poll();

            System.out.println(String.format("%s's turn, Enter x, y coordinates: ", player.getPlayerType()));
            String[] strs = sc.nextLine().split(",");
            
            if (strs.length != 2) {
                System.out.println("Invalid input format. Please enter coordinates as x,y.");
                players.addFirst(player); 
                continue;
            }

            try {
                int x = Integer.parseInt(strs[0].trim());
                int y = Integer.parseInt(strs[1].trim());

                if (!board.isValidMove(x, y)) {
                    System.out.println("Invalid move, please try again!");
                    players.addFirst(player); 
                    continue;
                }

                board.move(x, y, player);
                players.offer(player); 
                hasMoves = board.hasMovesLeft();
                
                if (board.isGameOver(x, y, player)) {
                    System.out.println(String.format("%s won!", player));
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid integers for coordinates.");
                players.addFirst(player); 
            }
        }
        System.out.println("tied!");
    }

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        try {
            gameManager.play();
        } finally {
            gameManager.sc.close(); 
        }
    }
}
