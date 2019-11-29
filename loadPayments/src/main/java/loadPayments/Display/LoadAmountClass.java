package loadPayments.Display;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import loadPayments.streamfile.streamPayementClass;

public class LoadAmountClass {
	
	streamPayementClass newlists = new streamPayementClass();
	
	List<String> lists = newlists.loadAmount();
	

	public void loadPaymentAmount() {
		long start = System.currentTimeMillis();
      
	    for (int i = 0; i < lists.size(); i++) {
	        final String value = lists.get(i);
	         new java.util.Timer().schedule(new java.util.TimerTask() {
	                public void run() {
	                	Date date = new Date();
	                    long time = date.getTime();
	                    Timestamp ts = new Timestamp(time);
	        			System.out.println("New Payement is passed" +'\n' + "Date:" + ts + ","+ "Payement Amount:" + value);
	   
	                }
	         }, new Date(start));

	         start += 1000;
	    }
	}

}
