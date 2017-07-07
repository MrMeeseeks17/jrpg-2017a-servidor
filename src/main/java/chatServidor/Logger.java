package chatServidor;

public interface Logger {
	
	public static int LOGLEVEL_NORMAL = 0;
	public static int LOGLEVEL_DEBUG = 1;
	public static int LOGLEVEL_ALL = 2;
	
	public void setLogLevel(int ll);
	
	public void log_normal(String s);
	
	public void log_debug(String s);
	
	public void log_all(String s);
	
	public void userConnected(String s);
	
	public void userDisConnected(String s);
}
