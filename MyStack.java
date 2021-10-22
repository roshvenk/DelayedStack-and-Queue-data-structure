public class MyStack<E> implements DelayedStack<E> 
{
    boolean status = false;
    int pcounter,finaltime,size,timed,num;
    E delayedS[];
    public MyStack(int d) 
    { 
        delayedS = (E[]) new Object[10000];
        this.size=this.num=0;  
        this.pcounter=this.finaltime=this.timed=d;
        this.status=false;
    }  
   

    public E pop()
    {
        if(this.size > 0)
        {
            if(this.pcounter > 0)
            {
                return null;
            }
            this.size--;
            if(this.pcounter<=0)
            {
                E output = this.delayedS[this.size];
                this.finaltime=this.timed;
                return output;
            }
            status=false;
        }
        else if (this.size <= 0)
        {
            throw new IllegalStateException();  
        }
        return null;
    }

    public int size()
    {
    return this.size;        
    }  

    public void setMaximumDelay(int m)
    {
        this.finaltime=m;
        this.timed=m;
    }

    public void push(E element)
    {
        if(this.status==false)
        {
            this.finaltime=this.timed;
            this.status = true;
            this.pcounter=this.timed;
        }
        this.status=true;
        if(this.pcounter > 0)
        {
            this.pcounter--;
        }
        if(this.pcounter<=0)
        {
            this.num++;
        }
        else if(this.pcounter<=0)
        {
            this.pcounter=0;
        }
        this.delayedS[this.size]=element;
        this.size++;
        
    }

    public int getDelay()
    {
        return this.pcounter;
    }



    public int getMaximumDelay()
    {
        if (this.status != false)
        {
            return this.finaltime;
        }
        else
        {
            this.finaltime=this.timed;
            return this.timed;
        }
    }


    public E peek()
    {
        if(this.size > 0)
        {
            return this.delayedS[this.size-1];  
                    
        }
        else
        {
            throw new IllegalStateException();
        } 
    }
    public boolean contains(E s)
    {
        int i=0;
        while(i <= this.size)
        {
            if(s.equals(this.delayedS[i]))
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
   
    public boolean clear()
    {
        if(this.pcounter > 0)
        {
            return false;
        }
        this.size=0;
        if(this.pcounter<=0)
        {
            this.status = false;
        }
        return true;
    }
     
}

    
