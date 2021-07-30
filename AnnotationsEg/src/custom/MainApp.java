package custom;

import java.lang.reflect.Method;

public class MainApp {

    public static void main(String[] args) {

        BusinessLogic bl = new BusinessLogic();
        Method[] methods = bl.getClass().getMethods();

        for (Method method : methods) {
            MyAnnotation run = method.getAnnotation(MyAnnotation.class);
            if (run != null) {
                try {
                    method.invoke(bl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 