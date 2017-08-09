
public class BST {
	
  public Node root;
  
  public BST() {
	  root=null;
  }
  
  public boolean search(int val) {
	Node current=root;
	while(current!=null) {
		if(current.value()==val)
			return true;
		else {
			if(current.value()>val) 
				current=current.getLeft();
			else
				current=current.getRight();
		}
	}
	return false;
  }
  
  private Node insert(Node node, int data)
  {
      if (node == null)
          node = new Node(data);
      else
      {
          if (data <= node.value())
              node.setLeft(insert(node.getLeft(), data));
          else
              node.setRight(insert(node.getRight(), data));
      }
      return node;
  }
  public void insert(int val) {
	  if(!search(val))
	  root=insert(root,val);
  } 
  
  public void delete(int val) {
	  delete(root,val);
  }
  private void delete(Node n,int val) {
	  if(!search(val)) return;
	  Node current=n;
	  Node parent=n;
	  boolean is_left=false;
	  while(current.value()!=val) {
		  parent=current;
		  if(current.value()>val) {
			  current=current.getLeft();
			  is_left=true;
		  }
		  else {
			  current=current.getRight();
			  is_left=false;
		  }
	  }
	  if(current.getLeft()==null&&current.getRight()==null) {
		   if(current==root)
			   root=null;
		   else
			   if(is_left)
				   parent.setLeft(null);
			   else
				   parent.setRight(null);
	  }
	  if(current.getLeft()==null&&current.getRight()!=null) {
		  if(current==root)
			  root=current.getRight();
		  else
			  if(is_left) 
				  parent.setLeft(current.getRight());
			  else
				  parent.setRight(current.getRight());
	  }
	  if(current.getLeft()!=null&&current.getRight()==null) {
		  if(current==root)
			  root=current.getLeft();
		  else
			  if(is_left)
				  parent.setLeft(current.getLeft());
			  else
				  parent.setRight(current.getRight());
	  }
	  if(current.getLeft()!=null&&current.getRight()!=null) {
		  Node succ=successor(current);
		  if(current==root) 
			  root=succ;
		  else if(is_left)
			  parent.setLeft(succ);
		  else
			  parent.setRight(succ);
		  succ.setLeft(current.getLeft());	  
  }
  }
  private Node successor(Node cur) {
	    Node succ =null;
		Node succParent =null;
		Node current= cur.getRight();
		while(current!=null){
			succParent = succ;
			succ = current;
			current = current.getLeft();
		}
		
		if(succ!=cur.getRight()){
			succParent.setLeft(succ.getRight());
			succ.setRight(cur.getRight());
		}
		return succ;
  }
  public void print(Node n) {
	  if(n==null) return;
	  System.out.println(n.value());
	  if(n.getLeft()!=null)
		  print(n.getLeft());
	  if(n.getRight()!=null)
		  print(n.getRight());  
  }
}
