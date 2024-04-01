package rowan.ood.annotationexample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Dr. Baliga
 * Here we define a runtime annotation ExampleAnnotation
 * Runtime annotations are available for inspection at run time
 * and are often useful in metaprogramming situations.
 *
 */

// Runtime annotation
@Retention(RetentionPolicy.RUNTIME)
public @interface ExampleAnnotation {
    // Annotations can have elements
    String functionName(); // An element called functionName of type String
}
