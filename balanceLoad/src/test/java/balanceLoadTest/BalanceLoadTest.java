package balanceLoadTest;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import balanceLoad.Model.BalanceModel;


public class BalanceLoadTest {
		
    @Test
    public void loadCSVTest() {

        String loadBalance ="config/balanceload.csv";
		
      List<BalanceModel> lists = Collections.synchronizedList(new ArrayList<>());
		
  	  List<String> list = Collections.synchronizedList(new ArrayList<>());;
		
  	 try(Stream<String> stream = Files.lines(Paths.get(loadBalance))){
 	    
  		   list = stream.collect(Collectors.toList());
	    
 			if(list.size() > 0) {
 				for (int i = 1; i < list.size(); i++) {
 			        final String s = list.get(i);
 			        String[] data = s.split(",");
 					Date date = new Date();
 		            long time = date.getTime();
 		            Timestamp ts = new Timestamp(time);
 		            BalanceModel balanceObj = new BalanceModel();
 		            balanceObj.setTimeStamp(ts);
 		            balanceObj.setCreditAmount(Integer.parseInt(data[0]));
 		            balanceObj.setDebitAmount(Integer.parseInt( data[1]));
 		            balanceObj.setAmountNet(Integer.parseInt(data[2])); 
 		            lists.add(balanceObj);
 			         
 			    }
 			}
     
			List<BalanceModel> results = lists.stream()
					.collect(Collectors.toList());
			Set<Integer> existingCreditAmount = new HashSet<>();

			results = lists.stream().filter(model -> existingCreditAmount.add(model.getCreditAmount()))
			        .collect(Collectors.toList());
			
             for(int i=0;i<results.size();i++) {
				
				try {
					System.out.println("New Balance is added-Test is passed");
					System.out.println(results .get(i));
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
             } 
			
		}
		catch(IOException e){
			
			e.printStackTrace();
			
		}
			
    }
}
