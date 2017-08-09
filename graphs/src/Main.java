import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	Scanner in = new Scanner(new FileReader("russia.txt"));
    	PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
    	String firstLine = in.nextLine(); //read info about vertices
        List<String> nodesList = Arrays.asList(firstLine.split(" "));
        Graph graph = new Graph(nodesList); //create a new Graph with given Vertices
        String firstNode,secondNode;
        Entry info;
        Double kg; 
        while(in.hasNext()) {
        	firstNode = in.next();
        	secondNode = in.next();
        	info = new Entry(in.next());
        	graph.addNeighbor(firstNode,secondNode,info);
        }
        Graph tree = graph.MST();
        /*for(Edge edge : tree.Edges) 
        	out.println(edge); */
        in = new Scanner(new FileReader("input.txt"));
        while(in.hasNext()) {
        	firstNode = in.next();
        	secondNode = in.next();
        	kg = Double.valueOf(in.next());
        	if(in.hasNext())
        	out.println(firstNode + " " + secondNode + " " +kg + " " +tree.getInfo(firstNode, secondNode, kg));
        	else out.print(firstNode + " " + secondNode + " " +kg + " " +tree.getInfo(firstNode, secondNode, kg));        
        } 
        out.close();

    }
}