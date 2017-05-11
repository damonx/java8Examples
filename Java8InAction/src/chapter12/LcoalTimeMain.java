package chapter12;

import java.time.LocalTime;

public class LcoalTimeMain {

	public static void main(String[] args) {
        LocalTime time = LocalTime.now();
       // LocalTime time1 = LocalTime.of(15, 20, 20);
        System.out.println(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
	}

}
