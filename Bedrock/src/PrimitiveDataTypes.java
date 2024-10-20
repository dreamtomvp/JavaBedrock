public class PrimitiveDataTypes {
    public static void printPrimitiveDataTypes() {
        var myString = "Hi, I am a string"; // String, var is: type inference (99% correct) introduced in Java 11
        var myInt = 12345; // int
        var myShort = 1234; // short
        var myLong = 12345L; // long
        var myChar = 'A'; // char
        var myBoolean = true; // boolean
        var myFloat = 2.5; // float
        byte myByte = 127; // byte - this is where type inference may fail;

        System.out.println("[1/8]: string: " + myString);
        System.out.println("[2/8]: int: " + myInt);
        System.out.println("[3/8]: short: " + myShort);
        System.out.println("[4/8]: long: " + myLong);
        System.out.println("[5/8]: char: " + myChar);
        System.out.println("[6/8]: boolean: " + myBoolean);
        System.out.println("[7/8]: float: " + myFloat);
        System.out.println("[8/8]: byte: " + myByte);
    }
}
