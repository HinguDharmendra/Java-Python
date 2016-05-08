import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Unique_Prime_Factors 
{
	static Set primeFactors(long number) 
	{
		long copy = number, i;
		Set primeFactor = new HashSet<>();
		for (i = 2; i <= copy; i++) 
		{
			if (copy % i == 0) 
			{
				primeFactor.add(i);
				copy /= i;
				i--;
			}
		}
		return primeFactor;
	}

	public static void main(String args[]) 
	{
		Scanner input = new Scanner(System.in);
		long n;
		System.out.println("Enter the number: ");
		n = input.nextLong();
		System.out.println("The Prime Factors of " + n + " is: "
				+ primeFactors(n));
	}
}
