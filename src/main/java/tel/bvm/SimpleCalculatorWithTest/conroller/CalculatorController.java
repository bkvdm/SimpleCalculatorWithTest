package tel.bvm.SimpleCalculatorWithTest.conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tel.bvm.SimpleCalculatorWithTest.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return calculatorService.greating();
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(value = "a", required = false) Float one, @RequestParam(value = "b", required = false) Float two) {
        return calculatorService.plus(one, two);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(value = "a", required = false) Float one, @RequestParam(value = "b", required = false) Float two) {
        return calculatorService.minus(one, two);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(value = "a", required = false) Float one, @RequestParam(value = "b", required = false) Float two) {
        return calculatorService.multiply(one, two);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(value = "a", required = false) Float one, @RequestParam(value = "b", required = false) Float two) {
        return calculatorService.divide(one, two);
    }
}