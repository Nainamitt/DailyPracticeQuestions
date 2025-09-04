import java.util.*;

public class question3 {
    public static int shortestSubstring(String s) {
        
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> uniqueChars = new HashMap<>();

       
       
       for(int i=0;i<ch.length;i++){
        uniqueChars.put(ch[i],uniqueChars.getOrDefault(ch[i],0)+1);
       }

        
        return find(ch,uniqueChars);
    }

    private static int find(char[] ch, HashMap<Character,Integer> set) {
        HashMap<Character,Integer> seen = new HashMap<>();
        int j=0;
        int max=Integer.MAX_VALUE;
        for (int i = 0; i < ch.length; i++) {
            seen.put(ch[i],seen.getOrDefault(ch[i],0)+1);
            while(seen.size()==set.size()){
max=Math.min(max,i-j+1);
if(seen.get(ch[j])==1)seen.remove(ch[j]);
else seen.put(ch[j],seen.get(ch[j])-1);
j++;
            }
        }
        return max;
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String s = sc.next(); // Read input string
        System.out.println(shortestSubstring(s)); // Output the result
        sc.close();
    }
}