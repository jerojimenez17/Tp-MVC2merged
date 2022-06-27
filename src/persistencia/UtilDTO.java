package persistencia;

import java.time.LocalDate;

import models.Empleado;

public class UtilDTO {
	
	public static  EmpleadoDTO empleadoAEmpleadoDTO(Empleado empleado) {
		EmpleadoDTO empleadoDTO=new EmpleadoDTO();
		
		empleadoDTO.setUsername(empleado.getUsername());
		empleadoDTO.setPassword(empleado.getPassword());
		
		empleadoDTO.setName(empleado.getName());
		empleadoDTO.setType(empleado.getType());
		empleadoDTO.setPuntaje(empleado.getPuntaje());
		
		empleadoDTO.setSurname(empleado.getSurname());
		empleadoDTO.setPhone(empleado.getPhone());
		empleadoDTO.setDni(empleado.getDNI());
		empleadoDTO.setBornDate(empleado.getBornDate());
		
		
		
		return empleadoDTO;
	}
	public static  Empleado empleadoDTOAEmpleado(EmpleadoDTO empleadoDTO) {
		Empleado empleado;
		String username=empleadoDTO.getUsername();
		String password=empleadoDTO.getPassword();
		String name=empleadoDTO.getName();
		//String type=empleadoDTO.getType();
		double puntaje=empleadoDTO.getPuntaje();
		String surname=empleadoDTO.getSurname();
		String phone=empleadoDTO.getPhone();
		String dni=empleadoDTO.getDni();
		LocalDate fecha=empleadoDTO.getBornDate();
	
		
		empleado=new Empleado(username,password,name,puntaje,surname,phone,dni,fecha);
		//empleadoDTO.setUsername(empleado.getUsername());
		//empleadoDTO.setPassword(empleado.getPassword());
		
		//empleadoDTO.setName(empleado.getName());
		//empleadoDTO.setType(empleado.getType());
		//empleadoDTO.setPuntaje(empleado.getPuntaje());
		
		//empleadoDTO.setSurname(empleado.getSurname());
		//empleadoDTO.setPhone(empleado.getPhone());
		//empleadoDTO.setDni(empleado.getDNI());
		//empleadoDTO.setBornDate(empleado.getBornDate());
		
		
		return empleado;
	}
	

}
