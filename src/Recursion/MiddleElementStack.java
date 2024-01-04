package Recursion;

import java.util.Scanner;
import java.util.Stack;

public class MiddleElementStack {

        public static void main (String[] args) {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();

            while(t-->0)
            {
                int sizeOfStack =sc.nextInt();
                Stack<Integer> myStack=new Stack<>();

                //adding elements to the stack
                for(int i=0;i<sizeOfStack;i++)
                {
                    int x=sc.nextInt();
                    myStack.push(x);

                }
                MiddleElementStack obj=new MiddleElementStack();
                obj.deleteMid(myStack,sizeOfStack);

                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
            }


        }

    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        if(Math.ceil(sizeOfStack/2) == sizeOfStack){

        }
    }
}
