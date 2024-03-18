package commonUtils;

import java.util.Random;

	public class JavaUtil {
		
		//everytime when we have to chne the data of excel sheet textfield that ti,e we use random number
			
			public int getRandomNumber()
			{
				Random r = new Random();
				int num = r.nextInt(500);
				return num;
			}
}
