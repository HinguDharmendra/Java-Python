public class Park_Miller_Random_Numbers 
{
    static final long m = 2147483647L;
    static final long a = 48271L;
    static final long q = 44488L;
    static final long r = 3399L;

    static long r_seed = 12345678L; 

    public static double uniform ()
    {
        long hi = r_seed / q;
        long lo = r_seed - q * hi;
        long t = a * lo - r * hi;
        if (t > 0)
            r_seed = t;
        else
            r_seed = t + m;
        return r_seed;
    }

    public static void main (String[] argv)
    {
        double[] A = new double [10];
    
        for (int i=0; i<10; i++) 
            A[i] = uniform();

        for (int i=0; i<10; i++) 
            System.out.print ("  " + A[i]);    
    }
}


