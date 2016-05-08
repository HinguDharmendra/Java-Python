import java.util.Scanner;
import java.util.Stack;

class BinarySearchTreeNode
{
    BinarySearchTreeNode left, right;
    int                  data;

    public BinarySearchTreeNode()
    {
        left = null;
        right = null;
        data = 0;
    }

    public BinarySearchTreeNode(int n)
    {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(BinarySearchTreeNode n)
    {
        left = n;
    }

    public void setRight(BinarySearchTreeNode n)
    {
        right = n;
    }

    public BinarySearchTreeNode getLeft()
    {
        return left;
    }

    public BinarySearchTreeNode getRight()
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

class BinarySearchTreeOperations
{
    private BinarySearchTreeNodes root;

    public BinarySearchTreeOperations()
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
        if (r == null)
            return;

        Stack<BinarySearchTreeNodes> stack = new Stack<BinarySearchTreeNodes>();

        while (!stack.isEmpty() || r != null)
        {
            if (r != null)
            {
                stack.push(r);
                r = r.left;
            } else
            {
                r = stack.pop();
                System.out.print(r.data + " ");
                r = r.right;
            }
        }
    }

    public void preorder()
    {
        preorder(root);
    }

    private void preorder(BinarySearchTreeNodes r)
    {
        Stack<BinarySearchTreeNodes> s = new Stack<BinarySearchTreeNodes>();
        s.push(r);
        while (!s.empty())
        {
            r = s.pop();
            System.out.print(r.data + " ");
            if (r.right != null)
                s.push(r.right);
            if (r.left != null)
                s.push(r.left);
        }
    }

    public void postorder()
    {
        postorder(root);
    }

    private void postorder(BinarySearchTreeNodes r)
    {
        if (root == null)
            return;

        final Stack<BinarySearchTreeNodes> stack = new Stack<BinarySearchTreeNodes>();
        BinarySearchTreeNodes node = root;

        while (!stack.isEmpty() || node != null)
        {
            while (node != null)
            {
                if (node.right != null)
                    stack.add(node.right);
                stack.add(node);
                node = node.left;
            }

            node = stack.pop();

            if (node.right != null && !stack.isEmpty()
                    && node.right == stack.peek())
            {
                BinarySearchTreeNodes nodeRight = stack.pop();
                stack.push(node);
                node = nodeRight;
            } else
            {
                System.out.print(node.data + " ");
                node = null;
            }
        }
    }
}

public class InPostPreorder_NonRecursive_BST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        BinarySearchTreeOperations bst = new BinarySearchTreeOperations();
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