import java.util.Random;
import java.util.Scanner;

class SelfOrganizingList 
{
    private int[] list;
    private int[] count;
    private int size;

    public SelfOrganizingList(int listSize) 
    {
        list = new int[listSize];
        count = new int[listSize];
        size = 0;
    }

    public boolean isEmpty() 
    {
        return size == 0;
    }

    public boolean isFull() 
    {
        return size == list.length;
    }

    public void makeEmpty() 
    {
        int l = list.length;
        list = new int[l];
        count = new int[l];
        size = 0;
    }

    public int getSize() 
    {
        return size;
    }

    public void insert(int val) 
    {
        if (isFull()) 
        {
            System.out.println("Error : List full!");
            return;
        }
        list[size] = val;
        count[size] = 0;
        size++;
    }

    public void remove(int pos) 
    {
        pos--;
        if (pos < 0 || pos >= size) 
        {
            System.out.println("Invalid position ");
            return;
        }
        for (int i = pos; i < size - 1; i++) 
        {
            list[i] = list[i + 1];
            count[i] = count[i + 1];
        }
        size--;
    }

    public boolean search(int x) 
    {
        boolean searchResult = false;
        int pos = -1;
        for (int i = 0; i < size; i++) 
        {
            if (list[i] == x) {
                searchResult = true;
                pos = i;
                break;
            }
        }
        if (searchResult) 
        {
            count[pos]++;
            int c = count[pos];
            for (int i = 0; i < pos; i++) 
            {
                if (count[pos] > count[i]) 
                {
                    for (int j = pos; j > i; j--) 
                    {
                        list[j] = list[j - 1];
                        count[j] = count[j - 1];
                    }
                    list[i] = x;
                    count[i] = c;
                    break;
                }
            }
        }
        return searchResult;
    }

    public void printList() 
    {
        System.out.print("\nList = ");
        for (int i = 0; i < size; i++)
            System.out.print(list[i] + " ");
        System.out.print("\nCount = ");
        for (int i = 0; i < size; i++)
            System.out.print(count[i] + " ");
    }
}

public class Search_Self_Organizing 
{
    public static void main(String[] args) 
    {
        Random random = new Random();
        int N = 20;

        SelfOrganizingList list = new SelfOrganizingList(N);
        for (int i = 0; i < N; i++)
            list.insert(Math.abs(random.nextInt(1000)));

        Scanner scan = new Scanner(System.in);
        System.out.println("SelfOrganizingList Searching \n");

        list.printList();

        System.out.println("\nEnter integer element to search");
        System.out.println("Search Result : " + list.search(scan.nextInt()));

        scan.close();
    }
}