package synthesizer;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        assertEquals(true, arb.isEmpty());
        assertEquals(false, arb.isFull());
        for ( int i = 0; i < 9; ++i)
        {
            arb.enqueue(33 + i );
            int res = 33 + i;
            assertEquals(33, arb.peek().intValue());
            assertEquals(false, arb.isEmpty());
            assertEquals(false, arb.isFull());
        }
        // dequeue
        assertEquals(33 + 0, arb.dequeue().intValue());

        assertEquals(33 + 1, arb.peek().intValue());
        arb.enqueue(33 + 10);
        arb.enqueue(33 + 11);
        assertEquals(true, arb.isFull());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
