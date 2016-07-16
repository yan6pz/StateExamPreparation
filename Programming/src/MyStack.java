
public class MyStack {
	
	private char[] array;
	private int size;
	
	public MyStack(int maxsize){
		array=new char[maxsize];
		size=0;
	}
	
	public void put(char symbol){
		array[size++]=symbol;
		
	}
	public boolean isEmpty(){
		return size==0;
	}
	public char pop(){
	 char result=array[size];
	 size--;
	 return result;
	}
}
