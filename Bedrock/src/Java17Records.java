import java.util.Objects;

public class Java17Records {

    // Data carrier class 0 NOT using records
    // An inner class can be static, which means I can access such inner class (Employee) without creating an object of the outer class (Java17Records);
    static class Employee {
        private final String firstname;
        private final String surname;
        private final int age;

        public Employee(String firstname, String surname, int age) {
            this.firstname = firstname;
            this.surname = surname;
            this.age = age;
        }

        public String getFirstname() {return firstname;}
        public String getSurname() {return surname;}
        public int getAge() {return age;}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return getAge() == employee.getAge() && Objects.equals(getFirstname(), employee.getFirstname()) &&
                    Objects.equals(getSurname(), employee.getSurname());
        }

        @Override
        // A native method and returns the integer hash code value of the object.
        public int hashCode() {return Objects.hash(getFirstname(), getSurname(), getAge());}

        @Override
        public String toString() {
            return "Employee{" +
                    "firstname='" + firstname + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    // Data carrier class - using records (Bring above 35 lines to 2 lines, exactly the same outputs)
    // a record is by default a "final" class.
    record RecordEmployee (String firstname, String surname, int age) {
    }


    public static void main(String[] args) {
        var employee1 = new Employee("Martin", "Henderson", 30);
        var employee2 = new Employee("Martin", "Henderson", 30);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee1.equals(employee2));// We need to create Hashcode and Equals to make this work.

        var recordEmployee1 = new RecordEmployee("Martin", "Henderson", 30);
        var recordEmployee2 = new RecordEmployee("Martin", "Henderson", 30);
        System.out.println(recordEmployee1);
        System.out.println(recordEmployee2);
        System.out.println(recordEmployee1.equals(recordEmployee2));// Record, works out of the box
    }
}
