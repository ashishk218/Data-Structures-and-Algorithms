class Node
{
    int data;
    int balanceFactor;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
        
    }
    Node()
    {
    	
    }
    int computeBalance()
    {
    	if(isLeaf())
    		return 0;
    	else if(hasOnlyLeft())
    		return left.height()+1;
    	else if(hasOnlyRight())
    		return -1*(right.height()+1);
    	else
    	
    		return (left.height()-right.height());
    	
    	
    }
    int height()
    {
    	if(isLeaf())
    		return 0;
    	else if(hasOnlyLeft())
    		return left.height()+1;
    	else if(hasOnlyRight())
    		return right.height()+1;
    	else
    		return Math.max(left.height(),right.height())+1;
    }
    Node insert(int key)
    {
        if(key>data)
        {
            if(right==null)
            {
                right=new Node(key);
            }
            else
           right=right.insert(key);
            //return this;
            
        }
        else
        {
            if(left==null)
            {
                left= new Node(key);
            }
            else
            left=left.insert(key);
          //  return this;
           //change return this,remove it 
            
        }
        balanceFactor=computeBalance();
        System.out.println(balanceFactor);
        switch(balanceFactor)
        {
        case 2:
        if(left.computeBalance()>=0)
        	return rotateWithLeft();
        else
        	left=left.rotateWithRight();
             return rotateWithLeft();
        case -2:
          if(right.computeBalance()<=0)
            	return rotateWithRight();
            else
              right=right.rotateWithRight();
               return rotateWithRight();
        }
        
      return this;
        
		
        
    }
    Node rotateWithLeft()
    {
    	Node lc=left;
    	left=lc.right;
    	lc.right=this;
    	return lc;
    	
    }
    Node rotateWithRight()
    {
    	Node rc=right;
    	right=rc.left;
    	rc.left=this;
    	return rc;
    }
    void preorder()
    {
    	System.out.print(data+" ");
        if(left!=null)
        left.preorder();
        if(right!=null)
        right.preorder();
        
        
    }
    void inorder()
    {
        if(left!=null)
        left.inorder();
        System.out.print(data+" ");
        if(right!=null)
        right.inorder();
    }
    void deleteRoot(Node root)
    {
    	//System.out.println("IM HERE");
    	
    	if(root.isLeaf())
    	{
    		root=null;
    	}
    	else if(root.hasOnlyLeft())
    	{
    		root=root.left;
    	}
    	else if(root.hasOnlyRight())
    	{
    		root=root.right;
    	}
    	else
    	{
    		//System.out.println("IM HERE");
    		if((left).isLeaf()||left.hasOnlyLeft())
    		{
    			//System.out.println("IM HERE");
    			root.data=root.left.data;
    			root.left=root.left.left;
    			
    		}
    		else
    		{
    			//System.out.println("IM HERE in else");
    			Node PP=root.left;
                Node P=PP.right;
                while(P.right!=null)
                {
                    PP=P;
                    P=P.right;
                }
                root.data=P.data;
                PP.right=null;
        
    		}
    		
    	}
    	
    }
    void delete(int key)
    {
    	if(data==key)
    	{
    		Node dummy = new Node();
    		dummy.left=this;
    		dummy.delete(key);
    	}
        if(left!=null&&left.data==key)
        {
            if(left.isLeaf())
            {
                //System.out.println(left.data);
                left=null;
            }
            else if(left.hasOnlyLeft())
            {
                left=left.left;
                
            }
            else if(left.hasOnlyRight())
            {
                left=left.right;
            }
            else
            {
              if(left.left.hasOnlyLeft()||left.left.isLeaf())
              {
                  left.data=left.left.data;
                  left.left=left.left.left;
              }
              else
              {
                  Node PP=left.left;
                  Node P=PP.right;
                  while(P.right!=null)
                  {
                      PP=P;
                      P=P.right;
                  }
                  left.data=P.data;
                  PP.right=null;
              }
            }
            
        }
        if(right!=null&&right.data==key)
        {
            if(right.isLeaf())
            {
                //System.out.println(left.data);
                right=null;
            }
            else if(right.hasOnlyLeft())
            {
                right=right.left;
                
            }
            else if(right.hasOnlyRight())
            {
                right=right.right;
            }
            else
            {
              if(right.right.hasOnlyRight()||right.right.isLeaf())
              {
                  right.data=right.right.data;
                  right.right=right.right.right;
                  
              }
              else
              {
                  Node PP=right.right;
                  Node P=PP.left;
                  while(P.left!=null)
                  {
                      PP=P;
                      P=P.left;
                  }
                  right.data=P.data;
                  PP.left=null;
              }
            }
            
        }
        else if(left!=null && key<data)
		{
			left.delete(key);
		}
		else if(right!=null&&key>data)
		{
			right.delete(key);
		}
		else
		{
		    return;
		}
        
        
    }
    boolean isLeaf()
    {
        if(left==null&&right==null)
        return true;
        return false;
    }
    boolean hasOnlyLeft()
    {
        if(right==null&&left!=null)
        return true;
        return false;
        
    }
    boolean hasOnlyRight()
    {
        if(left==null&&right!=null)
        return true;
        return false;
    }
    
    
}
class BST
{
    Node root;
    void insert(int key)
    {
        if(root==null)
        {
            root=new Node(key);
        }
        else
        {
            root=root.insert(key);
        }
    }
    void inorder()
    {
        if(root==null)
        return;
        else
        root.inorder();
        
    }
    void preorder()
    {
        if(root==null)
        return;
        else
        root.preorder();
        
    }
    void delete(int key)
    {
    	
        if(root==null)
        return;
        //else if(root.data==key)
        	//root.deleteRoot(root);
        //else
        root.delete(key);
        
    }
    
}
public class Main
{
	public static void main(String[] args) {
		BST b = new BST();
		b.insert(15);
		b.insert(10);
		b.insert(5);
	        b.insert(12);
		//b.preorder();
		//System.out.println();
		//b.preorder();
	    //b.root.left=b.root.left.rotateWithRight();
		//b.root=b.root.rotateWithLeft();
		
		//b.delete(15);
		System.out.println(b.root.height());
		b.preorder();
	}
}
