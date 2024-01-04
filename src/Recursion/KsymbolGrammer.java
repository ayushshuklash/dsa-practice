package Recursion;

import java.io.IOException;
import java.util.Scanner;

public class KsymbolGrammer {

    public String convertToBinary(int n, String number) {
        if(n==1){
            return number;
        }
        int len = number.length();
        int next =0;
        String a = "";
        while(next< len){
            if(number.charAt(next) == '0'){
               a =  a.concat("01");
            }else{
               a = a.concat("10");
            }
            next++;
        }
        return convertToBinary(n-1,a);

    }
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k = sc.nextInt();
        KsymbolGrammer kG = new KsymbolGrammer();
        int a = kG.kthGrammer(n,k);
        System.out.println(a);

    }

    private int kthGrammer(int n, int k) {
        String a = convertToBinary(n,"0");
        int ans= Integer.parseInt(String.valueOf(a.charAt(k-1)));
        return ans;
    }
}
