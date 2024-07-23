package assignments.day15.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException{
        FileReader fr=new FileReader("/home/ashish/Desktop/a.txt");
        BufferedReader br=new BufferedReader(fr);
        String line;
        Map<String, Integer> map=new HashMap<>();
        while ((line=br.readLine())!=null) {
            String[] words=line.split("\\s+");
            for(String word:words) {
                word=word.toLowerCase();
                if(map.containsKey(word)) {
                    map.put(word, map.get(word)+1);
                }
            else {
                map.put(word, 1);
            }
            }
        }
        br.close();
        FileWriter fw=new FileWriter("/home/ashish/Desktop/b.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            bw.write(entry.getKey()+":"+entry.getValue());
            bw.newLine();
        }
        bw.close();
        System.out.println("Word counts have been written to b.txt");
    }
}
