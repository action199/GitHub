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

public class Aux_Clock {
	public long myLong = 1500;
	/* The artificial clock TIME */
	public static String Time;
	public static GregorianCalendar currentTime;
	static String Date;
	static DateFormat dateFormat;
	static Calendar cal;
	boolean flag = false;
	public static String Date_time(){



		Date=dateFormat.format(cal.getTime()).toString()+" "+Time;
		return Date;
	}
	public  String getTime(String Time){
		int a;
		//currentTime.setTime(date);
		//currentTime = new GregorianCalendar();
		
		
		//currentTime.add(Calendar.MINUTE, 5);
		
		//System.out.println("Hora"+currentTime.getTime().toString());
		//flag=true;
		String s=Time;
		String[] tokens = s.split(" ");
	//	System.out.println("YOO    "+ s);
		
		String[] date = tokens[0].split("-");
		
		String[] tokens2 = tokens[1].split(":");
	
		if(Integer.parseInt(tokens2[1])<5){
			a=00;
			Aux_Clock.Time=tokens2[0]+":"+tokens2[1];

		}
		else if (Integer.parseInt(tokens2[1])>= 5 && Integer.parseInt(tokens2[1]) <10){

			Aux_Clock.Time=tokens2[0]+":"+tokens2[1];

		}			
		else{
			a=5*(Math.round(Integer.parseInt(tokens2[1])/5));
			Aux_Clock.Time=tokens2[0]+":"+String.valueOf(a);
		}
		
			cal.set(Integer.parseInt(date[0]),Integer.parseInt(date[1])-1,Integer.parseInt(date[2]));
	//	System.out.println("DDDD" +Aux_Clock.Time);
		
		cal.add(Calendar.DATE, 1);

		Date=dateFormat.format(cal.getTime()).toString()+" "+Time;
	//	System.out.println(Date);

		return Time;
	}

	public static void Start(){
		TimeZone tz = TimeZone.getTimeZone("GMT");
		TimeZone.setDefault(tz);
		currentTime = new GregorianCalendar();
		//currentTime.set(2001, 0, 01, 10, 10);
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal = Calendar.getInstance();
		Date=dateFormat.format(cal.getTime()).toString()+" "+Time;
		cal.set(2001, 0, 01, 10, 10);
		cal.set(2001, 0, 01);

	



	}
//	public static void doStuff(){
//		int a;
//		currentTime.add(Calendar.MINUTE, 5);
//		
//		//System.out.println("Hora"+currentTime.getTime().toString());
//
//		String s=currentTime.getTime().toString();
//		String[] tokens = s.split(" ");
//		//System.out.println(tokens[3]);
//		String[] tokens2 = tokens[3].split(":");
//		//System.out.println(tokens2[0]);
//		if(Integer.parseInt(tokens2[1])<5){
//			a=00;
//			Aux_Clock.Time=tokens2[0]+":"+"00";
//
//		}
//		else if (Integer.parseInt(tokens2[1])>= 5 && Integer.parseInt(tokens2[1]) <10){
//
//			Aux_Clock.Time=tokens2[0]+":"+"05";
//
//		}			
//		else{
//			a=5*(Math.round(Integer.parseInt(tokens2[1])/5));
//			Aux_Clock.Time=tokens2[0]+":"+String.valueOf(a);
//		}
//		if (Time.equals("00:00"))
//		{
//
//			cal.add(Calendar.DATE, 1);
//			Date=dateFormat.format(cal.getTime()).toString()+" "+Time;
//		}
//		else
//			Date=dateFormat.format(cal.getTime()).toString()+" "+Time;
//
//		/*String directory=System.getProperty("user.dir");
//		String Value=GridlabXml.ler(directory+"//Data//Profiles//solar.xml",Date);*/
//		System.out.println(Date);
//	}
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