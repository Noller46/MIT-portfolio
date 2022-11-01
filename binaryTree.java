//IMPORTENT
//although this code is heavely edited it was originaly not mine
//this code was originaly made by someone named Ankur Narain Verma, althoug I am not sure where i found it
//This is the class i am using to store all of the Links and Nues from the main brain class
//It is just a generic and iterable capable binary tree implemintation
import java.util.*;

public class binaryTree<T> implements Iterable<T>
{
 
    
    class Node {
        T key;
        Node left, right;
 
        public Node(T item)
        {
            key = item;
            left = right = null;
        }
    }
 
    private Node root;
 
    public binaryTree()
    {
      root = null;
    }
 
    public binaryTree(T value)
    {
      root = new Node(value);
    }
 
    public void insert(T key)
    {
      root = insertRec(root, key);
    }
 
    private Node insertRec(Node root, T key)
    {
 
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        if (compare(key, root.key))
            root.left = insertRec(root.left, key);
        else if (compare(root.key, key))
            root.right = insertRec(root.right, key);
 
        return root;
    }
    
    public boolean contains(T key)
    {
      for(T obj: this)
      {
         if(obj.equals(key))
         {
            return true;
         }
      }
      return false;
    }
    
    public void delete(T key)
    {
      if(contains(key))
      {
         root = deleteRec(root, key);
      }
    }
  
  
    
    private Node deleteRec(Node root, T key)
    {
        if (root == null)
            return root;
  
        if (compare(key,root.key))
            root.left = deleteRec(root.left, key);
        else if (compare(root.key,key))
            root.right = deleteRec(root.right, key);
  
        
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
  
            
            root.key = minValue(root.right);
  
            root.right = deleteRec(root.right, root.key);
        }
  
        return root;
    }
    
    private T minValue(Node root)
    {
        T minv = root.key;
        while (root.left != null) 
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    
    public boolean compare(T obj1, T obj2)
    {
 
        obj1.toString();
        String StrObj1 = obj1.toString();
        String StrObj2 = obj2.toString();
 
        int difference = StrObj1.compareTo(StrObj2);
        
        
        if (difference == 0) {
 
            return false;
        }
        else if (difference < 0) {
 
            return false;
        }
        else {
 
            return true;
        }
    }
    
    public void inorder()
    {
      for(T obj: this)
      {
         System.out.println(obj);
      }
    }
     
    public Iterator<T> iterator()
    {
      return new Stackerator();
    }

    
    public class Stackerator implements Iterator<T>
    {

      private Queue<T> list = new LinkedList<>();
      Node hold = fill(root);
      private Node fill(Node n)
      {
         if (n != null)
         {
            fill(n.left);
            list.add(n.key);
            fill(n.right);
         }
         return n;
      }      
      
      @Override
      public boolean hasNext()
      {
         return list.size() > 0;
      }
      public T next()
      {
         return list.remove();
      }
   }

 
    
}
