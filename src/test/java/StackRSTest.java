import org.junit.jupiter.api.Test;
import stack.StackRS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StackRSTest {

    StackRS stackRS = new StackRS();

    @Test
    public void ClassExists(){
      assertNotNull(stackRS);
    }

    @Test
    public void testPush(){

        stackRS.push("HELLO");
        String expected = "HELLO";
        assertEquals(expected,stackRS.toString());
    }

    @Test
    void testStringReverser(){
        String expected = "OLLEH";
        assertEquals(expected,stackRS.StringReverser("HELLO"));
    }

    @Test
    public void testPop(){
        stackRS.push("LIFO");

        String expected = "O";
        assertEquals(expected, stackRS.pop());
    }

    @Test
    public void testIfArrayIndexOutOfBoundsExceptionOccured(){
        StackRS stackRS = new StackRS(1);
        stackRS.push("r");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stackRS.push("F"));
    }


    @Test
    public void testIfIllegalStateExceptionOccured(){
        StackRS stackRS = new StackRS();
        stackRS.push("r");
        stackRS.pop();
        assertThrows(IllegalStateException.class, stackRS::pop);
    }



}
