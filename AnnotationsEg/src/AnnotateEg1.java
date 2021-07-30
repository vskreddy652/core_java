abstract class Animal 
{ 
	public abstract void move() ;
} 


class Monkey extends Animal 
{ 
	@Override 
	public void move() 
	{
		//Compiler error occurs, when no move() method is declared in base class(Animal)
		System.out.println("Jump..."); 
	}
}

public class AnnotateEg1
{
	public static void main(String[] args) {
		System.out.println("Hello");
		
		new Monkey().move();
	}
}
