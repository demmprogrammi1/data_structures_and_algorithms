import java.io.*;
import java.util.*;
public class Main {
	 
	 /*
	  *                           Explanation
	  * First of all, i retrieve Nodes from given expression and check to what pattern it confirms: X=Int  X=Y(*|+)Z or X=int(+|*)Y
	  * every Node has a value field.If it is first pattern,when i just assign int to value
	  * if it is second pattern , value field of X node doesnt matter now .I just add neighbor (Y,Z) to X node.
	  * if it is third pattern,i assign int to value,and add remained node(Y) to neighbors of X node.
	  * {name,value}
	  * Thus
	  * X=2
	  * B=3*X
	  * A=X+B
	  * X has value 2. 
	  * B has value 3 and one neighbor = X
	  * A has no value but 2 neighbors = X and B;
	  */
	 //check whether given string is Node
	 public static boolean isNode(String s) {
		 return s.length() == 1 && s.charAt(0) >= 'A' && s.charAt(0) <= 'Z' ;
	 }
	 
	 private static final int INF = 10000000;
	 
	 /*
	  * return integer representation of given string if it is a number,otherwise return infinity
	  */
	 public static int getNumber(String s) {
		if(!isNode(s))
			return Integer.parseInt(s);
		else
			return INF;
	 }
	 
	 public static int min(int a,int b) {
		 return a > b ? b : a;
	 }
	 
	 /*
	  * return a value(maximum  one node out of two is number) if it exists,otherwise return infinity
	  */
	 public static int getValue(String v1, String v2) {
		 if(min(getNumber(v1),getNumber(v2)) != INF)
             return min(getNumber(v1),getNumber(v2));
		 return INF;
	 }
	 
	 public static void main(String[] args) throws IOException {
	    	Scanner in = new Scanner(new FileReader("input.txt"));
	    	PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
	        String expression,firstNode,secondNode,thirdNode;
	        String[] terms;
	        Graph graph = new Graph();
	        while(in.hasNextLine()) {
	          expression = in.nextLine(); //read a line
	          terms = expression.split("=|\\*|\\+"); //split it into terms (number or nodes)
	          if(terms.length == 3 ) { //if it is expression like X=Y(*|+)Z 
	        	  firstNode = terms[0];
	              secondNode = terms[1];
	              thirdNode = terms[2];
	              graph.AddNode(firstNode, getValue(secondNode,thirdNode)); //adding Node X with value of Y or Z
	              graph.getNode(firstNode).addRel(expression.contains("+")); //setting relation to node X
	              if(isNode(secondNode))  //if Y is a node ,add it to the graph
	            	  graph.addNeighbor(firstNode, secondNode);	
	              if(isNode(thirdNode))  // if Z is a node,add it to the graph
	            	  graph.addNeighbor(firstNode, thirdNode);  
	              // only one out of two is a number(reminder)
	          }
	          else if(terms.length == 2) //in case if expression like X=Integer_numb
	        	 graph.AddNode(terms[0], Integer.valueOf(terms[1]));
	        	 
	        }
	        if(graph.isCyclic())
	        	out.print("ERROR");
	        else
	        	out.print(graph.getAnswer());
	        out.close();
	 }
}
	              
	            	  
	            	  
	            	  
	
