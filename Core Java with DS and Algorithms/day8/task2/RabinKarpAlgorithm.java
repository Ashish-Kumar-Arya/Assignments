package assignments.day8.task2;

public class RabinKarpAlgorithm {
    // Prime number for modulus to reduce hash colisions
    private static final int PRIME=101;
    private static final int BASE=256; //Number of characters in the ASCII character set

    private static long computeHash(String str, int length) {
        long hash=0;
        for(int i=0; i<length; i++) {
            hash=(hash*BASE+str.charAt(i))%PRIME;
        }
        return hash;
    }

    //Rolling hash functiom computes hash value of a substring efficiently
    private static long rollHash(long oldHash, char oldChar, char newChar, long basePow, int prime) {
        long newHash=(oldHash-oldChar*basePow)*BASE+newChar;
        newHash=newHash%prime;
        if(newHash<0) {
            newHash+=prime;
        }
        return newHash;
    }

    public static void rabinKarpSearch(String text, String pattern) {
        int n=text.length();
        int m=pattern.length();
        if(m>n) {
            return;
        }

        long patternHash=computeHash(pattern, m);
        long textHash=computeHash(text, m);
        long basePow=1;

        for(int i=0; i<m-1;i++) {
            basePow=(basePow*BASE)%PRIME;
        }

        for(int i=0; i<=n-m; i++) {
            if(patternHash==textHash) {
                if(text.substring(i, i+m).equals(pattern)) {
                    System.out.println("Pattern found at index "+i);
                }
            }
            if(i<n-m) {
                textHash=rollHash(textHash, text.charAt(i), text.charAt(i+m), basePow, PRIME);
            }
        }
    }

    public static void main(String[] args) {
        String text="ABAABBABCCAABB";
        String pattern="AABB";
        rabinKarpSearch(text,pattern);
    }
}