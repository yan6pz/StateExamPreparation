
public class ChessPosition {
	
	private int row;
	private char column;
	
	public ChessPosition(int r,char c){
		setRow(r);
		setColumn(c);
	}
	public ChessPosition(ChessPosition position){
		this(position.getRow(),position.getColumn());
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		if(row>=1&&row<=8)
			this.row = row;
		else
			throw new UnsupportedOperationException();
	}
	public char getColumn() {
		return column;
	}
	public void setColumn(char column) {
		char col=Character.toUpperCase(column);
		if(col>='A'&&col<='H')
			this.column = col;
		else
			throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString(){
		return String.format("%c%d", column,row);
	}
	
}
