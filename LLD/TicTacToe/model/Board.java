package LLD.TicTacToe.model;

public class Board {

    private Player[][] board;
    private int n;
    private int freeSpaces;

    public Board(int n) {
        this.n = n;
        freeSpaces = n * n;
        board = new Player[n][n];
    }

    public boolean isValidMove(int x, int y) {
        return x < n && y < n && board[x][y] == null;
    }

    public void move(int x, int y, Player player) {
        board[x][y] = player;
        freeSpaces--;
    }

    public boolean hasMovesLeft() {
        return freeSpaces != 0;
    }

    public boolean isGameOver(int x, int y, Player player) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = false;
        boolean otherDiagonalMatch = false;

        for (int i = 0; i < n; i++) {
            if (board[x][i] != player) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[i][y] != player) {
                columnMatch = false;
                break;
            }
        }

        if (x == y) {
            diagonalMatch = true;
            for (int i = 0; i < n; i++) {
                if (board[i][i] != player) {
                    diagonalMatch = false;
                    break;
                }
            }
        }

        if (x == n - y - 1) {
            otherDiagonalMatch = false;
            for (int i = 0; i < n; i++) {
                if (board[i][n - i - 1] != player) {
                    otherDiagonalMatch = false;
                    break;
                }
            }
        }

        return rowMatch || columnMatch || diagonalMatch || otherDiagonalMatch;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Player player = board[i][j];
                if (player == null) {
                    sb.append("[ ]"); // Empty space
                } else {
                    sb.append("[").append(player.getPlayerType()).append("]"); // Player's symbol
                }
                if (j < n - 1) {
                    sb.append(" | ");
                }
            }
            sb.append("\n");
            if (i < n - 1) {
                sb.append("---".repeat(n - 1));
                sb.append("-\n");
            }
        }

        return sb.toString();
    }
}
