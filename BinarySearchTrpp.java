import java.util.Scanner;
class BinarySearchTree { 
  
  class Node  
  { 
    int key; 
    Node left, right; 
    
    public Node(int item) 
    { 
      key = item; 
      left = right = null; 
    } 
  } 
  
  Node root; 
  
  BinarySearchTreee()  
  {  
    root = null;  
  } 
 
  void insert(int key)  
  {  
    root = insertRec(root, key);  
  } 
  
  Node insertRec(Node root, int key) 
  { 
    
    if (root == null)  
    { 
      root = new Node(key); 
      return root; 
    } 
    
    if (key < root.key) 
      root.left = insertRec(root.left, key); 
    else if (key > root.key) 
      root.right = insertRec(root.right, key); 
    
    return root; 
  } 
  
  void inorder()  
  {  
    inorderRec(root);  
  } 
  

  void inorderRec(Node root) 
  { 
    if (root != null) { 
      inorderRec(root.left); 
      System.out.println(root.key); 
      inorderRec(root.right); 
    } 
  } 
  
  public static void main(String[] args) 
  { 
    BinarySearchTree tree = new BinarySearchTree(); 
    Scanner input = new Scanner(System.in);
    
    int length = input.nextInt();
    
    for(int i = 0; i<length; i++){
      int num = input.nextInt();
      tree.insert(num);
    }
    
    tree.inorder(); 
  } 
} 
