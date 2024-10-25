import java.util.List;

public class Java17AlgebriacDataStructures {

    /* Example of nested types
     */
    sealed interface Employee permits IndividualContributor, Manager {
    }

    /*
    If you are using a sealed interface, all those permitted classes (e.g. IndividualContributor, Manager) MUST be final.
     */
    static final class IndividualContributor implements Employee {
        private final String name;
        private final int age;
        public IndividualContributor(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    static final class Manager implements Employee {
        private final String name;
        private final int age;
        private final List<Employee> reports;

        public Manager(String name, int age, List<Employee> reports) {
            this.name = name;
            this.age = age;
            this.reports = reports;
        }
    }

    public static void main(String[] args) {
        /*
        Build an algebraic data type: a Union type that is either A or B (called "A | B")
         */
        Employee employee = someMethodReturnAnEmployee2();
        var result = switch (employee) {
            case IndividualContributor ic -> "Individual Contributor: name=" + ic.name + ", age=" + ic.age;
            case Manager mgr -> "Manager: name=" + mgr.name + ", age=" + mgr.age + ", reports count=" + mgr.reports.size();
        };
        System.out.println(result);
    }

    private static Employee someMethodReturnAnEmployee1() {
        return new IndividualContributor("John", 30);
    }

    private static Employee someMethodReturnAnEmployee2() {
        return new Manager("John", 30, List.of());
    }
}
