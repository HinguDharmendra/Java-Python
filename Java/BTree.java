import java.util.Scanner;

class BinaryNode
{
    private int        Key;
    private Object     Data;
    private BinaryNode Left;
    private BinaryNode Right;

    public BinaryNode(int k, Object d)
    {
        Key = k;
        Data = d;
        Left = null;
        Right = null;
    }

    // Get Operations
    public int gKey()
    {
        return Key;
    }

    public Object gData()
    {
        return Data;
    }

    public BinaryNode gLeft()
    {
        return Left;
    }

    public BinaryNode gRight()
    {
        return Right;
    }

    // Set Operations
    public void sKey(int AValue)
    {
        Key = AValue;
    }

    public void sData(Object AValue)
    {
        Data = AValue;
    }

    public void sLeft(BinaryNode AValue)
    {
        Left = AValue;
    }

    public void sRight(BinaryNode AValue)
    {
        Right = AValue;
    }
}

public class BTree
{
    private BinaryNode Root;
    private int        NoOfNodes;

    private BTree()
    { // constructor
        Root = null;
        NoOfNodes = 0;
    }

    public boolean IsEmpty()
    {
        return (NoOfNodes == 0);
    }

    public BinaryNode gRoot()
    {
        return Root;
    }

    public int Count()
    {
        return NoOfNodes;
    }

    public int Size(BinaryNode ATree)
    {
        if (ATree == null)
            return 0;
        else
            return (1 + Size(ATree.gLeft()) + Size(ATree.gRight()));
    }

    public int Height(BinaryNode ATree)
    {
        if (ATree == null)
            return 0;
        else
            return (1 + Math.max(Height(ATree.gLeft()), Height(ATree.gRight())));
    }

    public void PreOrder(BinaryNode ATree)
    {
        if (ATree != null)
        {
            System.out.print(ATree.gKey() + " ");
            PreOrder(ATree.gLeft());
            PreOrder(ATree.gRight());
        }
    }

    public void InOrder(BinaryNode ATree)
    {
        if (ATree != null)
        {
            InOrder(ATree.gLeft());
            System.out.print(ATree.gKey() + " ");
            InOrder(ATree.gRight());
        }
    }

    public void PostOrder(BinaryNode ATree)
    {
        if (ATree != null)
        {
            PostOrder(ATree.gLeft());
            PostOrder(ATree.gRight());
            System.out.print(ATree.gKey() + " ");
        }
    }

    public void Insert(int AId, Object AValue)
    {
        BinaryNode Temp, Current, Parent;
        if (Root == null)
        {
            Temp = new BinaryNode(AId, AValue);
            Root = Temp;
            NoOfNodes++;
        } else

        {
            Temp = new BinaryNode(AId, AValue);
            Current = Root;
            while (true)
            {
                Parent = Current;
                if (AId < Current.gKey())
                {
                    Current = Current.gLeft();
                    if (Current == null)
                    {
                        Parent.sLeft(Temp);
                        NoOfNodes++;
                        return;
                    }
                } else
                {
                    Current = Current.gRight();
                    if (Current == null)
                    {
                        Parent.sRight(Temp);
                        NoOfNodes++;
                        return;
                    }
                }
            }
        }
    }

    public BinaryNode Find(int AKey)
    {
        BinaryNode Current = null;
        if (!IsEmpty())
        {
            Current = Root; // start search at top of tree
            while (Current.gKey() != AKey)
            {
                if (AKey < Current.gKey())
                    Current = Current.gLeft();
                else
                    Current = Current.gRight();
                if (Current == null)
                    return null;
            }
        }
        return Current;
    }

    public BinaryNode GetSuccessor(BinaryNode ANode)
    {
        BinaryNode Current, Successor, SuccessorParent;
        Successor = ANode;
        SuccessorParent = ANode;
        Current = ANode.gRight();
        while (Current != null)
        {
            SuccessorParent = Successor;
            Successor = Current;
            Current = Current.gLeft();
        }
        if (Successor != ANode.gRight())
        {
            SuccessorParent.sLeft(Successor.gRight());
            Successor.sRight(ANode.gRight());
        }
        return Successor;
    }

    public boolean Delete(int AKey)
    {
        BinaryNode Current, Parent;
        boolean IsLeftChild = true;
        Current = Root;
        Parent = Root;
        while (Current.gKey() != AKey)
        {
            Parent = Current;
            if (AKey < Current.gKey())
            {
                IsLeftChild = true;
                Current = Current.gLeft();
            } else
            {
                IsLeftChild = false;
                Current = Current.gRight();
            }
            if (Current == null)
                return false;
        }

        if (Current.gLeft() == null && Current.gRight() == null)
        {
            if (Current == Root)
                Root = Current.gLeft();
            else if (IsLeftChild)
                Parent.sLeft(Current.gRight());
            else
                Parent.sRight(Current.gRight());
        }

        else
        {
            if (Current.gRight() == null)
            {
                if (Current == Root)
                    Root = Current.gRight();
                else if (IsLeftChild)
                    Parent.sLeft(Current.gLeft());
                else
                    Parent.sRight(Current.gLeft());
            }

            else
            {
                if (Current.gLeft() == null)
                {
                    if (Current == Root)
                        Root = Current.gLeft();
                    else if (IsLeftChild)
                        Parent.sLeft(Current.gRight());
                    else
                        Parent.sRight(Current.gRight());
                }

                else
                {
                    BinaryNode Successor = GetSuccessor(Current);
                    if (Current == Root)
                        Root = Successor;
                    else if (IsLeftChild)
                        Parent.sLeft(Successor);
                    else
                        Parent.sRight(Successor);
                    Successor.sLeft(Current.gLeft());
                }
            }
        }
        NoOfNodes--;
        return true;
    }

    public static void main(String[] Args)
    {
        BTree MyTree = new BTree();

        System.out.println("Enter the elements in the tree");
        int N = 5;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; i++)
            MyTree.Insert(sc.nextInt(), i);

        System.out.print("\nInorder  : ");
        MyTree.InOrder(MyTree.gRoot());
        System.out.print("\nPreorder  : ");
        MyTree.PreOrder(MyTree.gRoot());
        System.out.print("\nPostorder  : ");
        MyTree.PostOrder(MyTree.gRoot());

        System.out.println("\nEnter the element to be deleted: ");
        int delete = sc.nextInt();

        MyTree.Delete(delete);

        System.out.print("\nInorder  : ");
        MyTree.InOrder(MyTree.gRoot());
        System.out.print("\nPreorder  : ");
        MyTree.PreOrder(MyTree.gRoot());
        System.out.print("\nPostorder  : ");
        MyTree.PostOrder(MyTree.gRoot());

        sc.close();

        /*
         * MyTree.Insert(12, "Hen"); MyTree.Insert(4, "Dog"); MyTree.Insert(11,
         * "Cat"); MyTree.Insert(1, "Frog"); MyTree.Insert(100, "Owner");
         * MyTree.Delete(1); MyTree.InOrder(MyTree.gRoot()); NodeAt =
         * MyTree.Find(11);
         * 
         * if (NodeAt != null) System.out.println("Data in Node with Key 11 = "
         * + NodeAt.gData());
         */
    }
}