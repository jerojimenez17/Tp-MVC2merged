package persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import models.Empleado;

public class PersistenciaEmpleadosXML {
	private static final String SERIALIZED_FILE_NAME="Empleados.XML";
	
	
	public void serializeToXML(List<Empleado> empleados) {
		XMLEncoder encoder=null;
		ArrayList<EmpleadoDTO>empleadosDTO=new ArrayList<EmpleadoDTO>();
		for(Empleado e:empleados) {
			empleadosDTO.add(UtilDTO.empleadoAEmpleadoDTO(e));
		}
		
		try {
			encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		encoder.writeObject(empleadosDTO);
		encoder.close();
	}
	
	public List<Empleado> deserializedFromXML() {
		XMLDecoder decoder=null;
		
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Empleado> empleados=new ArrayList<Empleado>();
		
		List<EmpleadoDTO>empleadosDTO=(List<EmpleadoDTO>) decoder.readObject();
		for(EmpleadoDTO e:empleadosDTO) {
			empleados.add(UtilDTO.empleadoDTOAEmpleado(e));
		}
		return empleados;
	}
	
}
