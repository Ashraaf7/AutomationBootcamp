package SessionOne;

public class Main {
    public static void main(String[] args) {
        Cars car1 = new Cars("BMW" ,100 , "Black", false); //1

        System.out.println(car1);
        car1.printInfo();


        Cars car2 = new Cars("128",50,"White",true); //2
        System.out.println(car2);
        car2.printInfo();


        // int > 0   float > 0.0   String/char> null , N/A
        Cars car3 = new Cars(); //3
        car3.printInfo();

        Cars car4 = new Cars("Honda","Blue"); //4
        car4.printInfo();
        //screenshot() >> static
        //Screenshot s1 = new Screenshot();  X
        //Utilities.screenshot();

        /*Math.abs();
        Math.floor();
        Math.sin();*/



        Cars.printNumberOfObjects();
    }
}
