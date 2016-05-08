import java.util.Scanner;
import java.util.Stack;

public class Connectivity_DFS
{
    private final int      vertices;
    private int[][]        adjacency_matrix;
    private Stack<Integer> stack;
    
    public Connectivity_DFS(int v)
    {
        vertices = v;
        adjacency_matrix = new int[vertices + 1][vertices + 1];
        stack = new Stack<Integer>();
    }
    
    public void makeEdge(int to, int from, int edge)
    {
        try
        {
            adjacency_matrix[to][from] = edge;
            adjacency_matrix[from][to] = edge;
        } catch (ArrayIndexOutOfBoundsException index)
        {
            System.out.println("The vertices does not exists");
        }
    }
    
    public int getEdge(int to, int from)
    {
        try
        {
            return adjacency_matrix[to][from];
        } catch (ArrayIndexOutOfBoundsException index)
        {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }
    
    public void dfs(int source)
    {
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int[] visited = new int[number_of_nodes + 1];
        int i, element;
        visited[source] = 1;
        stack.push(source);
        while (!stack.isEmpty())
        {
            element = stack.pop();
            i = 1;// element;
            while (i <= number_of_nodes)
            {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
                {
                    stack.push(i);
                    visited[i] = 1;
                }
                i++;
            }
        }
        
        System.out.print("The soruce node " + source + " is connected to: ");
        int count = 0;
        for (int v = 1; v <= number_of_nodes; v++)
            if (visited[v] == 1)
            {
                System.out.print(v + " ");
                count++;
            }
        
        if (count == number_of_nodes)
            System.out.print("\nThe Graph is Connected ");
        else
            System.out.print("\nThe Graph is Disconnected ");
    }
    
    public static void main(String args[])
    {
        int v, e, count = 1, to = 0, from = 0;
        Scanner sc = new Scanner(System.in);
        Connectivity_DFS graph;
        System.out.println("The Undirected Graph Connectivity Test");
        try
        {
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();
            
            graph = new Connectivity_DFS(v);
            
            System.out.println("Enter the edges: <to> <from>");
            while (count <= e)
            {
                to = sc.nextInt();
                from = sc.nextInt();
                
                graph.makeEdge(to, from, 1);
                count++;
            }
            
            System.out.println("The adjacency matrix for the given graph is: ");
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
            
            System.out.println("Enter the Surce Node: ");
            int sourceNode = sc.nextInt();
            graph.dfs(sourceNode);
            
        } catch (Exception E)
        {
            System.out.println("Somthing went wrong");
        }
        
        sc.close();
    }
}