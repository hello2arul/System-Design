package LLD.TicTacToe.model;

public class Player {
    
    private final String name;
    private final PlayerType playerType;

    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; 
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Player other = (Player) obj;
        return name.equals(other.name) && playerType.equals(other.playerType);
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }

    @Override
    public String toString() {
        return String.format("[name=%s, type=%s]", name, playerType);
    }
}
