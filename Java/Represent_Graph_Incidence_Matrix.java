import java.util.Scanner;

public class Represent_Graph_Incidence_Matrix 
{
    private final int rows;
    private final int cols;
    private int[][] incidence_matrix;

    public Represent_Graph_Incidence_Matrix(int v, int e) 
    {
        rows = v;
        cols = e;
        incidence_matrix = new int[rows + 1][cols + 1];
    }

    public void makeEdge(int to, int from, int edge, int edge_number) 
    {
        try 
        {
            incidence_matrix[to][edge_number] = edge;
            incidence_matrix[from][edge_number] = edge;
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
    }

    public int getEdge(int edge_number, int v) 
    {
        try 
        {
            return incidence_matrix[edge_number][v];
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }

    public static void main(String args[]) 
    {
        int v, e, count = 1, to = 0, from = 0, edge_number;
        Scanner sc = new Scanner(System.in);
        Represent_Graph_Incidence_Matrix graph;
        try 
        {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();

            graph = new Represent_Graph_Incidence_Matrix(v, e);

            System.out.println("Enter the edges: <edge_number> <to> <from>");
            while (count <= e) 
            {
                edge_number = sc.nextInt();
                to = sc.nextInt();
                from = sc.nextInt();

                graph.makeEdge(to, from, 1, edge_number);
                count++;
            }

            System.out.println("The incidence matrix for the given graph is: ");
            System.out.print("  ");
            for (int i = 1; i <= v; i++)
                System.out.print(i + " ");
            System.out.println();

            for (int i = 1; i <= v; i++) 
            {
                System.out.print(i + " ");
                for (int j = 1; j <= v; j++) 
                    System.out.print(graph.getEdge(i, j) + " ");
                System.out.println();
            }

        }
        catch (Exception E) 
        {
            System.out.println("Somthing went wrong");
        }

        sc.close();
    }

}
