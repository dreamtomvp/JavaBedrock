public class Main {
    public static void main(String[] args) {
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
    }
}