package br.com.everton;

import br.com.everton.exceptions.UnsupportedMathOperationsException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {


    private final AtomicLong counter = new AtomicLong(); // VAI GERAR UM ID.
//Soma
    //Recupera dados da URL
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception { //PathVariable passa o valor diretamente na URL

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationsException("Please set a numeric value");
        }
         return convertToDouble(numberOne) + convertToDouble(numberTwo);

     }

//Subtração
@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method= RequestMethod.GET)
public Double subtraction(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception { //PathVariable passa o valor diretamente na URL

    if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
        throw new UnsupportedMathOperationsException("Please set a numeric value");
    }
    return convertToDouble(numberOne) - convertToDouble(numberTwo);

}

//Divisao
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception { //PathVariable passa o valor diretamente na URL

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationsException("Please set a numeric value");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);

    }


//media
    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double average(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception { //PathVariable passa o valor diretamente na URL

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationsException("Please set a numeric value");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) /2;

    }


//Multiplicacao
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception { //PathVariable passa o valor diretamente na URL

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationsException("Please set a numeric value");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);

    }

//raiz quadrada
    @RequestMapping(value = "/raiz/{numberOne}", method= RequestMethod.GET)
    public Double raiz(
            @PathVariable(value = "numberOne") String numberOne) throws Exception { //PathVariable passa o valor diretamente na URL
        if(!isNumeric(numberOne)){
            throw new UnsupportedMathOperationsException("Please set a numeric value");
        }

        return Math.sqrt(convertToDouble(numberOne));

    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }

}
