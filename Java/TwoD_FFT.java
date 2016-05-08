import java.util.Scanner;

public class TwoD_FFT 
{
    static void twoDfft(double[][] inputData, double[][] realOut,
            double[][] imagOut, double[][] amplitudeOut) 
    {
        int height = inputData.length;
        int width = inputData[0].length;

        // Two outer loops iterate on output data.
        for (int yWave = 0; yWave < height; yWave++) 
        {
            for (int xWave = 0; xWave < width; xWave++) 
            {
                // Two inner loops iterate on input data.
                for (int ySpace = 0; ySpace < height; ySpace++) 
                {
                    for (int xSpace = 0; xSpace < width; xSpace++) 
                    {
                        // Compute real, imag, and ampltude.
                        realOut[yWave][xWave] += (inputData[ySpace][xSpace] * Math
                                .cos(2
                                        * Math.PI
                                        * ((1.0 * xWave * xSpace / width) + (1.0
                                                * yWave * ySpace / height))))
                                / Math.sqrt(width * height);
                        imagOut[yWave][xWave] -= (inputData[ySpace][xSpace] * Math
                                .sin(2
                                        * Math.PI
                                        * ((1.0 * xWave * xSpace / width) + (1.0
                                                * yWave * ySpace / height))))
                                / Math.sqrt(width * height);
                        amplitudeOut[yWave][xWave] = Math
                                .sqrt(realOut[yWave][xWave]
                                        * realOut[yWave][xWave]
                                        + imagOut[yWave][xWave]
                                        * imagOut[yWave][xWave]);
                    }
                    System.out.println(realOut[yWave][xWave] + " + "
                            + imagOut[yWave][xWave] + " i");
                }
            }
        }
    }

    public static void main(String args[]) 
    {
        System.out.println("Enter the size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] input = new double[n][n];
        double[][] real = new double[n][n];
        double[][] img = new double[n][n];
        double[][] amplitutude = new double[n][n];
        System.out.println("Enter the 2D elements ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                input[i][j] = sc.nextDouble();

        twoDfft(input, real, img, amplitutude);

        sc.close();
    }
}
