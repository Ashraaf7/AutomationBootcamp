package HandelingException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int number1 = 60;
       int number2 = 60;
        System.out.println("Ahmed");
        try {
            //Code
            System.out.println(number1/number2); //exc
        }catch (Exception exception ) {
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("Ashraf");
        }





        }
    }

