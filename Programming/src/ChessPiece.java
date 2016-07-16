import java.util.ArrayList;

public interface ChessPiece {
	ChessPosition getPosition();
	ArrayList<ChessPosition> allowedMoves();
	boolean captures(ChessPosition pos);
}
