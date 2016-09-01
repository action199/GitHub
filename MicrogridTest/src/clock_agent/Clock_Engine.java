package clock_agent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;



public class Clock_Engine {
	public long myLong = 200;
	/* The artificial clock TIME */
	public static String Time;
	public static GregorianCalendar currentTime;
	static String Date;
	static DateFormat dateFormat;
	static Calendar cal;
	public static String Date_time(){



		Date=dateFormat.format(cal.getTime()).toString()+" "+Time;
		return Date;
	}
	public static String getTime(){


		return Time;
	}

	public static void Start(){
		TimeZone tz = TimeZone.getTimeZone("GMT");
		TimeZone.setDefault(tz);
		currentTime = new GregorianCalendar();
		currentTime.set(2001, 0, 01, 20, 35);
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal = Calendar.getInstance();
		Date=dateFormat.format(cal.getTime()).toString()+" "+Time;
		//cal.set(2001, 0, 01, 10, 10);
		cal.set(2001, 0, 01,8, 10);

		
	//	System.out.println("Hora"+currentTime.getTime().toString());


	}
	public static void doStuff(){
		int a;
		currentTime.add(Calendar.MINUTE, 5);

		System.out.println("Hora"+currentTime.getTime().toString());

		String s=currentTime.getTime().toString();
		String[] tokens = s.split(" ");
		//System.out.println(tokens[3]);
		String[] tokens2 = tokens[3].split(":");
		//System.out.println(tokens2[0]);
		if(Integer.parseInt(tokens2[1])<5){
			a=00;
			Time=tokens2[0]+":"+"00";

		}
		else if (Integer.parseInt(tokens2[1])>= 5 && Integer.parseInt(tokens2[1]) <10){

			Time=tokens2[0]+":"+"05";

		}			
		else{
			a=5*(Math.round(Integer.parseInt(tokens2[1])/5));
			Time=tokens2[0]+":"+String.valueOf(a);
		}
		if (Time.equals("00:00"))
		{

			cal.add(Calendar.DATE, 1);
			Date=dateFormat.format(cal.getTime()).toString()+" "+Time;
		}
		else
			Date=dateFormat.format(cal.getTime()).toString()+" "+Time;

		System.out.println(Date);
	}

}
