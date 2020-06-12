//Circular Queue
class ArrayQueue{
    int[] arr;
    int front,rear;
    int MAXSIZE;
    ArrayQueue(int k)
    {
        arr=new int[k];
        MAXSIZE=k;
        front=-1;
        rear=-1;
    }
    void enqueue(int key)
    {
        if(front==-1&&rear==-1)
        {
            front=0;
            rear=0;
            
        }
        else if((rear+1)%MAXSIZE==front)
        {
            System.out.println("Queue is Full");
            return;
        }
        else{
            rear=(rear+1)%MAXSIZE;
        }
        arr[rear]=key;
        
    }
    int dequeue()
    {
        if(front==-1&&rear==-1)
        {
            return 100;
        }
        else if(front==rear)
        {
            int val=arr[front];
            front=-1;
            rear=-1;
            return val;
        }
        else{
            int val=arr[front];
            front=(front+1)%MAXSIZE;
            return val;
        }
            
        
    }
    void print()
    {
        int i=front;
        while(i!=rear)
        {
            System.out.print(arr[i]);
            System.out.print("-");
            i=(i+1)%MAXSIZE;
            
            
        }
        System.out.print(arr[rear]);
    }
    
    
}
public class Main
{
	public static void main(String[] args) {
		ArrayQueue q = new ArrayQueue(6);
		q.enqueue(2);
		q.enqueue(4);
		q.enqueue(6);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(12);
		q.dequeue();
		q.dequeue();
		q.enqueue(7);
	q.print();
		
		
	}
}
