package assignments.day8.task1;

public class KMP {
    //Function to compute the LPS (Longest Prefix Suffix) arrray
    private static int[] computeLPSArray(String pattern) {
        int m=pattern.length();
        int lps[]=new int[m];
        int length=0; //length of the previous longest prefic suffix
        int i=1;
        lps[0]=0;
        while(i<m) {
            if(pattern.charAt(i)==pattern.charAt(length)) {
                length++;
                lps[i]=length;
                i++;
            }
            else {
                if(length!=0) {
                    length=lps[length-1];
                }
                else {
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }

    //Function to perform KMP pattern searching
    public static void KMPSearch(String text, String pattern) {
        int n=text.length();
        int m=pattern.length();

        int[] lps=computeLPSArray(pattern);
        int i=0;
        int j=0;

        while (i<n) {
            if(pattern.charAt(j)==text.charAt(i)) {
                i++;
                j++;
            }

            if(j==m) {
                System.out.println("Pattern found at index "+(i-j));
                j=lps[j-1];
            }
            else if(i<n&&pattern.charAt(j)!=text.charAt(i)) {
                if(j!=0) {
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text="ABAABBABCCAABB";
        String pattern="AABB";
        KMPSearch(text,pattern);
    }
}
