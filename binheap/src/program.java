import java.io.*;
import java.util.*;

public class program {
	public static int max(int f,int s) {
		if(f>s)
			return f;
		return s;
	}
	public static final int MAX_TIME=120000;
	
	public static void main(String[] args) throws Exception {
		Scanner in=new Scanner(new FileReader("input.csv"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		// all variables
		String temp_line;
		app_entry item;
		String[] temp_tokens;
		Queue<app_entry> q=new LinkedList<app_entry>(); //queue to keep entries.
		int current_time=0;
		String current_name="";
		if(in.hasNext())
		temp_line=in.nextLine(); //read first line
		//add every application info into queue
		while(in.hasNextLine()) {
			temp_line=in.nextLine();
			temp_tokens=temp_line.split(",");
			item=new app_entry(temp_tokens[0],Integer.parseInt(temp_tokens[1]),Integer.parseInt(temp_tokens[2]),Integer.parseInt(temp_tokens[3]));
			q.add(item);
		}
        BinHeap heap=new BinHeap(q.size());
        if(!q.isEmpty())
           heap.add(q.remove());
	    while(!heap.is_empty()) {
	    	if(max(heap.peek().getStart(),current_time)+heap.peek().getDuration()<=MAX_TIME) {
	    		current_name=heap.peek().getName();
	    		current_time=max(current_time,heap.peek().getStart())+heap.peek().getDuration();
	    		//out.print(heap.peek().getName());
	    		heap.remove();
	    	}
	    	else
	    		break;
	    	while(!q.isEmpty()) 
	           if(q.peek().getStart()<=current_time)
	    		heap.add(q.remove());
	           else {
	        	   heap.add(q.remove());
	        	   break;
	           } 
	    		
	    }
	    out.print(current_name);
		out.close();
}
}
