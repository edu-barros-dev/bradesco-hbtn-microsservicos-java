package src.main.java.com.example.calculator.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.example.calculator.model.Calculator;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    private final Calculator calculator = new Calculator();

    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem-vindo à API Calculator!";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1,
                             @RequestParam(name = "number2") Double n2) {
        return "Resultado da soma: " + calculator.sum(n1, n2);
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1,
                             @RequestParam(name = "number2") Double n2) {
        return "Resultado da subtração: " + calculator.sub(n1, n2);
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1,
                                @RequestParam(name = "number2") Double n2) {
        return "Resultado da divisão: " + calculator.divide(n1, n2);
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {
        return "Resultado do fatorial: " + calculator.factorial(factorial);
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {

        return "Total de dias entre as datas: " +
                calculator.calculeDayBetweenDate(localDate1, localDate2);
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
        return "Número em binário: " + calculator.integerToBinary(n1);
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
        return "Número em hexadecimal: " + calculator.integerToHexadecimal(n1);
    }
}

