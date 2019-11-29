package loadPayments.streamfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class streamPayementClass {
	
	
   public List<String> loadAmount(){
	   
	   String loadPayment ="config/paymentload.csv";
		
	  List<String> lists = Collections.synchronizedList(new ArrayList<>());
       
      
		
		try(Stream<String> stream = Files.lines(Paths.get(loadPayment))){
			

			lists = stream.collect(Collectors.toList());
			
			
		}
		catch(IOException e){
			
			e.printStackTrace();
			
		}

		
		return lists;
   }

}
