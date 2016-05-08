import java.util.Scanner;

public class All_Sequences_Binary_Sequence 
{
    public static void main(String args[])
    {
        System.out.println("Enter the length of the Binary Sequence: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long []sequence = new long[n];
        System.out.println("Enter the binary sequence: <0/1> <0/1> ...");
        for(int i=0; i<n; i++)
            sequence[n-1-i] = sc.nextLong();
        
        System.out.println("The other sequences are: ");
/*        for(int i=0; i<n; i++)
        {
            if(sequence[i] % 10 == 1)
            {
                
            }
                
        }*/
        
        
        
        
        
        boolean flag = true;
        for(int k=0; k<n; k++)
        {
            for(int i=0; i<n; i++)
            {            
                if(sequence[n-1-i] % 10 == 1 && flag == true)
                    {System.out.print(0); flag = false;}
                else
                    {System.out.print(sequence[n-1-i]);}                        
            }
            flag = true;
            System.out.println();
        }
        sc.close();
    }
}
