package br.com.everton;

import br.com.everton.exceptions.UnsupportedMathOperationsException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {


    private final AtomicLong counter = new AtomicLong(); // VAI GERAR UM ID.

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

@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method= RequestMethod.GET)
public Double subtraction(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception { //PathVariable passa o valor diretamente na URL

    if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
        throw new UnsupportedMathOperationsException("Please set a numeric value");
    }
    return convertToDouble(numberOne) - convertToDouble(numberTwo);

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
