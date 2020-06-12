package ash;
class Node {
	int data;
	Node next;
}
class Linkedlist{
    Node head,curr;
    void insert(int d)
    {
        Node temp = new Node();
        temp.data=d;
        if(head==null)//just like in c
        {
            head=temp;
        }
        else
        {
            curr = head;
            while(curr.next!=null)
            {
                curr=curr.next;
            }
            curr.next=temp;
            curr =head;
            
        }
       
    }
    void print()
    {
    	 while(curr!=null)
 		{
 		    System.out.print((curr).data);
 		    curr=curr.next;
 		    if(curr!=null)
 		    	System.out.print("->");
 		}
    }
    int search(int key)
    {
    	int pos=0;
    	while(curr!=null)
    	{
    		if(curr.data==key)
    			return pos;
    		pos++;
    		curr=curr.next;
    	}
    	return -1;
    }
    void insertafter(int pos,int key)
    {
    	Node temp = new Node();
    	temp.data=key;
    	curr = head;
    	while(curr!=null)
    	{
    		if(curr.data==pos)
    		{
    			break;
    		}
    		curr=curr.next;
    	}
    	temp.next=curr.next;
    	curr.next=temp;
    	curr=head;
    	
}
    void insertbefore(int pos,int key)
    {
    	Node temp = new Node();
    	temp.data=key;
    	curr=head;
    	if(curr.data==pos)
    	{
    		temp.next=curr;
    		curr=temp;
    	}
    	else
    	{
    	while(curr!=null)
    	{
    		
    		if(curr.next.data==pos)
    		{
    			break;
    		}
    		curr=curr.next;
    		
    	}
    	
    	
		temp.next=curr.next;
    	curr.next=temp;
    	curr=head;
    }
    	
}
    void delete(int key)
	{
    	curr=head;
    	if(curr.data==key)
    	{
    		
    		curr=curr.next;
    	}
    	else
    	{
      curr =head;
      while(curr!=null)
      {
    	  if(curr.next.data==key)
    	  {
    		  break;
    	  }
    	  curr=curr.next;
      }
      curr.next=curr.next.next;
      curr=head;
    	}
	}
}
 public class LLTest{
	public static void main(String[] args)
	{
		Linkedlist l= new Linkedlist();
		l.insert(5);
		l.insert(6);
		l.insert(7);
		l.insert(20);
		l.insert(11);
		//l.insertbefore(7, 13);
		l.delete(5);
		//System.out.println(l.search(20));
		l.print();
		
	
	}
}
