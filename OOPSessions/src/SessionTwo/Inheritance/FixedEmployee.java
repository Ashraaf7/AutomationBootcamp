package SessionTwo.Inheritance;

public class FixedEmployee extends Person {
    double salary;

    public FixedEmployee() {

    }

    public FixedEmployee(int id, String name) {
        super(id, name);
    }

    public FixedEmployee(double salary) {


        this.salary = salary;
    }
}
