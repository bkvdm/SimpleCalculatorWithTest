package tel.bvm.SimpleCalculatorWithTest.Conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping
    public String greetings() {
        return "Добро пожаловать";
    }

    @GetMapping(path = "/plus")
    public String plus() {
        return "";
    }

    @GetMapping(path = "/minus")
    public String minus() {
        return "";
    }

    @GetMapping(path = "/multiply")
    public String multiply() {
        return "";
    }

    @GetMapping(path = "/divide")
    public String divide() {
        return "";
    }
}
