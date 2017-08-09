import java.util.LinkedList;
import java.util.List;

public class Node  {
		
	    boolean visited = false;
	    
	    boolean rec = false;
	    
	    String element; //its name
	    
	    int value; // store node's value if it is explicitly assigned
	    
	    boolean relation; // +(true) or *(false)
	    
	    List<Node> neighbors = new LinkedList<>(); // list of all incoming edges to this Node
	    
	    Node(String v , int value) {
	        element = v;
	        this.value = value;
	    }
	    Node(String v) {
	    	element = v;
	    }
	    void addRel(boolean rel) {
	    	relation = rel;
	    }
	    void addNeighbor(Node n) {
	       neighbors.add(n);
	    }
	    
	};