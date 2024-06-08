package SessionThree;

public class Functions {
   public static int counter ;  //global
    public static void main(String[] args) {
        //calling
       int result = Sum(5,10);  //arguments

        System.out.println(result);
        Sum(4,3);
        Sum(50,20);
        Diff(90,70);
        Math.abs(-5);
        counter++;
    }

    //declaration
    public static int Sum (int x , int y) //parameters //header
    {
        //Body
        int result = x+y;  //local
        System.out.println(result);
        counter++;
        return result ;
    }

    public static int Diff (int x , int y) //parameters //header
    {
        //Body
         counter++;
        System.out.println(x-y);
        return x-y  ;
    }
}

