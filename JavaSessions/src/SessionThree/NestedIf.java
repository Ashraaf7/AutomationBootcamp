package SessionThree;

public class NestedIf {
    public static void main(String[] args) {
        String name = "ahmed";
        int grade = 100 ;
/*
        if(name.equalsIgnoreCase("Ahmed") && grade==100)
            System.out.println("Fail");
 */

        if (name.equals("Ahmed")) //1
        {
            System.out.println("Condition 1 passed");
            if (grade>100) //2
            {
                System.out.println("Condition 2 Passed");
            }
        }
    }
}
