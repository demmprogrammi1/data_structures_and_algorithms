import java.util.*;

public class Graph {
	
	    Map< String ,Node > adj; //mapping every name of vertex to its Node
	    
	    List<Node> Nodes;//list of all Nodes
	    
	    private int n; //number of vertices
	    
	    public Graph() {
	    	Nodes = new LinkedList<>();
	    	adj = new HashMap<>();
	    	n = 0;
	    }

        // return Node by its name
	    Node getNode(String node){
	        return adj.get(node);
	    }
	    
	    
        /* add edge between two given vertices
         * if destination vertex isn't created yet,function create it;
         */
	    public void addNeighbor(String from,String where) {
	    	if(getNode(where) == null)
	    		AddNode(where);
	    	getNode(from).addNeighbor(getNode(where));
	    }
	    
	    List<Node> getNeighbors(String v) {
	        return getNode(v).neighbors;
	    }
	     
	    /*
	     * if graph already contains given vertex,nothing to do,else
	     * create a new node and put it to graph
	     */
	    void AddNode(String v) {
	    	if(!contains(v)) {
	    	Node node = new Node(v);
	    	Nodes.add(node);
	    	adj.put(v, node);
	    	n++;
	    	}
	    }
	    
	    
	    /*
	     * if graph doesn't contain given vertex,create totally new node and add it to graph
	     * else update its value
	     */
	    void AddNode(String v,int val) {
	    	if(!contains(v)) {
	    	Node node = new Node(v,val);
	    	Nodes.add(node);
	    	adj.put(v, node);
	    	n++;
	    	}
	    	else
	    		adj.get(v).value = val;
	    }
	    
	    /* return true if vertex with given name is in the graph
	     * 
	     */
	    boolean contains(String v) {
	    	return (adj.get(v) != null);
	    }
	    
	    
	    /*
	     * Apply DFS algorithm, and compute its value for every node starting from leaves(node without outcoming edges)
	     */
	    void TopSort(String v) {
	    	Node current = getNode(v);
	    	for(Node node : current.neighbors)
	    		TopSort(node.element);
	    	if(current.neighbors.size() == 2) {
	    		int first = current.neighbors.get(0).value;
	    		int second = current.neighbors.get(1).value;
	    		current.value = current.relation ? first + second : first * second ;				
	    	}
	    	else if(current.neighbors.size() == 1)  {
	    		int first = current.neighbors.get(0).value;
	    		current.value = current.relation ? first + current.value : first * current.value ; 
	    	}  	
	    }
	    
	    int getAnswer() {
	    	TopSort("R");
	    	return getNode("R").value;
	    }
	    
	    /*
	     * set default values in given connected component
	     */
	    boolean SetDefault(Node cur) {
	    	cur.visited = false;
	    	cur.rec = false;
	    	for(Node node : cur.neighbors )
	    		if(!node.visited)
	    			return SetDefault(node);
	    	return true;
	    }
	    
	    /*
	     * checks whether there is a vertex with name R in given connected component
	     */
	    boolean hasR(Node cur) {
	    	if(cur.element.equals("R"))
	    		return true;
	    	cur.visited = true;
	    	for(Node node: cur.neighbors)
	    		if(!node.visited)
	    			return hasR(node);
	    	return false;
	    }
	    
	    
	    /*
	     * checks whether there is a cycle in given connected component
	     */
	    boolean isCyclicUtil(Node current) {
	    if(!current.visited) {
	    	current.visited = true;
	    	current.rec = true;
	    	for(Node node : current.neighbors) { 
	    		if(!node.visited && isCyclicUtil(node))	
	    			return true;
	    		else if(node.rec)
	    			return true;
	    	}
	    }
	    	current.rec = false;
	    	return false;
	    }
	    
	    /*
	     * checks whether there is a cycle CONTAINING VERTEX "R"
	     */
	    boolean isCyclic() {
	    	for(Node node : Nodes) {
	    		if(!node.visited) {
	    			if(isCyclicUtil(node) && SetDefault(node) && hasR(node) )
	    				return true;
	    		}
	    	}
	    	return false;
	    }
	    
}
