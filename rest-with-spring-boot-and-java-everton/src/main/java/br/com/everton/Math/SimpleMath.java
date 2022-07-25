package br.com.everton.Math;

import br.com.everton.NumberConverter.NumberConverter;
import br.com.everton.exceptions.UnsupportedMathOperationsException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SimpleMath {

    //Soma
    public Double sum(Double numberOne, Double numberTwo)  { //PathVariable passa o valor diretamente na URL
        return numberOne + numberTwo;
    }

    //Subtração
    public Double subtraction(Double numberOne, Double numberTwo)  { //PathVariable passa o valor diretamente na URL
        return numberOne - numberTwo;
    }

    //Divisao
    public Double division(Double numberOne, Double numberTwo)  { //PathVariable passa o valor diretamente na URL
        return numberOne / numberTwo;
    }


    //media
    public Double average(Double numberOne, Double numberTwo)  { //PathVariable passa o valor diretamente na URL
        return (numberOne + numberTwo) /2;
    }

    //Multiplicacao
    public Double multiplication(Double numberOne, Double numberTwo) { //PathVariable passa o valor diretamente na URL
        return numberOne * numberTwo;
    }

    //raiz quadrada
    public Double raiz(Double number) { //PathVariable passa o valor diretamente na URL
        return Math.sqrt(number);
    }

}
