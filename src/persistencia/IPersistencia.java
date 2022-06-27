package persistencia;

import java.io.IOException;

public interface IPersistencia<E> {
	public void abrirInput(String nombre) throws IOException;
	
	public void abrirOutput(String nombre) throws IOException;

	public void cerrarInput() throws IOException;
	
	public void cerrarOutput() throws IOException;
	
	public void escribir(E objeto) throws IOException;
	
	E leer() throws IOException,ClassNotFoundException;
	
}
