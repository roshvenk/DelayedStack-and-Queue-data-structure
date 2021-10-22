import static org.junit.Assert.*;
import org.junit.Test;

public class Stacktest{
    @Test
    public void testSmall(){
        MyStack<String> small = new MyStack<String>(5);
        assertEquals(5, small.getDelay());
    }
}