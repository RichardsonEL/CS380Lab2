package Tree;

class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   inserts a node into the tree
   */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
         
         while(true){
            parent = current;
            
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
           
         }//closing while
      
      }//closing main if-else 
   }
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /*
   pre-order traversal
   */
   
   /**
    * Prints a preorder traversal of the binary search tree.
    * @param root The root of the binary search tree.
    */
   public void preOrderTraversal(Node root){
	   if (root == null) {
		   return;
	   }
	   System.out.print(root.value + " ");
	   preOrderTraversal(root.left);
	   preOrderTraversal(root.right);
   }

   
   
   /*
   in-order traversal
   */
   
   /**
    * Prints an inorder traversal of the binary search tree.
    * @param root The root of the binary search tree.
    */
   public void inOrderTraversal(Node root){
	   if (root == null) {
		   return;
	   }
	   inOrderTraversal(root.left);
	   System.out.print(root.value + " ");
	   inOrderTraversal(root.right);
   }
   
   
   
   /*
   post-order traversal
   */
   
   /**
    * Prints a postorder traversal of the binary search tree.
    * @param root The root of the binary search tree.
    */
   public void postOrderTraversal(Node root){
	   if (root == null) {
		   return;
	   }
	   postOrderTraversal(root.left);
	   postOrderTraversal(root.right);
	   System.out.print(root.value + " ");
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   
   /**
    * Searches the binary search tree for an certain key, then returns whether the value is in the tree.
    * @param root The root of the binary search tree.
    * @param key The value to search for.
    * @return Boolean value representing if the key value is in the tree.
    */
   public boolean find(Node root, int key){
	  if(root == null) {
		  return false;
	  } else if(key < root.value) {
		  return find(root.left, key);
	  } else if(key > root.value) {
		  return find(root.right, key);
	  } else {
		  return true;
	  }         
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   
   /**
    * Returns the minimum key value in the binary search tree.
    * @param root The root of the binary search tree.
    * @return The minimum key value in the binary search tree.
    */
   public int getMin(Node root){
      if(root.left == null) {
    	  return root.value;
      } else {
    	  return getMin(root.left);
      }
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   
   /**
    * Returns the maximum key value in the binary search tree.
    * @param root The root of the binary search tree.
    * @return The maximum key value in the binary search tree.
    */
   public int getMax(Node root){
	   if(root.right == null) {
	    	  return root.value;
	      } else {
	    	  return getMax(root.right);
	      }
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}