package Session3;
import java.util.Date;
public class Person {
    private String name = "Bryan";
    private int age = 23;
    private Date birthDate = new Date ("08/10/1999");

    public void updateInformation(String newName, int newAge, Date newDate){
        this.name = newName;
        this.age = newAge;
        this.birthDate = newDate;
    }
    public String printInformation(){
        String name = ("Name: " + this.name + "\nAge: " + this.age + "\nBirth date: " + this.birthDate);
        return name ;

    }
}

class Ejercicio {
    public static void main(String[] args) {
        Person persona = new Person();
        Date birthDate = new Date("10/08/1999");
        persona.updateInformation("Bryan", 23, birthDate);
        System.out.println(persona.printInformation());
    }
}

