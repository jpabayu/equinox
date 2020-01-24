package equinox;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class TestCoba {

	public static void main(String[] args) {
		TestCoba tes = new TestCoba();
		System.out.println(tes.addHourToDate(10));

	}
	
	public String addHourToDate(Integer hourAdd) {
		LocalDateTime nextTime = LocalDateTime.now().plusHours(hourAdd);
		return	nextTime.toString(); 
	}

}
