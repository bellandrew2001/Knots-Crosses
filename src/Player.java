
public class Player{

    String name;
    Piece piece;
    boolean turn;

    public Player(String name, Piece piece, boolean turn) {
        this.name = name;
        this.piece = piece;
        this.turn = turn;
    }

    public String getName() {
        return this.name;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public boolean getTurn() {
        return this.turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

}
