package exceptions;

public class NoSeEncontroUsuarioException extends LoginException {
	private String username;
	
	public NoSeEncontroUsuarioException(String arg) {
		super(arg);
	}
	public NoSeEncontroUsuarioException(String arg,String username) {
		super(arg);
		this.username=username;
	}
	public String getUsername() {
		return username;
	}
	
	
}
