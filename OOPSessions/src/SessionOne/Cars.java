package SessionOne;

//Class  > public - none
//Attributes / methods > public - protected(childs) - private - none
 public class Cars {
    //Attributes / Data
   static int counter=0 ;  //non-static >> counter++;
    int speed ;
    String Color;
    String model ;
    boolean isManual ;

    //Methods / Operations
    //Constructor > public - NO return - The same name
    //Default - empty
    public Cars() //input / parameter
    {
        //Body
        System.out.println("Empty object created");
        counter++;
    }
    //Parameterized
    public Cars (String model,int speed,String color,boolean isManual)
    {
        this.model = model;
        this.speed = speed;
        this.Color = color;
        this.isManual = isManual;
        counter++;
    }
    public Cars (String model,String color)
    {
        this.model = model;
        this.Color = color;
        counter++;
    }

    public void printInfo ()
    {
        System.out.println("Model: " +model + ", " + "Speed: "
                +speed + ", " + "Color: " + Color + "," + "Is Manual: " + isManual);

      //  System.out.println("Number of objects: " + counter);
    }
    public static void printNumberOfObjects() //non-static
    {
        System.out.println("Number of objects: " + counter);
    }


}
