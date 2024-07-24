package assignments.day11.task1;

import java.util.ArrayList;
import java.util.List;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Job{id="+id+", deadline="+deadline+", profit="+profit+"}";
    }
    
}

public class JobSequencing {
    public static List<Job> jobSequencing(List<Job> jobs) {
        //Sort jobs by profit in descending order
        jobs.sort((a,b)->b.profit-a.profit);
        int n=jobs.size();
        boolean[] slot=new boolean[n]; //To keep track of free time slots
        List<Job> result=new ArrayList<>(); //To store the result sequence of jobs

        for(Job job:jobs) {
            //Find a free slot for this job (starting from the last possible slot)
            for(int j=Math.min(n, job.deadline)-1;j>=0;j--) {
                if(!slot[j]) {
                    //Assign to this slot
                    slot[j]=true;
                    result.add(job);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Job> jobs=new ArrayList<>();
        jobs.add(new Job(1, 4, 20));
        jobs.add(new Job(2, 1, 10));
        jobs.add(new Job(3, 1, 40));
        jobs.add(new Job(4, 1, 30));

        List<Job> result=jobSequencing(jobs);

        System.out.println("Jobs selected for maximum profit:");
        for(Job job:result) {
            System.out.println(job);
        }
    }
}
