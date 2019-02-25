import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static OffByN ob5 = new OffByN(5);

    @Test
    public void testIsOffByN () {
        assertTrue(ob5.equalChars('a', 'f'));
    }
}
