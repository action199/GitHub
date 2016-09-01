package auxtools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class Clock {
	public long myLong = 10000;
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
		//currentTime.set(2001, 0, 01, 14, 35);
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal = Calendar.getInstance();
		Date=dateFormat.format(cal.getTime()).toString()+" "+Time;
		//cal.set(2001, 0, 01, 10, 10);
		cal.set(2001, 0, 01,8, 10);

		final Clock test = new Clock();

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Clock.doStuff();
			}
		}, 0, test.myLong);


	}
	public static void doStuff(){
		int a;
		currentTime.add(Calendar.MINUTE, 5);

		//System.out.println("Hora"+currentTime.getTime().toString());

		String s=currentTime.getTime().toString();
		String[] tokens = s.split(" ");
		//System.out.println(tokens[3]);
		String[] tokens2 = tokens[3].split(":");
		//System.out.println(tokens2[0]);
		if(Integer.parseInt(tokens2[1])<5){
			a=00;
			Clock.Time=tokens2[0]+":"+"00";

		}
		else if (Integer.parseInt(tokens2[1])>= 5 && Integer.parseInt(tokens2[1]) <10){

			Clock.Time=tokens2[0]+":"+"05";

		}			
		else{
			a=5*(Math.round(Integer.parseInt(tokens2[1])/5));
			Clock.Time=tokens2[0]+":"+String.valueOf(a);
		}
		if (Time.equals("00:00"))
		{

			cal.add(Calendar.DATE, 1);
			Date=dateFormat.format(cal.getTime()).toString()+" "+Time;
		}
		else
			Date=dateFormat.format(cal.getTime()).toString()+" "+Time;

		/*String directory=System.getProperty("user.dir");
		String Value=GridlabXml.ler(directory+"//Data//Profiles//solar.xml",Date);*/
		System.out.println(Date);
	}
	/*
public static void main(String[] args) {
		Start();
		String aa;
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		aa=Date_time();

		System.out.println("time YOOOOOOO"+aa);

	}*/
}