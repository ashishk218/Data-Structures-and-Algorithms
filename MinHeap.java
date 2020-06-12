class MinHeap{
    int[] arr;
    MinHeap(int[] keys)
    {
        arr=keys;
    }
    void print(){
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
    }
    int parent(int index)
    {
        return (index-1)/2;
        
    }
    int get(int i)
    {
        
        return arr[i];
    }
    int left(int index)
    {
        if(2*index+1<arr.length)
        return 2*index+1;
        else
        return -1;
    }
    int right(int index)
    {
        if(2*index+2<arr.length)
        return 2*index+2;
        else
        return -1;
    }
    void buildheap()
    {
        int n=arr.length-1;
        for(int i=(n-1)/2;i>=0;i--)
        {
            int j = check(i);
            if(i==j)
            ;
            else{
                

                fixHeap(i);
            }
        }
        
    }
    void fixHeap(int i){
        //as after every swap we need to go dwon to see if its working correctly or not so for each i we
        //are going down using the fixHeap method 
        int j=check(i);
        if(i==j)
        return ;
        else{
            exchange(i,j);
            fixHeap(j);
        }
        
    }
    void exchange(int i,int j)
    {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
        
        
    }
    int check(int i)
    {
        //check basically returns the minimum of a[i],left and right
         int min=i;
         if(left(i)==-1&&right(i)==-1)
         return i;
        
         else if(right(i)==-1)
          {
             if(arr[i]<arr[left(i)])
             return i;
             else
             return left(i);
          }
            else
            {
                if(arr[i]<arr[left(i)]&&arr[i]<arr[right(i)])
                return i;
                else if(arr[i]>arr[left(i)]&&arr[i]<arr[right(i)])
                return left(i);
                else if(arr[i]<arr[left(i)]&&arr[i]>arr[right(i)])
                return right(i);
                else{
                     if(arr[left(i)]>arr[right(i)])
                     {
                     return right(i);
                     }
                     else
                     {
                     return left(i);
                     }
                  }
            }
        
    }
}


public class Main
{
	public static void main(String[] args) {
		int[] keys ={5,3,8,6,2,1,7,9,4,0};
		MinHeap m = new MinHeap(keys);
		m.print();
		m.buildheap();
		System.out.println();
		m.print();
		//System.out.println(m.right(2));
		
	}
}
