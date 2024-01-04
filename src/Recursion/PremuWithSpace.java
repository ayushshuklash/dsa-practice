package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PremuWithSpace {
    static ArrayList<String> permutation(String S){
            ArrayList<String> strs = new
                    ArrayList<String>();

            // Check if str.length() is 1
            if (S.length() == 1)
            {
                strs.add(S);
                return strs;
            }

            ArrayList<String> strsTemp
                    = permutation(S.substring(1,
                    S.length()));

            // Iterate over strsTemp
            for (int i = 0; i < strsTemp.size(); i++)
            {

                strs.add(S.charAt(0) +
                        strsTemp.get(i));
                strs.add(S.charAt(0) + " " +
                        strsTemp.get(i));
            }
            return strs;
        }
    public static void main (String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S = read.readLine().trim();
            ArrayList<String> ans = new ArrayList<String>();
            ans = permutation(S);
            for(int i =0;i< ans.size();i++){
                System.out.println("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}
