import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

class A{
	int p1;
	A(int p1, String str){
		this.p1 = p1;
		System.out.println("A()"+p1+str);
	}
	
	public void initBn(){
		System.out.println("initBn()...");
	}
	
	public void destroyBn(){
		System.out.println("destroyBn()...");
	}
	
	@Override
	public String toString(){
		return "a="+p1;
	}
}

class Employee{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
		System.out.println("Employee() ");
	}
}

@Configuration
class MyConfig{
	@Bean 
	@Scope("prototype")
	public Employee getEBean(){
		System.out.println("public Employee getEBean()");
		return new Employee();
	}	
	
	@Bean 
	@Scope("prototype")
	public A getA(int p1, String str){
		return new A(p1,str);
	}
}

public class SpringBeaanAnno {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);

		//ctx.register(MyConfig.class);
		//ctx.refresh();
		
		Employee emp = ctx.getBean(Employee.class);
		emp.setName("fevbrgver");
		
		System.out.println(emp.getName());
		
		A oa = ctx.getBean(A.class, 1001, "str111111111");
		System.out.println(oa);
		
		A oa1 = ctx.getBean(A.class, 1002, "str222222222");
		System.out.println(oa1);
		
	}
}
