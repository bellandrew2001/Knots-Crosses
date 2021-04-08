enum Colour {Blue, Red, Green, Yellow, Orange, Black, Purple, Pink}
enum Piece {Knot, Cross}

public class Player{

    String name;
    Colour colour;
    Piece piece;

    public Player(String name, Colour colour, Piece piece) {
        this.name = name;
        this.colour = colour;
        this.piece = piece;
    }

    public static void main(String[] args) {
        Player A = new Player("Andrew", Colour.Blue, Piece.Knot);

        System.out.println(A.getName());
        System.out.println(A.getColour());
        System.out.println(A.getPiece());
    }

    public String getName() {
        return this.name;
    }

    public Colour getColour() {
        return this.colour;
    }

    public Piece getPiece() {
        return this.piece;
    }

}
