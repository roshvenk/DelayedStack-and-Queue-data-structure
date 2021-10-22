
public class MyQueue<E> implements DelayedQueue<E> 
{
    int timed, head,size, tail, finaltime, pcounter;
    boolean status = false;
    E delayedQ[];	
    public MyQueue(int delay) 
    { 
        this.head = this.tail = -1; 
        this.pcounter= this.finaltime = this.timed = delay;
        this.status=false;
        this.size=0;
        delayedQ = (E[]) new Object[10000];
    }  

    public int size()
    {
	return this.size;
    }

        

    public E dequeue()
    {
        if (this.size == 0)
       {
        throw new IllegalStateException("The queue is empty!\n");
       }
       else if(this.size > 0)
        {
            if(this.pcounter<=0)
            {
                E output = this.delayedQ[head];
                if(this.head!=this.tail)
                {
                    this.head=(this.head+1)%100000;
                }
                else if (this.head == this.tail)
                {
                    this.head=this.head-1;
                    this.tail=this.tail-1;
                }

                this.size--;
                this.finaltime=this.timed;
                this.status=false;
                return output;
            }

            if (this.pcounter > 0)
            {
                return null;
            }

       }
       return null;
    }

    public void setMaximumDelay(int m)
    {
        this.finaltime=m;
	    this.timed=m;
    }
    public void enqueue(E element)
    {
        
        if(this.head == -1)
        {
            if(this.head == this.tail)
            {
                this.head=this.tail=0;
            }
        }
        else 
        {
            this.tail = (this.tail+1)%100000;
        }
        
        if(status==false)
        {
            this.finaltime=this.timed;
            this.pcounter=this.timed;
        }

        this.size++;
        this.delayedQ[this.tail]=element;
        this.pcounter--;

        if(this.pcounter <= 0)
        {
            this.pcounter=0;
        }
        this.status=true;
    }


       
    public int getMaximumDelay()
    {
        if (this.status != false)
        {
            return this.finaltime;
        }
        else if(this.status== false)
        {
            this.finaltime=this.timed;
            return this.timed;
        }
        return this.finaltime;
    }

    public int getDelay()
    {
        return this.pcounter;
    }

    public E peek()
    {
        if (this.size <= 0)
        {
            throw new IllegalStateException("Queue is empty!\n");
        }
        if(this.size > 0)
        {
            return this.delayedQ[this.head];  
                    
        }
        
    }   
    

    public boolean clear()
    {
        if (this.pcounter > 0)
        {
            return false;
        }

        else
        {
            this.head = this.head-1;
            this.tail =this.tail - 1;
            this.size=0;
            this.status = false;
            return true;
        }
    }  
    

    public boolean contains(E x)
    {
        int i;
        i = this.head;

        while(i <= this.tail)
        {
            if(x.equals(this.delayedQ[i]))
            {
                return true;
            }
            else
            {
                i++;
            }
        }
        return false;
    }         
}
    
