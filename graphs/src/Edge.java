
public class Edge implements Comparable<Edge> {
	
       Node  first,second;
       
       Entry entry;
       
       
       public double getDist() {
    	   return entry.getDist();
       }
       public double getTime() {
    	   return entry.getTime();
       }
       public double getPrice() {
    	   return entry.getPrice();
       }
       //return the Node that is adjacent to given Node
       public Node getAdj(Node n) {
    	   if(n == first) 
    		   return second;
    	   return first;
       }
       public Edge(Node fir,Node sec,Entry e) {
    	   first = fir;
    	   second = sec;
    	   entry = e;
       }
       public String toString() {
    	   return first.element + " " +second.element + " " + getDist() + " " +getTime()+ " " + getPrice();
       }
       public int compareTo(Edge other) {
    	   if(this.entry.getDist()>other.entry.getDist())
    		   return 1;
    	   if(this.entry.getDist()==other.entry.getDist())
    		   return 0;
    	   return -1;
       }
       
    };