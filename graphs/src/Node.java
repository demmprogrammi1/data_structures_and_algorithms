import java.util.LinkedList;
import java.util.List;

	public class Node {
		
	    boolean visited = false;
	    
	    String element; //its name
	    
	    double time; // time from origin vertex to this vertex(for each query it will be different)
	    
	    double cost; //cost from origin vertex to this
	    
	    List<Edge> neighbors = new LinkedList<>(); // list of all adjacent edges to this Node
	    
	    Node(String v) {
	        element = v;
	    }
	    void addNeighbor(Edge e) {
	        neighbors.add(e);
	    }
	    void deleteNeighbor() {
	    	neighbors.remove(neighbors.size()-1);
	    }
	};
