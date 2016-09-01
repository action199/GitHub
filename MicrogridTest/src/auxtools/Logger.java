package auxtools;

public class Logger {

	private static String directory=System.getProperty("user.dir");
	public static void exception(String ex) {
		java.io.Writer output = null;
		try {
			output = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(directory+"//Log/log.txt"), true));
			output.write(ex + "\r\n");
			output.close();
		} catch (java.io.IOException e) {
		} finally {
			try {
				if (output != null) {
					output.close();
				}
			} catch (java.io.IOException e) {
			}
		}
	}
	
	public static void cfp(String ex) {
		java.io.Writer output = null;
		try {
			output = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(directory+"//Log/cfp.txt"), true));
			output.write(ex + "\r\n");
			output.close();
		} catch (java.io.IOException e) {
		} finally {
			try {
				if (output != null) {
					output.close();
				}
			} catch (java.io.IOException e) {
			}
		}
	}

}
