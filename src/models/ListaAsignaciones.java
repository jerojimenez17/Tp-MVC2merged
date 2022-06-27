package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaAsignaciones implements Serializable{
    private List<Entrevista> list = new ArrayList<>();
    private LocalDate fecha;

    public ListaAsignaciones(List<Entrevista> list, LocalDate fecha) {
        this.list = list;
        this.fecha = fecha;
    }
    public ListaAsignaciones() {
    	this.list= new ArrayList<>();
	}
	public List<Entrevista> getList(){
    	return this.list;
    }
   
    @Override
    public String toString() { 
    	return "Lista de Asignaciones realizada " + fecha + "\n" + list.toString();
    }
}
