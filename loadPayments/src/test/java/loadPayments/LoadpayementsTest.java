package loadPayments;



import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class LoadpayementsTest {

	@Test
    public void loadPaymentsTest() throws IOException, InterruptedException {

       String loadPayment ="config/paymentload.csv";
		
		List<String> list = Collections.synchronizedList(new ArrayList<>());;

		BufferedReader br = Files.newBufferedReader(Paths.get(loadPayment));

			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());
			Date date = new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
			for(int i=1;i<list.size();i++) {
				    
					System.out.println();
					System.out.println("New Payement is passed" +'\n' + "Date:" + ts + ","+ "Payement Amount:" + list.get(i));
				    Thread.sleep(1000);
				
			}

	
       
    }
}
