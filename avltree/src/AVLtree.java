
public class AVLtree {

	private Node root;
	
	public AVLtree() {
		root=null;
	}
	
	public boolean is_empty() {
		return root==null;
	}
	
	public int height(Node n) {
		if(n==null)
			return 0;
		return n.height;
	}
	
	public int max(int f,int s) {
		if(f>s) return f;
		return s;
	}
	public int search(double value) {
		Node curr=root;
		while(curr!=null) {
			if(curr.data==value)
				return curr.time;
			if(curr.data<value) 
				curr=curr.right;
			else
				curr=curr.left;
		}
		return -1;
	}
	public void insert(double value,int time) {
		root=insert(value,root,time);
	}
    private Node insert(double value, Node n,int time)		 {
           if (n==null)
		      n=new Node(value,time);
		   else if (value<n.data)  {
                n.left = insert(value,n.left,time);
		        if(height(n.left)-height(n.right)== 2)
		            if(value<n.left.data)
		                 n=rotateWithLeftChild(n);
		            else
		                 n=doubleWithLeftChild(n);
		         }
		         else if(value>n.data) {
		             n.right=insert(value,n.right,time);
		             if(height(n.right)-height(n.left)==2)
		                 if(value>n.right.data)
		                     n=rotateWithRightChild(n);
		                 else
		                     n=doubleWithRightChild(n);
		         }
		         else {
		         }
		         n.height = max(height(n.left),height(n.right))+1;
		         return n;
		     }     
		     private Node rotateWithLeftChild(Node n) {
		         Node temp = n.left;
		         n.left = temp.right;
		         temp.right = n;
		         temp.height = max(height(temp.left),height(temp.right))+1;
		         n.height = max(height(n.left),height(n.right))+1;
		         return temp;
		     }
		     private Node rotateWithRightChild(Node n)
		     {
		         Node temp =n.right;
		         n.right =temp.left;
		         temp.left =n;
		         temp.height = max(height(temp.left),height(temp.right))+1;
		         n.height = max(height(n.right),height(n.left))+1;
		         return temp;
		     }
		     private Node doubleWithLeftChild(Node n)
		     {
		         n.left = rotateWithRightChild(n.left);
		         return rotateWithLeftChild(n);
		     }     
		     private Node doubleWithRightChild(Node n)
		     {
		         n.right = rotateWithLeftChild(n.right);
		         return rotateWithRightChild(n);
		     }    
		}
