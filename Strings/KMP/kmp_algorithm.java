// KMP ALGORITHM

import java.util.Arrays;
import java.util.Scanner;
public class KMP_Algorithm {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        String text=sc.next();
        String pattern=sc.next();

        int lps[]=  Arrays.copyOf( buildLPS(pattern), pattern.length());

        int i=0;
        int j=0;

        int count=0;

        System.out.println("lps array ");

        for(int k=0;k<lps.length;k++)
        {
            System.out.print(lps[k]+"  ");
        }

        while(i<text.length())
        {
            if(text.charAt(i)==pattern.charAt(j))
            {
                j++;
                i++;
            }
            else
            {
                if(j!=0)
                {
                    j=lps[j-1];
                }
                else
                {
                    i++;
                }
            }

            if(j==pattern.length())
            {  
                count++;
                System.out.println("yes the pattern has been found at index"+( i-j));
                j=lps[j-1];
            }
        }

        if(count==0)
        {
            System.out.println("pattern not present");
        }
        else if(j==pattern.length())
        {
            System.out.println("total no of pattern present in the text is "+(count));
        }
    }

    static int[] buildLPS(String pattern)
    {
        int lps[]=new int[pattern.length()];
        int right=1;
        int left=0;

        while(right<pattern.length())
        {
            if(pattern.charAt(right)==pattern.charAt(left))
            {
                left++;
                lps[right]=left;
                right++;
            }
            else
            {
                if(left!=0)
                {
                    left=lps[left-1];
                }else
                {
                    right++;
                }
            }
        }
        return lps;
    }
    
}
