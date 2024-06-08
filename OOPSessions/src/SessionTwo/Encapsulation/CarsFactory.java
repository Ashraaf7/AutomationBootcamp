package SessionTwo.Encapsulation;

//Class  > public - none
//Attributes / methods > public - protected(childs) - private - none
 public class CarsFactory {
    //Attributes / Data
    private  int speed ; //0
    private String Color;
   private String model ;
   private boolean isManual ;
    public CarsFactory()
    {

    }

    public CarsFactory(boolean isManual) {
        this.isManual = isManual;
    }

    public CarsFactory(int speed)
   {
       this.speed= speed;
   }

    //Setter
    public void setColor(String color) {
        Color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    public void setSpeed(int speed)
    {
        if(speed<0)
            System.out.println("In valid");
        else
            this.speed = speed ;
    }

    //Getter

    public String getColor() {
        return Color;
    }

    public String getModel() {
        return model;
    }

    public boolean isManual() {
        return isManual;
    }

    public int getSpeed()
    {
        return speed;
    }




}
