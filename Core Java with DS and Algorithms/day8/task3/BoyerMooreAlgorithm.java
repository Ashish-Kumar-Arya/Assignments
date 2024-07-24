package assignments.day8.task3;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreAlgorithm {
    private static Map<Character, Integer> buildBadCharTable(String pattern) {
        Map<Character, Integer> badCharTable=new HashMap<>();
        int length=pattern.length();
        for(int i=0; i<length; i++) {
            badCharTable.put(pattern.charAt(i),i);
        }
        return badCharTable;
    }

    public static int boyerMooreSearch(String text, String pattern) {
        int n=text.length();
        int m=pattern.length();
        if(m==0||m>n) {
            return -1;
        }

        Map<Character,Integer> badCharTable=buildBadCharTable(pattern);

        int textIndex=0;
        while(textIndex<=n-m) {
            int patternIndex=m-1;

            while(patternIndex>=0&&pattern.charAt(patternIndex)==text.charAt(textIndex+patternIndex)) {
                patternIndex--;
            }

            if(patternIndex<0) {
                int nextIndex=textIndex+m;
                int lastOccurenceIndex=textIndex;
                while(nextIndex<=n-m) {
                    int currentIndex=m-1;
                    while (currentIndex>=0&&pattern.charAt(currentIndex)==text.charAt(nextIndex+currentIndex)) {
                        currentIndex--;
                    }
                    if(currentIndex<0) {
                        lastOccurenceIndex=nextIndex;
                    }
                    nextIndex+=(m-badCharTable.getOrDefault(text.charAt(nextIndex+m-1), -1));
                }
                return lastOccurenceIndex;
            }

            char badChar=text.charAt(textIndex+patternIndex);
            int shift=Math.max(1,patternIndex-badCharTable.getOrDefault(badChar, -1 ));
            textIndex+=shift;
        }
        return -1;
    }
    public static void main(String[] args) {
        String text="ABABABAB";
        String pattern="ABAB";
        int index=boyerMooreSearch(text, pattern);
        System.out.println("Last occurence of pattern found at index: "+index);
    }
}
