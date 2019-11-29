package balanceLoad.compare;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import balanceLoad.File.FileBalanceLoadClass;
import balanceLoad.Model.BalanceModel;

public class CompareBalanceClass {
	
	public void compareCreditBalance() {
		
		    FileBalanceLoadClass newlists = new FileBalanceLoadClass();
		
		    List<BalanceModel> lists = newlists.readFileBalance();
		    
		
			List<BalanceModel> results = lists.stream()
					.collect(Collectors.toList());
			Set<Integer> existingCreditAmount = new HashSet<>();

			results = lists.stream().filter(model -> existingCreditAmount.add(model.getCreditAmount()))
			        .collect(Collectors.toList());
			
			long start = System.currentTimeMillis();

		    for (int i = 0; i < results.size(); i++) {
		        final BalanceModel value = results.get(i);
		         new java.util.Timer().schedule(new java.util.TimerTask() {
		                public void run() {
		                	System.out.println("New Balance is added");
		                    System.out.println(value);
		                }
		         }, new Date(start));

		         start += 1000;
		    }
			
		
	}

}
