package tel.bvm.SimpleCalculatorWithTest.service;

import jakarta.annotation.Nullable;

public interface CalculatorService {
    String greating();

    String plus(Float one, Float two);

    String minus(Float one, Float two);

    String multiply(Float one, Float two);

    @Nullable
    String divide(Float one, Float two);
}
