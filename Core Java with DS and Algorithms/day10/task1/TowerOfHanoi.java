package assignments.day10.task1;

public class TowerOfHanoi {
    public static void solveTowerOfHanoi(int n, char source, char auxiliary, char destination) {
        if(n==1) {
            System.out.println("Move disk 1 from peg "+source+" to peg "+destination);
            return;
        }
        solveTowerOfHanoi(n-1, source, destination, auxiliary);
        System.out.println("Move disk "+n+" from peg "+source+" to peg "+destination);
        solveTowerOfHanoi(n-1, auxiliary, source , destination);
    }

    public static void main(String[] args) {
        int n=3; //Number of disks
        System.out.println("Tower of Hanoi solution for "+n+" disks:");
        solveTowerOfHanoi(n, 'A', 'B', 'C');

    }
}
