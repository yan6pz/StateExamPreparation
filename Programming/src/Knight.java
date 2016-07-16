import java.util.ArrayList;

public class Knight implements ChessPiece {

	private ChessPosition currentPosition;
	private int[][] dir = {{2, 1}, {1, 2}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}};

	public Knight(ChessPosition position){
		currentPosition=position;
	}
	
	@Override
	public ChessPosition getPosition() {
			return currentPosition;
	}

	@Override
	public ArrayList<ChessPosition> allowedMoves() {
		ArrayList<ChessPosition> allowed=new ArrayList<ChessPosition>();
		int currentRow=currentPosition.getRow();
		char currentColumn=currentPosition.getColumn();
		for(int[] d : dir){
			int row=currentRow+d[0];
			char col=(char)(currentColumn+d[1]);
			if(row<1 || row>8 || col>'H' ||col<'A')
				continue;
			allowed.add(new ChessPosition(row,col));
		}
		return allowed;
	}

	@Override
	public boolean captures(ChessPosition pos) {
		
		return allowedMoves().contains(pos);
	}

}
