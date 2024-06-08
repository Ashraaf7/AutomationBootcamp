package SessionTwo.Encapsulation;

public class Main {
    public static void main(String[] args) {
        CarsFactory car1 = new CarsFactory();
        car1.setSpeed(-50);
        System.out.println(car1.getSpeed());
        car1.setSpeed(80);

        CarsFactory car2 = new CarsFactory();
        car2.setSpeed(50);
        System.out.println( car2.getSpeed());


        CarsFactory car3 = new CarsFactory(60);



    }


}
