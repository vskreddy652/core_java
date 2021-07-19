import java.util.*;
import java.util.stream.Collectors;

public class MapStreamExample2 {
	public static void main(String[] args) {
		Map<String, String> x = new HashMap<>();
		x.put("dsda", "v,al,ue");
		x.put("dsda1", "sjd,fhd,sj");
		x.put("dsda2", "val,uee,ee");
		x.put("dsda3", "fd,sf,sd");
		x.put("dsda4", "fsd,fs,d");
		
		Map<String, List<String>> y =
		    x.entrySet().stream()
		        .collect(Collectors.toMap(
		            e -> e.getKey(),
		            e -> Arrays.asList(e.getValue().split(","))
		        ));
		 
		for(Map.Entry<String, List<String>> mpe: y.entrySet()){
			System.out.println(mpe.getKey()+"\t"+mpe.getValue());
		}
	}
}
