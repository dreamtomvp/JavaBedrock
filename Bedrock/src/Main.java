public class Main {
    public static void main(String[] args) throws Exception {
        String aWordToYourself = """
               
                "For many actions, the best time to perform was 10 years ago, the second best time is NOW".
                - Wrote on Thu 17 OCT 2024 @London
               """;
        System.out.println(aWordToYourself);
        System.out.println("Hello World!");
        System.out.println("------------------------------------\n");

        /*
        Primitive data types
         */
        System.out.println("[8 Primitive Data Types]:");
        PrimitiveDataTypes.printPrimitiveDataTypes();
        System.out.println("------------------------------------\n");

        /*
        Type inference with generics
         */
        System.out.println("TypeInferenceWithGenerics:");
        TypeInferenceWithGenerics.printTypeInferenceWithGenerics();
        System.out.println("------------------------------------\n");

        /*
        Java 11 Http client using new internal JDK httpClient
         */
        System.out.println("Http client using new internal JDK httpClient:");
        Java11HttpClient.main(new String[0]);
        System.out.println("------------------------------------\n");

        /*
        Java17 - Without using records, using a normal data carrier class
         */
        Java17Records.Employee myEmployee = new Java17Records.Employee("Neil", "Smith", 30);
        System.out.println(myEmployee);
    }
}