public interface DelayedStack<E> 
{
	public int size();
	public void push(E element);
	public E pop() throws IllegalStateException;
	public E peek() throws IllegalStateException;
	public int getDelay();
	public void setMaximumDelay(int d);
	public int getMaximumDelay();
	public boolean clear();
	public boolean contains(E elem);
}