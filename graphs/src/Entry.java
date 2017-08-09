
public class Entry {
   private double price,distance,time;
   
   public double getDist() {
	   return distance;
   }
   public double getTime() {
	   return time;
   }
   public double getPrice() {
	   return price;
   }
   public Entry(String str) {
	   String[] temp = str.split(":");
	   this.distance = Double.parseDouble(temp[0]);
	   this.time = Double.parseDouble(temp[1]);
	   this.price = Double.parseDouble(temp[2]);
   }
   
   public Entry(double dist,double time,double price) {
	   this.distance = dist;
	   this.time = time;
	   this.price = price;
   }
   
}
