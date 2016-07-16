package GameBoard;

import java.util.ArrayList;

public class SeaMonster implements GamePlayer {

	private Point currentPosition; 
	private int[][] board;
	public SeaMonster(int [][] board){
		this.board=board;
	}
	@Override
	public Point getPosition() {
		
		return currentPosition;
	}

	@Override
	public ArrayList<Point> allowedMoves() {
		ArrayList<Point> moves=new ArrayList<Point>();
		int x=currentPosition.x;
		int y=currentPosition.y;
		int N=board.length;
		for(int i=x;i<N;i++){
			//check if water
			if(board[i][y]==2)
			{
				moves.add(new Point(i,y));
				continue;
			}
			break;
		}
		for(int i=x;i>=0;i--){
			if(board[i][y]==2)
			{
				moves.add(new Point(i,y));
				continue;
			}
			break;
		}
		for(int i=y;i<N;i++){
			if(board[x][i]==2)
			{
				moves.add(new Point(x,i));
				continue;
			}
			break;
		}
		for(int i=y;i>=0;i--){
			if(board[x][i]==2)
			{
				moves.add(new Point(x,i));
				continue;
			}
			break;
		}
		return moves;
	}

}
