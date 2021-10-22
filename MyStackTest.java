import static org.junit.Assert.*;
import org.junit.Test;
package DelayedStack;

public class MyStackTest{
    
    @Test
    public void testPush1()
    {
        MyStack<String> subject = new MyStack<String>(3);
        subject.push("test1");
        subject.push("test2");
        assertEquals(2, subject.size());
        assertEquals("test2", subject.pop());
        subject.clear();
    }

    @Test
    public void test()
    {
        MyStack<String> subject = new MyStack<String>(0);
        subject.getMaximumDelay();
        subject.getDelay();
        assertThrows(IllegalStateException.class, () -> {
            subject.pop();});
        assertThrows(IllegalStateException.class, () -> {
             subject.peek();});
        subject.push("test");
        subject.pop();
        subject.clear();

    }

    @Test
    public void testPush2()
    {
        MyStack<String> subject = new MyStack<String>(3);
        subject.push("test1");
        subject.contains("test1");
        subject.contains("test2");
        assertEquals("test1", subject.peek());
        subject.clear();

    }

    @Test
    public void testMaxDelay()
    {
        MyStack<String> subject = new MyStack<String>(3);
        subject.setMaximumDelay(1);
        assertEquals(1, subject.getMaximumDelay());
        subject.clear();
    }

    @Test
    public void testDelay()
    {
        MyStack<String> subject = new MyStack<String>(3);
        assertEquals(3, subject.getDelay());
    }
}