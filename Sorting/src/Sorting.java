import java.util.*;
import java.io.*;

public class Sorting {
	
	public static List<double[]> arr=new ArrayList<double[]>();
	
	public static double[] buffer;
	
	public static double[] ar;
	
	public static boolean is(double f,double s,double dif) {
	   if(Math.abs(f-s-dif)<0.0001)
		   return true;
	   return false;
	}

	public static void mergesort(int l,int r) {
		if(l<r) {
			int mid=(l+r)/2;
			mergesort(l,mid);
			mergesort(mid+1,r);
			merge(l,mid,r);
			
		}
	}

	public static void merge(int l,int m,int r) {
		 for (int i = l; i <=r; i++) 
             buffer[i] = ar[i];
             int i = l;
             int j = m+1;
             int p = l;
             while(i<=m&&j<=r) {
            	 if(buffer[i]>buffer[j]) {
            		 ar[p]=buffer[j];
            	     j++;
            	 }
            	 else
            	 {
            		 ar[p]=buffer[i];
            		 i++;
            	 }
            	 p++;  
     }
             while(j<=r) 
                ar[p++]=buffer[j++];
             while(i<=m)
            	ar[p++]=buffer[i++];
	}
	

	public static void main(String[] args)  throws IOException {
		Scanner in=new Scanner(new FileReader("input.csv"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		String[] array;
		double[] temp;
		int count=0;
	    in.useLocale(Locale.US);
		while(in.hasNextLine()) {
			array=in.nextLine().split(",");
			count=array.length;
			temp=new double[array.length];
			for(int i=0;i<array.length;i++)
				temp[i]=Double.parseDouble(array[i]);
			  arr.add(temp);
		} 
		int size=arr.size();
		ar=new  double[size];
		buffer=new double[size];
		int ans=-1;
		boolean fl=true;
	    for(int i=0;i<count;i++) {
	    	for(int j=0;j<size;j++)
	    		ar[j]=arr.get(j)[i];
	    	mergesort(0,size-1);
	    	double diff=ar[1]-ar[0];
	    	for(int j=2;j<size;j++) {
	    		if(!is(ar[j],ar[j-1],diff)||diff==0) {
	    			fl=false;
	    			break;
	    		}
	    	}
	    	if(fl) {
	    		ans=i;
	    	    break;
	    	}
	    	fl=true;
	    }
	    
		out.print(ans);
		out.close();
	} 
}
