package tel.bvm.SimpleCalculatorWithTest.service;

import org.springframework.stereotype.Service;
import tel.bvm.SimpleCalculatorWithTest.conroller.CalculatorExceptionHandler;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String greating() {
        return "Приветствие!";
    }

    public boolean noNullConfirmed(Float one, Float two) {
        return one != null || two != null;
    }

    public String nullMessage() {
        return "Одно из введённых значений выражения пустое. Для расчёта нужны два значения переменных";
    }

    public String divisorZeroMessage() {
        return "Значение делителя равен нулю. На ноль делить нельзя";
    }

    public String goingBeyond() {
        return "Выход за пределы допустимого значения переменной";
    }

    @Override
    public String plus(Float one, Float two) {
        if (noNullConfirmed(one, two)) {
            return one + " + " + two + " = " + (one + two);
        } else {
            throw new IllegalArgumentException(nullMessage());
        }
    }

    @Override
    public String minus(Float one, Float two) {
        if (noNullConfirmed(one, two)) {
            Float result = one - two;
            return one + " - " + two + " = " + result;
        } else {
            throw new IllegalArgumentException(nullMessage());
        }
    }

    @Override
    public String multiply(Float one, Float two) {
        if (noNullConfirmed(one, two)) {
            Float result = one * two;
            if (Float.isInfinite(result) || Float.isNaN(result)) {
                throw new IllegalArgumentException(goingBeyond());
            } else {
            return one + " * " + two + " = " + result;
            }
        } else {
            throw new IllegalArgumentException(nullMessage());
        }
    }

    @Override
    public String divide(Float one, Float two) {
        boolean twoTestZero = two == 0;
        boolean singNull = one == null || two == null;
        if (singNull) {
            throw new IllegalArgumentException(nullMessage());
        } else {
            if (!twoTestZero) {
                return one + " / " + two + " = " + (one / two);
            } else {
                throw new IllegalArgumentException(divisorZeroMessage());
            }
        }
    }
}