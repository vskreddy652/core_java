
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

class HelloWorld{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

@Configuration
class HelloWorldConfig {
   @Bean 
   public HelloWorld abc(){
	   System.out.println("met() invoked");
      return new HelloWorld();
   }
}

public class Test {  
    	public static void main(String[] args) {
    		   ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
    		   
    		   HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
    		   helloWorld.setMessage("Hello World!");
    		   System.out.println(helloWorld.getMessage());
    		}
          
}  
