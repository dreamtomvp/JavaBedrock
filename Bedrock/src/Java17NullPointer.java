public class Java17NullPointer {

    public static void main(String[] args) {

        String myString = null;
        int mySize = myString.length();
        System.out.println(mySize);
    }
}
