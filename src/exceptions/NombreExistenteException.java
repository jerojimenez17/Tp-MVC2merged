package exceptions;

@SuppressWarnings("serial")
public class NombreExistenteException extends Exception {
	private String username;
	
	public NombreExistenteException(String arg) {
		super(arg);
	}
	public NombreExistenteException(String arg,String username) {
		super(arg);
		this.username=username;
	}
	public String getUsername() {
		return username;
	}
}
