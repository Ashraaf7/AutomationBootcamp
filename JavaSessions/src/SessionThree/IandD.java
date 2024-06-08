package SessionThree;

import java.text.DecimalFormat;

public class IandD {
    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 10;
        //++ --
        number1 *= 2 ;  //number1  = number1 - 5
        System.out.println(number1);

        System.out.println(--number1); //number -1
        System.out.println(++number2); //number +1

        System.out.println(number1);
        System.out.println(number2);

        double x = 5.569 ;
        System.out.println(new DecimalFormat("#.#").format(x)); //5.57
        System.out.println(Math.round(x));
        System.out.println(Math.floor(x));
        System.out.println(Math.ceil(x));

    }

}
