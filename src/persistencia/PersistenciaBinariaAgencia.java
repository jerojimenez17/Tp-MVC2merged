package persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class PersistenciaBinariaAgencia<Agencia> implements IPersistencia<Agencia>{
	private FileOutputStream fileOut;
	private FileInputStream fileIn;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	@Override
	public void abrirInput(String nombre) throws IOException {
		this.fileIn=new FileInputStream(nombre);
		this.input=new ObjectInputStream(fileIn);
	}

	@Override
	public void abrirOutput(String nombre) throws IOException {
		this.fileOut=new FileOutputStream(nombre);
		this.output=new ObjectOutputStream(fileOut);
	}

	@Override
	public void cerrarInput() throws IOException {
		if(input!=null)
			input.close();
	}

	@Override
	public void cerrarOutput() throws IOException {
		if(output!=null)
			output.close();
	}

	@Override
	public void escribir(Agencia agencia) throws IOException {
		if(output!=null)
			output.writeObject(agencia);
	}

	@Override
	public Agencia leer() throws IOException, ClassNotFoundException {
		Agencia agencia=null;
		if(input!=null) {	
			
			try {
				agencia= (Agencia) input.readObject();
			} catch (EOFException eof) {
				// TODO Auto-generated catch block
				System.out.println("EOF Exception");
			}
		}
		
		return agencia;
	}

}
