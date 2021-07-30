package custom;

public class BusinessLogic {

    @MyAnnotation
    public void method1() {
        System.out.println("Annotated method1 called.");
    }

    @MyAnnotation
    public void method2() {
        System.out.println("Annotated method2 called.");
    }

    public void method3() {
        System.out.println("Method withoud annotation");
    }  
}

