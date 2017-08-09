
public class Edge {
	
       Node  first,second;
       
       //return the Node that is adjacent to given Node
       public Node getAdj(Node n) {
    	   if(n == first) 
    		   return second;
    	   return first;
       }
       public Edge(Node first,Node second) {
    	   this.first = first;
    	   this.second = second;
       }
       public String toString() {
    	   return first.element + " " +second.element + " ";
       }
       
    };