package GameBoard;

import java.util.ArrayList;

public interface GamePlayer {
	public Point getPosition();
	public ArrayList<Point> allowedMoves();
}
