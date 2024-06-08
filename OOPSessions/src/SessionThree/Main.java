package SessionThree;

public class Main {
    public static void main(String[] args) {

        //Overloading >> The same name , diff signature (#Params, type) - NO Inheritance
        Add(2,3);
        Add(1.0,2.5);

 //        Person person = new Person();
 //       SampleInterface sampleInterface = new SampleInterface();

        FixedEmployee fixedEmployee = new FixedEmployee();
        fixedEmployee.setSalary(5000);
        fixedEmployee.calculateSalary();

        HourlyEmployee hourlyEmployee = new HourlyEmployee();
        hourlyEmployee.setHours(50);
        hourlyEmployee.setHourlyRate(10);
        hourlyEmployee.calculateSalary();
    }


    public static void Add (int number1 , int number2)
    {


    }
    public static void Add (double number1 , double number2)
    {


    }
}
