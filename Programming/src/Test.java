import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Test {
	private static int [ ] [ ] fields = {   { 0, 1, 0, 1, 0,0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0,0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0,0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0,0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0,0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0,0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0,0, 1, 1, 1, 0 },
			{ 0, 1, 0, 1, 0,0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0,0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0,0, 1, 0, 1, 1 },
        };
	public static void main(String[] args) {
		/*07.10
		 * Notebook note=new Notebook(false,3.14,2.89,false,4);
		Notebook noteClone=new Notebook(note);
		note.setCondition(true);
		note.setCPUNumber(1);
		ArrayList<Notebook> notebooks=new ArrayList();
		notebooks.add(note);
		notebooks.add(noteClone);
		note.setNetworkComps(notebooks);
		System.out.println(note.getNetworkComps());*/
		
		/*07.10
		 * LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(-3);
        linkedList.add(6);
        linkedList.add(6);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(-6);
        linkedList.add(6);
        linkedList.add(-2);
        linkedList.add(2);
        System.out.println(maxEqualConsecutiveNumbersInLinkedList(linkedList));*/
		/*07.10(2)
		Node n1=new Node(2);
		Node n2=new Node(3);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(4);
		Node n6=new Node(4);
		n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;
		System.out.println(FindMaxEqualSequence(n1));*/
		
		/*09.10
		 * String symbols="((1+2)-3*4)+(13/3)";
	
		System.out.println(areBracketsOk(symbols));
		String symbols1="((1+2)-3*4))+(13/3)";
		System.out.println(areBracketsOk(symbols1));
		String symbols2=")((1+2)-3*4)+(13/3)";
		System.out.println(areBracketsOk(symbols2));
		String symbols3="(((1+2)-3*4)+(13/3)";
		System.out.println(areBracketsOk(symbols3));	 */
		
		//07.14
		/*try {
			matrixGeneration();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		//07.14(2)
		Rook r=new Rook(new ChessPosition(1,'A'));
		Knight k=new Knight(new ChessPosition(3,'B'));
		ArrayList<ChessPiece> pieces=new ArrayList<ChessPiece>();
		pieces.add(r);pieces.add(k);
		ArrayList<ChessPiece> stable=allMoves(pieces);
		for(int i=0;i<pieces.size();i++ ){
			if (pieces.get(i) instanceof Rook) {
				System.out.println("Rook "+pieces.get(i).getPosition().toString()+" -> "+stable.get(i).getPosition().toString());
			}
			else
				System.out.println("Knight "+pieces.get(i).getPosition().toString()+" -> "+stable.get(i).getPosition().toString());
		}*/
		
		//09.14(1)
		/*float[] x={1.0F,1.0F};
		float[] y={1.0F,5.0F};
		SurroudingSquare s=square(2,x,y);
		System.out.printf("side:%f O(%f,%f)",s.side,s.Ox,s.Oy);
		float[] x1={1.0F,1.0F,-1.0f,-1.0F,7.0F};
		float[] y1={1.0F,5.0F,-3.0F,5.0F,-3.0F};
		SurroudingSquare s1=square(5,x1,y1);
		System.out.printf("side:%f O(%f,%f)",s1.side,s1.Ox,s1.Oy);*/
		
		//07.14 Inf Sist
		/*char[] dir={'S','W','W','N','N','N','W'};
		char[] dir2={'N','W','W','N','N','N','W'};
		char[] dir3={'S','W','N','N','N','W'};
		char[] dir4={'N'};
		char[] dir5={'E'};
		System.out.print(String.valueOf(dir)+" " + String.valueOf(walk(fields,dir))+" ");
		System.out.print(String.valueOf(dir2)+" " + String.valueOf(walk(fields,dir2))+" ");
		System.out.print(String.valueOf(dir3)+" " + String.valueOf(walk(fields,dir3))+" ");
		System.out.print(String.valueOf(dir4)+" " + String.valueOf(walk(fields,dir4))+" ");
		System.out.print(String.valueOf(dir5)+ " " +String.valueOf(walk(fields,dir5))+" ");*/
		//07.15(1)
		float[][] img={{1.0f,2.0f,3.0f},{4.5f,6.5f,7.5f}};
		int m=img.length;
		int n=img[0].length;
		float s[][]=subsample(m,n,img);
		for(int x=0;x<(m+1)/2;++x){
			for(int y=0;y<(n+1)/2;++y){
				System.out.printf(s[x][y]+" ");
			}
			System.out.println();
		}
	}
	//07.15(1)
	private static float[][] subsample(int M, int N, float[][] img) {
		float s[][]=new float[(M+1)/2][(N+1)/2];
		for(int i=0;i<(M+1)/2;++i){
			for(int j=0;j<(N+1)/2;++j){
				float sum=0.0f;
				int count=0;
				for(int x=i*2;x<=i*2+1;++x){
					for(int y=j*2;y<=j*2+1;++y){
						if(x>=M || y>=N)
							continue;
						sum+=img[x][y];
						count++;
					}
				}
				s[i][j]=sum/count;
			}
		}
		return s;
	}

	//07.14 Inf Sist
	public static boolean walk(int [][]field,char[] dir){
		int end=field[9][9];
		if(end==0)
			return false;
		
		int x=field.length-1;
		int y=field.length-1;
		for(int i=dir.length-1;i>=0;--i){
			//down
			if(dir[i]=='S')
				if(!(x<field.length-1 && field[++x][y]==1))
					return false;
			//left
			if(dir[i]=='W')
				if(!(y>0 && field[x][--y]==1))
					return false;
			//right
			if(dir[i]=='E')
				if(!(y<field.length-1 && field[x][++y]==1))
					return false;
			//up
			if(dir[i]=='N')
				if(!(x>0 && field[--x][y]==1))
					return false;
			
				
		}
		return true;
	}
	//09.14(1)
	public static SurroudingSquare square(int n,float[] x,float[]y){
		Arrays.sort(x);
		Arrays.sort(y);
		float biggestX=x[n-1];
		float biggestY=y[n-1];
		float smallestX=x[0];
		float smallestY=y[0];
		SurroudingSquare square=new SurroudingSquare(biggestX,smallestX,biggestY,smallestY);
			
		return square;
	}
	//07.14(2)
	public static ArrayList<ChessPiece> allMoves(ArrayList<ChessPiece> pieces){
		ArrayList<ChessPiece> stableConfig=new ArrayList<ChessPiece> ();
		for(ChessPiece piece :pieces ){
			if (piece instanceof Rook) {
				//get all possible moves
				ArrayList<ChessPosition> allowedMoves=piece.allowedMoves();
				//for each possible move check if it is free and if not fill it
				//and continue with the next piece
				for(ChessPosition position : allowedMoves)
				{
					if(CheckIfIsFree(position,stableConfig,true))
						break;
				}
			}
			else if(piece instanceof Knight){
				ArrayList<ChessPosition> allowedMoves=piece.allowedMoves();
				for(ChessPosition position : allowedMoves)
				{
					if(CheckIfIsFree(position,stableConfig,false))
						break;
				}
			}
		}
		return stableConfig;
	}
	
	//check if in the stable config pieces there is piece which captures given position
	// if yes then return false(the position is not free) and continue searching the next moves
	private static boolean CheckIfIsFree(ChessPosition position, ArrayList<ChessPiece> stableConfig,boolean isRook) {
		if(stableConfig.isEmpty())
		{
			if (isRook) {
				stableConfig.add(new Rook(position));
			}
			else
				stableConfig.add(new Knight(position));
			
			return true;
		}
			
		for(ChessPiece piece :stableConfig ){
			if(piece.captures(position))
				return false;//this position is already attacked
			
			if (isRook) {
				stableConfig.add(new Rook(position));
				return true;
			}
			else{
				stableConfig.add(new Knight(position));
				return true;
			}
				
		}
		return false;
		
	}

	//07.14(1)
	public static void matrixGeneration() throws UnsupportedEncodingException{
		float [] A=new float[27];
		Random rand=new Random();
		PrintStream ps = new PrintStream(System.out, true, "UTF-8");
		for(int i=0;i<27;++i){
			A[i]= 4.9F*rand.nextFloat();
		}

		ps.format("%-8s", "Под 1");
		ps.format("%-8s", "Под 2");
		ps.format("%-8s", "Под 3");
		ps.format("%-8s", "Под 4");
		ps.format("%-8s", "Под 5");
		
		for(int i=0;i<27;++i){
			double fractionalPart = A[i] % 1;
			int integralPart = (int)(A[i] - fractionalPart);
			DecimalFormat formatter = new DecimalFormat("#0.0000");     
			switch(integralPart)
			{
			case 1:
				System.out.printf("%8s %n",formatter.format(A[i]));
				break;
			case 2:
				System.out.printf("%16s %n",formatter.format(A[i]));
				break;
			case 3:
				System.out.printf("%24s %n",formatter.format(A[i]));
				break;
			case 4:
				System.out.printf("%32s %n",formatter.format(A[i]));
				break;
			case 5:
				System.out.printf("%40s %n",formatter.format(A[i]));
				break;
			}

		}

	}
	
	
	//09.10
	public static boolean areBracketsOk(String symbols){
		int size=symbols.length();
		char[] allSymbols=symbols.toCharArray();
		MyStack stack=new MyStack(size);
		for(int i=0;i<size;i++){
			if(allSymbols[i]=='(')
				stack.put('(');
			else if(allSymbols[i]==')')
			{
				if(stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
	//07.10
	
	public static int FindMaxEqualSequence(Node start){
		int maxNum=1;
		int temp=1;
		for(Node t=start;t!=null;t=t.next){
			
			if(t.next!= null && t.data==t.next.data)
				++temp;
			else
				temp=1;
			if(maxNum<temp)
				maxNum=temp;
			
		}
		return maxNum;
	}
	
	public static int maxEqualConsecutiveNumbersInLinkedList(LinkedList<Integer> linkedList){
		
		int maxNumber=1;
		int currNumber=1;
		int prevElement=linkedList.get(0);
		for (int i = 1; i < linkedList.size(); i++) {
            if(prevElement==linkedList.get(i))
            {
            	currNumber++;
            	if(currNumber>maxNumber)
            	{
            		maxNumber=currNumber;
            	}
            }
            else
            {
            	currNumber=1;
            	prevElement=linkedList.get(i);
            }
        }
		
		
		return maxNumber;
		
		
	}
}
