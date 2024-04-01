package rowan.ood.annotationexample;

import java.lang.reflect.Method;

/**
 *
 * @author Dr. Baliga
 *
 * This class demonstrates how annotations can be used
 * to effect late binding of methods using programmer defined
 * annotations and Java's reflection API.
 *
 */

public class Driver {

    Object getSomeObject() {
        return new SomeClass();
    }

    // Some methods within parameter object are annotated with
    // the annotation @ExampleAnnotation (functionName = "square")
    // This method will call all such methods
    void callSquareMethods(Object object) {

        Method[] methods = object.getClass().getDeclaredMethods();

        for (Method m: methods) {
            // Check if method is annotated with @ExampleAnnotation
            if (m.isAnnotationPresent(ExampleAnnotation.class)) {
                ExampleAnnotation annotation = m.getAnnotation(ExampleAnnotation.class);

                // If the functionName of the annotation is "square",
                // then run the method
                if (annotation.functionName().equals("square"))
                    try {
                        m.invoke(object, 9);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    void process() {
        Object object = getSomeObject();
        callSquareMethods(object);
    }

    public static void main (String ... args) {
        new Driver().process();
    }

}
