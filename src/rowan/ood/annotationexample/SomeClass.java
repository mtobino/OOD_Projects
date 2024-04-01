package rowan.ood.annotationexample;

/**
 *
 * @author Dr. Baliga
 *
 */

public class SomeClass {

    @ExampleAnnotation(functionName = "square")
    public void annotatedMethodSquare(int value) {
        System.out.println("The value is " + (value*value));
    }

    @ExampleAnnotation(functionName = "cube")
    public void annotatedMethodCube(int value) {
        System.out.println("The value is " + (value*value*value));
    }


    public void unAnnotatedMethod(int value) {
        System.out.println("The value is " + value);
    }

}
