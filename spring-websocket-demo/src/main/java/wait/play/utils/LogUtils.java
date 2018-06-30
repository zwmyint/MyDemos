package wait.play.utils;

public class LogUtils {
	private static final String ERROR = "!!!!!!!!\t";
	private static final String DEBUG = "########\t";
	
	
	public static void error(String message) {
		System.out.println(ERROR + message);
	}
	
	public static void debug(String message) {
		System.out.println(DEBUG + message);
	}

}
