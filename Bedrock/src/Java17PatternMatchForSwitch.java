import javax.naming.OperationNotSupportedException;

public class Java17PatternMatchForSwitch {

    public static void main(String[] args) throws OperationNotSupportedException {

        /*
        Old switch (Before Java 17)
         */
        TestEnum x = someMethodReturningAnEnumValue();
        switch (x) {
            case VALUE1:
                System.out.println("Old Switch: You selected VALUE1");
                break;
            case VALUE2:
                System.out.println("Old Switch: You selected VALUE2");
                break;
            case VALUE3:
                System.out.println("Old Switch: You selected VALUE3");
                break;
            default:
                throw new OperationNotSupportedException("Old Switch: this value is not supported");
        }

        /*
        New switch (from Java 17) - with pattern match
        Now switch becomes a statement, not an expression anymore.
        [Benefits]: 1) This makes code more concise; 2) If adding the 4th value, VALUE4, but with missing
         implementation, new switch can catch such error during compile time, old switch can only catch it during run
         time, which is too late and not idea.
         */
        var outputString = switch (x) {
            case VALUE1 -> "New Switch: You selected VALUE1";
            case VALUE2 -> "New Switch: You selected VALUE2";
            case VALUE3 -> "New Switch: You selected VALUE3";
        };
        System.out.println(outputString);

    }

    enum TestEnum {
        VALUE1,
        VALUE2,
        VALUE3,
    }

    private static TestEnum someMethodReturningAnEnumValue() {
        return TestEnum.VALUE2;
    }



}
