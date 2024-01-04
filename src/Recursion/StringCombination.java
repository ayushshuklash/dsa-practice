package Recursion;
import java.util.*;
import java.lang.*;
import java.io.*;

public class StringCombination {

        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while(t-->0)
            {
                String S = br.readLine().trim();
                StringCombination obj = new StringCombination();
                List<String> ans = obj.find_permutation(S);
                for( int i = 0; i < ans.size(); i++)
                {
                    System.out.print(ans.get(i)+" ");
                }
                System.out.println();

            }
        }

    public List<String> find_permutation(String S) {
        List<String> res = new ArrayList<String>();
        int length = S.length();
        String temp ="";
        findCombination(S,res,"",length);
        Collections.sort(res);
        return res ;
    }


    static void findCombination(String S,List<String> res,String ans,int len){
        if (S.length() == 0) {
            if(!res.contains(ans))
                res.add(ans);
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            String ros = S.substring(0, i) +
                    S.substring(i + 1);
            findCombination(ros,res,ans + ch,len);
        }
    }
}
