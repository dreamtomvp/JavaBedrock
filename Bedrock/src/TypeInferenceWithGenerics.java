import java.util.ArrayList;
import java.util.List;

public class TypeInferenceWithGenerics {

    public static void printTypeInferenceWithGenerics() {
        /*
            With Generics - Not using Type inference
         */
        List<String> myStringList = new ArrayList<>();
        myStringList.add("a");
        myStringList.add("b");
        myStringList.add("c");
        System.out.println("With Generics - Not using Type inference: " + myStringList);

        /*
            With Generics - Using Type inference
         */
        var inferredStringList = new ArrayList<String>(); // Note: Inside <>, String must be added.
        inferredStringList.add("a");
        inferredStringList.add("b");
        inferredStringList.add("c");
        System.out.println("With Generics - Using Type inference: " + inferredStringList);

    }
}
