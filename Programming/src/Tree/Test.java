package Tree;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		//07.15
		Node root=new Node();
		root.data=8;
		Node c1=new Node();
		c1.data=2;
		Node c2=new Node();
		c2.data=3;
		Node c21=new Node();
		c21.data=4;
		Node c22=new Node();
		c22.data=5;
		Node c23=new Node();
		c23.data=6;
		root.children.add(c1);
		c2.children.add(c21);
		c2.children.add(c22);
		c2.children.add(c23);
		root.children.add(c2);
		Recursion.print(root);
		System.out.println(Recursion.member2(root,2));
		System.out.println(Recursion.member2(root,3));
		System.out.println(Recursion.member2(root,7));
		System.out.println(Recursion.member2(root,5));
		Recursion.filterOdd2(root);
		Recursion.print(root);
		
		//09.15
		/*int a[]={5,3,8,0,2,6,4,1,5,-2};
		selectionSort(10,a);
		for(int q:a){
			System.out.print(q);
			System.out.print(" ");
		}
		System.out.println(member(-2,a,10));
		System.out.println(member(5,a,10));
		System.out.println(member(6,a,10));
		System.out.println(member(8,a,10));*/
		
		//09.15(2)
		int m=2;int n=3;
		Graph g=new Graph(m,n);
		 Scanner scanner = new Scanner(System.in);
         
		for(int i=0;i<m;++i){
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			g.edges[x][g.edgesCount[x]++]=y;
		}
		System.out.println(g.isConnected(g));

	}
	//09.15
	static void selectionSort(int N,int[]nums){
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i; j < N; j++) {
			if(nums[j] < nums[min]) min = j;
			}
			if(min != i) {
				int x = nums[i];
				nums[i] = nums[min];
				nums[min]=x;
			}
		}
	}
	//09.15 c++
	static boolean member (int x, int a[], int size){
		if (size == 0) return false;
		return a[size/2] == x ||
		//(a[size/2] < x && member (x,a+size/2+1,size/2-1)) ||
		(a[size/2] > x && member (x,a,(size)/2));
		}

}
