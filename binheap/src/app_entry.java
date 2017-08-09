import java.util.*;
public class app_entry {

	private String name;
	
	private int priority;
	
	private int start_time;
	
	private int duration;
	
	public String getName() {
		return name;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public int getStart() {
		return start_time;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public app_entry(String name,int st,int d,int pr) {
		this.name=name;
		priority=pr;
		start_time=st;
		duration=d;
	}
}
