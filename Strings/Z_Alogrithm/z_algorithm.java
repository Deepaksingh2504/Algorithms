import java.util.Scanner;

public class Z_algorithm {
    

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        String text=sc.next();
        String pattern=sc.next();

        String merge=pattern+"#"+text;

       int[]z_arr= z_array(merge);

       for(int c :z_arr)
       {
        System.out.print(c+" ");
       }
    }

    static int[] z_array(String merge)
    {

        int pos[]=new int[merge.length()];

        int left=0;
        int right=0;

        for(int i=1;i<merge.length();i++)
        {


            if(i>right)

            {
             left=i;
            right=i;

                while(right<merge.length() && merge.charAt(right)==merge.charAt(right-left))
                {
                    right++;
                }
                pos[i]=right-left;
                right--;
            }
            else
            {
                int k=i-left;

                if(pos[k]<right-i+1)
                {
                    pos[i]=pos[i-left];
                }else
                {
                    left=i;

                     while(right<merge.length() && merge.charAt(right)==merge.charAt(right-left))
                {
                  
                    right++;
                }
                pos[i]=right-left;
                right--;

                }

            }

        }
        return pos;
    }

    // String text="";
    // String pattern="";
    // String merge=text+"#"+pattern;
    // int i=1;
    // int j=0;
    // int count=0;
    // int z_array[]=new int[merge.length()];
   

    // for(int i=1;i<merge.length();i++)
    // {  
    //      int count=0;
    //     int left=0;
    //     int right=i;

    //     while(right<merge.length() && (merge.charAt(right)==merge.charAt(left)))
    //     {
    //         left++;right++:
    //        count++;
    //     }
    //      z[i]=count;
              
    //     }
    // }

}
