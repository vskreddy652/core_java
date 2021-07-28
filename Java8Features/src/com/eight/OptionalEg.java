package com.eight;
/*
Optional Generic class is added in Java 8 as a solution to NullPointerExceptions. 
Optional is a Generic based container or Wrapper that may or may not contain an object

Prior to Optional:
When an object is null(i..e it doesn't have a valid instance), 
and you try to dereference, NullPointerException is thrown. 
The reason is it may not happen developer checks for null, 
whenever dereferencing an object.

After introducing Optional:
Optional wrapper class provides methods to check if the object is present, 
there by we avoid directly dereferencing it. It forces the developer to check if the
object in Optional is present.

So, whereever we are returning an object which may be null, it's best to replace
with Optional<String>, considering String as the object which is wrapped by Optional.
 */
import java.util.Optional;  
public class OptionalEg {  
    public static void main(String[] args) {  
    	Optional<String> os = met();
        if(os.isPresent()){  // check for value is present or not  
            String lowercaseString = os.get().toLowerCase();  
            System.out.print(lowercaseString);  
        }else  {
            System.out.println("string value is not present"); 
        }
    }  
    
    static Optional<String> met()
    {
        String[] str = new String[10];  
        str[5] = "abcdef";
        Optional<String> checkNull = Optional.ofNullable(str[5]);  
        return checkNull;
    }
}  
