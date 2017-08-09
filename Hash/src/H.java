import java.util.*;
import java.io.*;


public class H {
 
	public static void main(String[] args) throws Exception {
		Scanner in=new Scanner(new FileReader("input.txt"));
		PrintWriter out=new PrintWriter(new FileWriter("output.txt"));
		String buf;
		ArrayList<String> words=new ArrayList<String>();
		while(in.hasNext()) {
			buf=in.next();
			buf=buf.replaceAll("\\.","");
			buf=buf.replaceFirst("\\?", "");
			buf=buf.replaceAll("\\!","");
			buf=buf.replaceFirst("\\,", "");
			words.add(buf.toLowerCase());
		}
		String[] stop={"a", "the", "in", "at", "to", "on", "not", "for", "'s", "'d", "'re", "is", "are", "am", "has", "i","we","you"};
		ArrayList<String> stoplist=new ArrayList<String>();
		for(int i=0;i<stop.length;i++)
			stoplist.add(stop[i]);
		MyMap map=new MyMap(words.size());
		for(int i=0;i<words.size();i++) {
			String temp=words.get(i);
			map.put(temp, map.get(temp)+1);
		}
		int max=-1;
		String key="";
		for(int i=0;i<words.size();i++) {
			 if(map.get(words.get(i))>=max) {
				 max=map.get(words.get(i));
				 key=words.get(i);
			 }
		}
		out.println(key+" "+max); // key and its value before deletion 
		key="";
		max=0;
	   for(int i=0;i<stoplist.size();i++)
			map.remove(stoplist.get(i));
	    for(int i=0;i<words.size();i++) {
			 if(map.get(words.get(i))>=max) {
				 max=map.get(words.get(i));
				 key=words.get(i);
			 }
		}
		out.println(key+" "+max);  //key + its value after deletion
		
	    out.close();
		
}
}
