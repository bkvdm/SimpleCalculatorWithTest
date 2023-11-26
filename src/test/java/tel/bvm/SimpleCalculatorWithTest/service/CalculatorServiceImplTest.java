package tel.bvm.SimpleCalculatorWithTest.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorServiceImplTest {

    public static Float variableValuer() {
        java.util.Random random = new java.util.Random();
        Float minimumScore = Float.MIN_VALUE;
        return random.nextFloat(Float.MAX_VALUE) + minimumScore;
    }

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    public static Stream<Arguments> positivePlusVariations() {
        return Stream.of(Arguments.of(1F, 2F, "1.0 + 2.0 = 3.0"),
                Arguments.of(1.05F, 3.45F, "1.05 + 3.45 = 4.5")
        );
    }

    public static Stream<Arguments> positiveMultiplyVariations() {
        Float one = variableValuer();
        Float two = variableValuer();
        Float meaning = one + two;
        String result = one + " * " + two + " = " + meaning;
        return Stream.of(Arguments.of(one, two, result));
    }

    @Test
    void greating() {
        String greatingExcepted = "Приветствие!";
        assertEquals(greatingExcepted, calculatorService.greating());
    }

    @Test
    void plus() {
        String resultExcepted = "50.08 + 50.5 = 100.58";
        assertEquals(resultExcepted, calculatorService.plus(50.08F, 50.50F));
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 3, 2.0 + 3.0 = 5.0", "1.05, 3.45, 1.05 + 3.45 = 4.5"})
    void plusPositive(Float a, Float b, String resultExcepted) {
         assertEquals(resultExcepted, calculatorService.plus(a, b));
    }

    @ParameterizedTest
    @CsvSource(value = {"200, 300, 200.0 - 300.0 = -100.0", "100.05, 300.45, 100.05 - 300.45 = -200.40001"})
    void minusPositive(Float a, Float b, String resultExcepted) {
         assertEquals(resultExcepted, calculatorService.minus(a, b));
    }

    @ParameterizedTest
    @MethodSource("positivePlusVariations")
    void plusPositiveMethod(Float a, Float b, String expected) {
        assertEquals(expected, calculatorService.plus(a, b));
    }

    @ParameterizedTest
    @MethodSource("positiveMultiplyVariations")
    void multiplyPositiveMethod(Float one, Float two, String expected) {
        assertEquals(expected, calculatorService.multiply(one, two));
    }

    @Test
    void divideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(Float.MAX_VALUE, 0.0F));
    }

    @Test
    void plusByNull() {
        assertThrows(NullPointerException.class, () -> calculatorService.plus(Float.MAX_VALUE, null));
    }

    @Test
    void plusByNullSecond() {
        assertThrows(NullPointerException.class, () -> calculatorService.plus(null, Float.MAX_VALUE));
    }

    @Test
    void plusByNullAllNull() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.plus(null, null));
    }

    @Test
    void minusByNull() {
        assertThrows(NullPointerException.class, () -> calculatorService.minus(Float.MAX_VALUE, null));
    }

    @Test
    void minusByNullSecond() {
        assertThrows(NullPointerException.class, () -> calculatorService.minus(null, Float.MAX_VALUE));
    }

    @Test
    void minusByNullAllNull() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.minus(null, null));
    }

    @Test
    void multiplyByNull() {
        assertThrows(NullPointerException.class, () -> calculatorService.multiply(Float.MAX_VALUE, null));
    }

    @Test
    void multiplyByNullSecond() {
        assertThrows(NullPointerException.class, () -> calculatorService.multiply(null, Float.MAX_VALUE));
    }

    @Test
    void multiplyByNullAllNull() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.multiply(null, null));
    }

    @Test
    void divideByNull() {
        assertThrows(NullPointerException.class, () -> calculatorService.divide(Float.MAX_VALUE, null));
    }

    @Test
    void divideByNullSecond() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(null, Float.MAX_VALUE));
    }

    @Test
    void divideByNullAllNull() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(null, Float.MAX_VALUE));
    }

    @Test
    void goingBeyond() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.multiply(Float.MAX_VALUE, Float.MAX_VALUE));
    }
}
