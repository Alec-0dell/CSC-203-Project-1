import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * An empty class for unit tests of your new classes.
 */
public class BigNumberTests {

 @Test
    public void testAddition() {
        BigNumber num1 = BigNumber.fromString("523");
        BigNumber num2 = BigNumber.fromString("456");
        assertEquals("979", num1.addition(num2).toString());
        BigNumber num3 = BigNumber.fromString("99999");
        assertEquals("100000", num3.addition(BigNumber.fromString("1")).toString());
        BigNumber num4 = BigNumber.fromString("5982187124389762345638745683476538");
        BigNumber num5 = BigNumber.fromString("8237459873409573095");
        assertEquals("5982187124389770583098619093049633", num4.addition(num5).toString());
    }

    @Test
    public void testMultiplication() {
        BigNumber num1 = BigNumber.fromString("123");
        BigNumber num2 = BigNumber.fromString("456");
        assertEquals("56088", num1.multiplication(num2).toString());
        BigNumber num3 = BigNumber.fromString("134753765");
        BigNumber num4 = BigNumber.fromString("0");
        assertEquals("000000000", num3.multiplication(num4).toString());
        BigNumber num5 = BigNumber.fromString("593645873659");
        BigNumber num6 = BigNumber.fromString("9834756938745345");
        assertEquals("5838362875125392679844367355", num5.multiplication(num6).toString());
    }

    @Test
    public void testExponentiation() {
        BigNumber num1 = BigNumber.fromString("23456457756743");
        assertEquals("1", num1.exponentiation(0).toString());
        BigNumber num2 = BigNumber.fromString("8723458973");
        assertEquals("8723458973", num2.exponentiation(1).toString());
        BigNumber num3 = BigNumber.fromString("73465");
        assertEquals("5397106225", num3.exponentiation(2).toString());
        BigNumber num4 = BigNumber.fromString("7482");
        assertEquals("3133796675144976", num4.exponentiation(4).toString());
        BigNumber num5 = BigNumber.fromString("34554");
        assertEquals("41256747463464", num5.exponentiation(3).toString());
    }

    @Test
    public void testFromString() {
        BigNumber num1 = BigNumber.fromString("984758347503785");
        assertEquals("984758347503785", num1.toString());
        BigNumber num2 = BigNumber.fromString("");
        assertNull(num2);
        BigNumber num3 = BigNumber.fromString("3");
        assertEquals("3", num3.toString());
    }


}
