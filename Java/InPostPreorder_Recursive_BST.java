import java.util.Scanner;

class BinarySearchTreeNodes
{
    BinarySearchTreeNodes left, right;
    int                   data;

    public BinarySearchTreeNodes()
    {
        left = null;
        right = null;
        data = 0;
    }

    public BinarySearchTreeNodes(int n)
    {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(BinarySearchTreeNodes n)
    {
        left = n;
    }

    public void setRight(BinarySearchTreeNodes n)
    {
        right = n;
    }

    public BinarySearchTreeNodes getLeft()
    {
        return left;
    }

    public BinarySearchTreeNodes getRight()
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

class BinarySearchTree
{
    private BinarySearchTreeNodes root;

    public BinarySearchTree()
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

    private BinarySearchTreeNodes insert(BinarySearchTreeNodes node, int data)
    {
        if (node == null)
            node = new BinarySearchTreeNodes(data);
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

    private void inorder(BinarySearchTreeNodes r)
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

    private void preorder(BinarySearchTreeNodes r)
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

    private void postorder(BinarySearchTreeNodes r)
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

    private void doubleorder(BinarySearchTreeNodes r)
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

public class InPostPreorder_Recursive_BST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("Enter the first 10 elements of the tree\n");
        int N = 10;
        for (int i = 0; i < N; i++)
            bst.insert(scan.nextInt());

        System.out.print("\nPost order : ");
        bst.postorder();
        System.out.print("\nPre order  : ");
        bst.preorder();
        System.out.print("\nIn order   : ");
        bst.inorder();

        scan.close();
    }
}
