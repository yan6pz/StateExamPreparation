package Tree;

public class Recursion {
	
	public static boolean member(Node root , int x){
		
		for( Node child : root.children){
			if(member(child,x))
				return true;
		}
		if (root.data==x)
			return true;

		return false;
	}
	public static void filterOdd(Node root){
		
		for( Node child : root.children){
			if(child.data%2!=0)
			{
				child.children=null;
				child=null;
				return;
			}
			filterOdd(child);
		}
	}
	
	public static boolean member2(Node root , int x){
		if (root.data==x)
			return true;
		
		for( Node child : root.children){
			if(member2(child,x))
				return true;
			//else
			//	return false;
		}
		

		return false;
	}
	public static void filterOdd2(Node root){
		
		for( Node child : root.children){
			if(child.data%2!=0)
			{
				child.children=null;
				child=null;
				continue;
			}
			filterOdd2(child);
		}
	}
	
	public static void print(Node root){
		if(root==null ||root.children==null)
			return;
		System.out.println(root.data);
		for( Node child : root.children){
			if(child.children!=null)
			print(child);
		}
		
	}
}
