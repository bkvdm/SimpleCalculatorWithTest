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

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    public static Stream<Arguments> positivePlusVariations() {
        return Stream.of(Arguments.of(1F, 2F, "1.0 + 2.0 = 3.0"),
                Arguments.of(1.05F, 3.45F, "1.05 + 3.45 = 4.5")
        );
    }

    public static Stream<Arguments> divisorZeroMessage() {
        return Stream.of(Arguments.of(Float.MAX_VALUE, 0F, "Значение делителя равен нулю. На ноль делить нельзя"));
    }

    public static Stream<Arguments> nullMessage() {
        return Stream.of(Arguments.of(Float.MAX_VALUE, null, "Одно из введённых значений выражения пустое. Для расчёта нужны два значения переменных"));
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
    @MethodSource("positivePlusVariations")
    void plusPositiveMethod(Float a, Float b, String expected) {
        assertEquals(expected, calculatorService.plus(a, b));
    }

    @ParameterizedTest
    @MethodSource("divisorZeroMessage")
    void divisorZeroMessage(Float a, Float b, String expected) {
        assertEquals(expected, calculatorService.divide(a, b));
    }

    @ParameterizedTest
    @MethodSource("nullMessage")
    void nullMessage(Float a, Float b, String expected) {
        assertEquals(expected, calculatorService.divide(a, b));
    }

    @Test
    void divideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(Float.MAX_VALUE, 0.0F));
    }

    @Test
    void divideByNull() {
        assertThrows(NullPointerException.class, () -> calculatorService.divide(Float.MAX_VALUE, null));
    }
}
