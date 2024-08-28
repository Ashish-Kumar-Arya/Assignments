package jobsequencingproblem;

public class Job implements Comparable<Job> {
	char id;
	int deadline;
	int profit;
	
	public Job(char id, int deadline, int profit) {
		this.id=id;
		this.deadline=deadline;
		this.profit=profit;
		
	}
	@Override
	public int compareTo(Job o) {
		return o.profit-this.profit;
	}
	
}
