package main.java.com.example.demo.controller;

import main.java.com.example.demo.exception.CPFException;
import main.java.com.example.demo.exception.UserIdException;
import main.java.com.example.demo.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {

        String msg = "";
        if (id > 0 && id < 100) {
            msg = "You have entered valid ID";
        } else {
            throw new UserIdException(String.valueOf(id));
        }
        return msg;
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {

        String msg = "";
        if (userName != null && userName.length() > 3 && userName.length() < 15) {
            msg = "You have entered valid USERNAME";
        } else {
            throw new UserNameException(userName);
        }
        return msg;
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {

        String msg = "";
        boolean isCPFValid = isCPF(cpf);

        if (isCPFValid) {
            msg = "You have entered valid CPF";
        } else {
            throw new CPFException(cpf);
        }
        return msg;
    }

    public boolean isCPF(String CPF) {

        return CPF != null && CPF.length() > 3 && CPF.length() < 15;
    }
}
