import java.util.ArrayList;

public class Rook implements ChessPiece {

	private ChessPosition currentPosition;
	
	public Rook(ChessPosition position){
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
		for(int i=currentRow;i<7;i++){
			allowed.add(new ChessPosition(i,currentColumn));
		}
		for(int i=currentRow;i>1;i--){
			allowed.add(new ChessPosition(i,currentColumn));
		}
		for(int i=currentColumn-'A'+1;i<7;i++){
			allowed.add(new ChessPosition(currentRow,(char)(i+64)));
		}
		for(int i=currentColumn-'A'+1;i>1;i--){
			allowed.add(new ChessPosition(i,(char)(i+64)));
		}
		return allowed;
	}

	@Override
	public boolean captures(ChessPosition pos) {
		
		return (pos.getRow()==currentPosition.getRow() || pos.getColumn()==currentPosition.getColumn());
	}

}
