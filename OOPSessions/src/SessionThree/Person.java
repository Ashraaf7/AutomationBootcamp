package SessionThree;

public abstract class Person {
    protected int id ;
   protected  String name ;

    public Person()
    {
        System.out.println("Default Parent Class" );
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Overriding > The same name , The same signature
    public abstract void  calculateSalary(); //abstract
    public void printEmployeeInfo()
    {
        System.out.println(id + " " + name );
    }
}
