package tel.bvm.SimpleCalculatorWithTest.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String greating() {
        return "Приветствие!";
    }

    public boolean noNullConfirmed(Float one, Float two) {
        return one != null && two != null;
    }

    public String nullMessage() {
        return "Одно из введённых значений выражения пустое. Для расчёта нужны два значения переменных";
    }

    public String divisorZeroMessage() {
        return "Значение делителя равен нулю. На ноль делить нельзя";
    }

    @Override
    public String plus(Float one, Float two) {
        if (noNullConfirmed(one, two)) {
            return one + " + " + two + " = " + (one + two);
        } else {
            return nullMessage();
        }
    }

    @Override
    public String minus(Float one, Float two) {
        if (noNullConfirmed(one, two)) {
            return one + " - " + two + " = " + (one - two);
        } else {
            return nullMessage();
        }
    }

    @Override
    public String multiply(Float one, Float two) {
        if (noNullConfirmed(one, two)) {
            return one + " * " + two + " = " + (one * two);
        } else {
            return nullMessage();
        }
    }

//    @Override
//    public String divide(Float one, Float two) {
//        boolean twoTestZero = two == 0;
//
//        if (!noNullConfirmed(one, two)) {
//            return nullMessage();
//
//        } else {
//            if (!twoTestZero) {
//                return one + " / " + two + " = " + (one / two);
//            } else {
//                return divisorZeroMessage();
//            }
//        }
//    }

    @Override
    public String divide(Float one, Float two) {
        boolean twoTestZero = two == 0;
        boolean singNull = one == null || two == null;
        if (singNull) {
            throw new IllegalArgumentException("Одно из введённых значений выражения пустое. Для расчёта нужны два значения переменных");
        } else {
            if (!twoTestZero) {
                return one + " / " + two + " = " + (one / two);
            } else {
                return divisorZeroMessage();
            }
        }
    }
}
