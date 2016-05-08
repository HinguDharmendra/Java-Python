import java.util.Random;
import java.util.Scanner;

class BSTN
{
    BSTN left, right;
    int     data;

    public BSTN()
    {
        left = null;
        right = null;
        data = 0;
    }

    public BSTN(int n)
    {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(BSTN n)
    {
        left = n;
    }

    public void setRight(BSTN n)
    {
        right = n;
    }

    public BSTN getLeft()
    {
        return left;
    }

    public BSTN getRight()
    {
        return right;
    }

    public void setData(int d)
    {
        data = d;
    }

    public int getData()
    {
        return data;
    }
}

class BSTr
{
    private BSTN root;

    public BSTr()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void insert(int data)
    {
        root = insert(root, data);
    }

    private BSTN insert(BSTN node, int data)
    {
        if (node == null)
            node = new BSTN(data);
        else
        {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    public void delete(int k)
    {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry " + k + " is not present");
        else
        {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }

    private BSTN delete(BSTN root, int k)
    {
        BSTN p, p2, n;
        if (root.getData() == k)
        {
            BSTN lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            } else if (rt == null)
            {
                p = lt;
                return p;
            } else
            {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData())
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else
        {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

     public boolean search(int val)
    {
        return search(root, val);
    }

    private boolean search(BSTN r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    public void inorder()
    {
        inorder(root);
    }

    private void inorder(BSTN r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    public void preorder()
    {
        preorder(root);
    }

    private void preorder(BSTN r)
    {
        if (r != null)
        {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    public void postorder()
    {
        postorder(root);
    }

    private void postorder(BSTN r)
    {
        if (r != null)
        {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }
    
    public void doubleorder()
    {
        doubleorder(root);
    }
    
    private void doubleorder(BSTN r)
    {
        if(r != null)
        {
            System.out.print(r.getData() + " ");
            doubleorder(r.getLeft());
            System.out.print(r.getData() + " ");
            doubleorder(r.getRight());
        }
    }
}

public class Searching_BST
{
    public static void main(String[] args)
    {
        BSTr bst = new BSTr();
        System.out.println("Binary Search Tree Deletion Test\n");
        
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int elements = 15;
        for (int i = 0; i < elements; i++)
            bst.insert(Math.abs(rand.nextInt(100)));

        System.out.println("Enter integer element to search");
        System.out.println("Search result : " + bst.search(input.nextInt()));

        System.out.print("\nPost order : ");
        bst.postorder();
        System.out.print("\nPre order  : ");
        bst.preorder();
        System.out.print("\nIn order   : ");
        bst.inorder();

        input.close();
    }
}