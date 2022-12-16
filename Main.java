package minheap;

class Node
{
    int data;
    Node left, right;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main{
    private static int size(Node root)
    {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
 
    private static boolean isHeap(Node root, int i, int n)
    {
        
        if (root == null) {
            return true;
        }
 
        
        if (i >= n) {
            return false;
        }
 
        
        if ((root.left != null && root.left.data <= root.data) ||
                    (root.right != null && root.right.data <= root.data)) {
            return false;
        }
 
        
        return isHeap(root.left, 2*i + 1, n) &&
            isHeap(root.right, 2*i + 2, n);
    }
 
    
    public static boolean isHeap(Node root)
    {
        int i = 0;
        return isHeap(root, i, size(root));
    }
 
    public static void main(String[] args)
    {
        
 
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.right.left = new Node(8);
        root.right.right = new Node(10);
 
        if (isHeap(root)) {
            System.out.print("verilen dizi min-heap' tir.");
        }
        else {
            System.out.print("verilen dizi min-heap değildir.");
        }
    }
}
   