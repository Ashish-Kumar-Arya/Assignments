package assignments.day5.task5;

import java.util.ArrayList;

public class MinHeap {
    static int curr=0;
    public static void main(String[] args) {
        ArrayList<Integer> minh=new ArrayList<>();
        minh.add(null);
        insert(minh, 5);
        insert(minh, 1);
        insert(minh, 3);
        insert(minh, 5);
        insert(minh, 12);
        insert(minh, 3);
        insert(minh, 10);
        insert(minh, 6);
        show(minh);
        delete(minh);
        show(minh);
        System.out.println("Minimum element is "+minElement(minh));
    }
    static void insert(ArrayList<Integer> al, int value) {
        curr=curr+1;
        if(al.size()==curr) {
            al.add(value);
        }
        else {
            al.set(curr, value);
        }
        int i=curr;
        while(i>1) {
            int parent=i/2;
            if(al.get(parent)>al.get(i)) {
                swap(al, parent, i);
                i=parent;
            }
            else {
                return;
            }
        }
    }

    static void delete(ArrayList<Integer> al) {
        if(curr==0){
            System.out.println("Heap is empty.");
            return;
        }
        al.set(1, al.get(curr));
        curr=curr-1;
        int i=1;
        while(2*i<=curr) {
            if(2*i==curr) {
                if(al.get(i)>al.get(2*i)) {
                    swap(al, i, 2*i);
                }
            }
            if(2*i>curr) {
                return;
            }
            int left=2*i;
            int right=left+1;
            int small=left;
            if(right<=curr && al.get(right)<al.get(left)) {
                small=right;
            }
            if(al.get(i)>al.get(small)) {
                swap(al,i,small);
                i=small;
            }
            else {
                return;
            }
        }
    }

    static Integer minElement(ArrayList<Integer> al) {
        if(curr==0) {
            return null;
        }
        else {
            return al.get(1);
        }
    }

    static void swap(ArrayList<Integer> al, int parent, int i) {
    int temp = al.get(parent);
    al.set(parent, al.get(i));
    al.set(i, temp);   
    }

    static void show(ArrayList<Integer> al) {
        for(int i=1;i<=curr; i++) {
            System.out.print(al.get(i)+" ");
        }
        System.out.println();
    }
}