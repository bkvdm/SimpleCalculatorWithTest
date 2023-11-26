package tel.bvm.SimpleCalculatorWithTest.conroller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CalculatorExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public String nullMessage(IllegalArgumentException e, HttpServletResponse response) {
        response.setStatus(400);
        return e.getMessage();
    }

    @ExceptionHandler
    @ResponseBody
    public String zeroMessage(IllegalArgumentException e, HttpServletResponse response) {
        response.setStatus(400);
        return e.getMessage();
    }

    @ExceptionHandler
    @ResponseBody
    public String goingBeyond(IllegalArgumentException e, HttpServletResponse response) {
        response.setStatus(400);
        return e.getMessage();
    }
}