/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author JeroJimenez
 */
public class ActivoState implements IStateTicket{
    Ticket ticket;
    
    public ActivoState(Ticket ticket) {
        this.ticket = ticket;
    }
    
    
    @Override
    public void activar(){
        System.out.println("El ticket ya esta activo");
    }
    @Override 
    public void pausar(){
        this.ticket.setState(new PausaState(this.ticket));
    }



    @Override
    public void cancelar() {
        this.ticket.setState(new CancelarState(this.ticket));
    }

    @Override
    public void finalizar() {
        this.ticket.setState(new FinalizarState(this.ticket));
    }

    @Override
    public String toString() {
        return "activo";
    }
    
}
