import java.util.*;
public class question2{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        StringBuilder sb=new StringBuilder();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='a'&&s.charAt(i)!='e'&&s.charAt(i)!='i'&&s.charAt(i)!='o'&&s.charAt(i)!='u'&&s.charAt(i)!='y'){
               
                sb.append(".");
                sb.append(s.charAt(i));
            }
        }
        String p=sb.toString();
        System.out.println(p);
    }
}