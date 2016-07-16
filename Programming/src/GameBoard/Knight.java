package GameBoard;

import java.util.ArrayList;

public class Knight implements GamePlayer {
	
	private Point currentPosition; 
	private int[][] board;
	public Knight(int [][] board){
		this.board=board;
	}
	@Override
	public Point getPosition() {
		
		return currentPosition;
	}

	@Override
	public ArrayList<Point> allowedMoves() {
		int N=board.length-1;
		ArrayList<Point> moves=new ArrayList<Point>();
		int left=currentPosition.y-1;
		int down=currentPosition.x+1;
		int up=currentPosition.x-1;
		int right=currentPosition.y+1;
		//check if not boundary is earth and no fire neighbour
		if(left>=0)
			if((board[currentPosition.x][left]==0)
					&&!((left-1>=0 && board[currentPosition.x][left-1]==1)
				||(down>=0 &&board[left][down]==1)
				||(up<N &&board[left][up]==1)))
				moves.add(new Point(currentPosition.x,left));
		
		if(right<N)
			if((board[currentPosition.x][right]==0) 
					&&!((right+1<N && board[currentPosition.x][right+1]==1)
				||(down>=0 &&board[right][down]==1)
				||(up<N &&board[right][up]==1)))
				moves.add(new Point(currentPosition.x,right));
		
		if(down<N)
			if((board[down][currentPosition.y]==0) 
					&&!((down+1<N && board[down+1][currentPosition.y]==1)
				||(right<N &&board[right][down]==1)
				||(left>=0 &&board[left][down]==1)))
				moves.add(new Point(down,currentPosition.y));
		
		if(up>=0)
			if((board[up][currentPosition.x]==0)
					&&!((up-1>=0 && board[up-1][currentPosition.y]==1)
				||(right<N &&board[right][up]==1)
				||(left>=0 &&board[left][up]==1)))
				moves.add(new Point(up,currentPosition.x));
				
		
		return moves;
	}

}
