package custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD) // MyAnnotation Can be applied only for methods
@Retention(value = RetentionPolicy.RUNTIME) // MyAnnotation will be retained until runtime
public @interface MyAnnotation {

} 

