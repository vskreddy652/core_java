import java.util.*;
import java.util.stream.Collectors;

public class MapStreamExample {
	public static void main(String[] args) {
		Map<String, String> x = new HashMap<>();
		x.put("dsda", "value");
		x.put("dsda1", "sjdfhdsj");
		x.put("dsda2", "valueeee");
		x.put("dsda3", "fdsfsd");
		x.put("dsda4", "fsdfsd");
		
		Map<String, Integer> y =
		    x.entrySet().stream()
		        .collect(Collectors.toMap(
		            e -> e.getKey(),
		            e -> e.getValue().length()
		        ));
		 
		for(Map.Entry<String, Integer> mpe: y.entrySet()){
			System.out.println(mpe.getKey()+"\t"+mpe.getValue());
		}
	}
}
