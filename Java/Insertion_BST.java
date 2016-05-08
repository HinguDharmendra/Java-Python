import java.util.Scanner;

class BSTNode
{
    BSTNode left, right;
    int     data;

    public BSTNode()
    {
        left = null;
        right = null;
        data = 0;
    }

    public BSTNode(int n)
    {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(BSTNode n)
    {
        left = n;
    }

    public void setRight(BSTNode n)
    {
        right = n;
    }

    public BSTNode getLeft()
    {
        return left;
    }

    public BSTNode getRight()
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

class BSTree
{
    private BSTNode root;

    public BSTree()
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

    private BSTNode insert(BSTNode node, int data)
    {
        if (node == null)
            node = new BSTNode(data);
        else
        {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    public void inorder()
    {
        inorder(root);
    }

    private void inorder(BSTNode r)
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

    private void preorder(BSTNode r)
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

    private void postorder(BSTNode r)
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

    private void doubleorder(BSTNode r)
    {
        if (r != null)
        {
            System.out.print(r.getData() + " ");
            doubleorder(r.getLeft());
            System.out.print(r.getData() + " ");
            doubleorder(r.getRight());
        }
    }
}

public class Insertion_BST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        BSTree bst = new BSTree();
        System.out.println("Binary Search Tree Insertion Test\n");
        int N = 10;
        for (int i = 0; i < N; i++)
        {
            bst.insert(scan.nextInt());
            System.out.print("\nPost order : ");
            bst.postorder();
            System.out.print("\nPre order  : ");
            bst.preorder();
            System.out.print("\nIn order   : ");
            bst.inorder();
        }
        scan.close();
    }
}