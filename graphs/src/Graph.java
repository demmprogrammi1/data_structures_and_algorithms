import java.util.*;
	
   
public class Graph {

	    private  Map< String ,Node > adj; //mapping every name of vertex to its Node
	    
	    private List<String> names; //list of names(vertices)
	    
	    List<Node> Nodes;//list of all Nodes
	    
	    List<Edge> Edges;//list of all Edges
	    
	    private int n; //number of vertices

	    public Graph(List<String> nodes) {
	        adj = new HashMap<>();
	        Node tempNode;
	        Nodes = new LinkedList<>();
	        Edges = new LinkedList<>();
	        for (int i = 0; i < nodes.size(); i++) {
	        	tempNode = new Node(nodes.get(i));
	            adj.put(nodes.get(i), tempNode);
	            Nodes.add(tempNode);
	        }
	        names = nodes;
	        n = nodes.size();
	    }

        // return Node by its name
	    private Node getNode(String node){
	        return adj.get(node);
	    }
        //add edge between two given vertices 
	    public void addNeighbor(String v1,String v2,Entry entry) {
	    	Node f = getNode(v1);
	    	Node s = getNode(v2);
	    	Edge edg = new Edge(f,s,entry);
	        f.addNeighbor(edg);
	        s.addNeighbor(edg);
	        Edges.add(edg);
	    }
	    //Delete an Edge between two given vertices
	    void DeleteNeighbor(String v1,String v2) {
	    	getNode(v1).deleteNeighbor();
	    	getNode(v2).deleteNeighbor();
	    	Edges.remove(Edges.size()-1);
	    }

	    List<Edge> getNeighbors(String v) {
	        return getNode(v).neighbors;
	    }

	   /* Collection<Node> getNodes(Graph g){
	        return g.adj.values();
	    }
	    */
	    
	    //that function set default values to all Nodes in a given Graph
	    void SetDefault() {
	    	for(Node node : Nodes)  {
	    		node.visited = false;
	    	    node.cost = 0;
    		    node.time = 0;
	    	}
	    }
	   
	    public String getInfo(String v1,String v2,double amount) {
	    	SetDefault();
	    	return getInf(v1,v2,amount);
	    }
	    // that function return time and cost needed to get from vertex v1 to vertex v2.
	    /*
	      we are starting from our source vertex and traverse by all its neightbors.If neighbor is visited then nothing to do,else
	      we compute time and cost to neighbor vertex and add it to our queue.
	      As we deal with MST there is only only way between any two  arbitrary chosen vertices.
	     */
	    private  String getInf(String v1,String v2,double amount) {
	    	double time = 0,cost = 0;
	    	Queue<Node> queue = new LinkedList<Node>();
	    	queue.add(getNode(v1));
	    	Node current;
	    	while(!queue.isEmpty()) {
	    		current = queue.remove();
	    		current.visited = true;
	    		if(current.element.equals(v2)) {
	    			time = (double)Math.round(10*getNode(v2).time)/10;
	    			cost = (double)Math.round(10*getNode(v2).cost)/10;
	    			return time+ " " +cost;
	    		}
	    			
	    		for(Edge edge : current.neighbors)  {
	    			Node node = edge.getAdj(current);
	    			if(!node.visited) {
	    			node.cost = current.cost + edge.getPrice()*amount;
	    			node.time = current.time + edge.getTime();
	    			queue.add(node);
	    		}	
	    	}
	    	}
	    	return "0";
	    }
	    public Graph MST() {
	    	 Graph resultGraph = new Graph(names);
	    	 
	    	 Collections.sort(Edges);
	    	 Edge tempEdge;
	    	 int pos = 0; //position ,where to retrieve edge from Edges
	    	 while(resultGraph.Edges.size()<n-1) { //while there is less than n-1 edges  then continue searching edges
	    		 while(true) {
	    	 	 tempEdge = Edges.get(pos);
	    		 resultGraph.addNeighbor(tempEdge.first.element, tempEdge.second.element, 
	    				 tempEdge.entry);
	    		 pos++;
	    		 if(resultGraph.isCyclic())
	    			resultGraph.DeleteNeighbor(tempEdge.first.element,tempEdge.second.element); 
	    		 else
	    			 break;
	    	 }
	    	 }
	    	return resultGraph;	 
	    	 
	     }
	    //check whether given component has a cycle or not
	    private boolean isCyclicUtil(String from, String parent) { 
	         getNode(from).visited = true;
	         
	         List<Edge> list = getNode(from).neighbors;
	       
	         for(Edge edge : list) {
	        	 Node node = edge.getAdj(getNode(from));
	             if (!node.visited)
	             {
	                 if (isCyclicUtil(node.element, from))
	                     return true;
	             }
	  
	             // If an adjacent is visited and not parent of current
	             // vertex, then there is a cycle.
	             else if (!node.element.equals(parent))
	                 return true;
	         }
	         return false;
	     }
	  
	     // Returns true if the graph contains a cycle, else false.
	     private boolean isCyclic() {
             SetDefault();
	  
	         // Call the recursive helper function to detect cycle in
	         // different DFS trees
	         for (Node node : Nodes)
	             if (!node.visited) // Don't recur for u if already visited
	                 if (isCyclicUtil(node.element,"-1"))
	                     return true;
	         return false;
	     }
	    
	    
}
