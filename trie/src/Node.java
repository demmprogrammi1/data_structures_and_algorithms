
public class Node {
  private int value;
  private Node left;
  private  Node right;
   
   public Node(int value) {
	   this.value=value;
	   left=null;
	   right=null;
   }
   public int value() {
	   return value;
   }
   public Node getLeft() {
	   return left;
   }
   public Node getRight() {
	   return right;
   }
   public void setRight(Node r) {
	   right=r;
   }
   public void setLeft(Node l) {
	   left=l;
   }
}
