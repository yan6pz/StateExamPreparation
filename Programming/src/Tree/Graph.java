package Tree;

public class Graph {

	int size;
	int [][] edges=new int[1000][1000];
	int []edgesCount=new int[1000];
	
	
	public Graph(int m, int n) {
		size=n;
	}

	private boolean hasPathTo(int startVert,int endVert){
		
		for(int i=0;i<edgesCount[startVert];++i){
			
			if(hasPathTo(edges[startVert][i],endVert))
				return true;
		}
		if(startVert==endVert)
			return true;
		return false;
		
	}
	
	//O(V*(V+E))
	boolean isConnected(Graph g){
		
		//traverse the vertices starting from 1
		for(int i=1;i<size;++i){
			for(int j=i+1;j<size+1;++j){
				if(!hasPathTo(i,j) &&!hasPathTo(j,i))
					return false;
					
			}
		}
		return true;
	}
}
