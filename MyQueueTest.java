import static org.junit.Assert.*;
import org.junit.Test;
package DelayedQueue;

public class MyQueueTest
{
    @Test
    public void test()
    {
        DelayedQueue<String> subject = new MyQueue<String>(5);
        assertEquals(0, subject.size());
    }

    @Test
    public void testQueue1()
    {
        DelayedQueue<String> subject = new MyQueue<String>(5);
        assertEquals(0, subject.size());
        subject.enqueue("testing1");
        subject.enqueue("testing2");
        subject.enqueue("testing3");
        assertEquals(3, subject.size());
        assertEquals("testing3", subject.dequeue());
        subject.clear();
    }

    @Test
    public void testDequeue()
    {
        DelayedQueue<String> subject = new MyQueue<String>(5);
        subject.enqueue("element1");
        subject.dequeue();
        subject.dequeue();
        assertEquals(null, subject.dequeue());
        subject.clear();

    }
    
    @Test
    public void testQueue2()
    {
        DelayedQueue<String> subject = new MyQueue<String>(5);
        subject.enqueue("yes");
        subject.contains("mmhmm");
        assertTrue(subject.contains("yes"));
        subject.peek();
        assertEquals("yes", subject.peek());
        subject.clear();
    }

    @Test
    public void testMaxDelay()
    {
        DelayedQueue<String> subject = new MyQueue<String>(5);
        subject.setMaximumDelay(3);
        assertEquals(3, subject.getMaximumDelay());
        subject.clear();
    }

    @Test
    public void testDelay()
    {
        DelayedQueue<String> subject = new MyQueue<String>(5);
        assertEquals(5, subject.getDelay());
        subject.clear();
    }
}