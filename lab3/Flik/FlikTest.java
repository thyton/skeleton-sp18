import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void testIsSameNumber() {
        Integer a = 45;
        Integer b = 45;
        assertTrue(Flik.isSameNumber(a,b));

        int intA = 128;
        int intB = 128;
        assertTrue(Flik.isSameNumber(intA,intB));
    }
}
