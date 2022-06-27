/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author JeroJimenez
 */
public class CancelarState implements IStateTicket {
    private Ticket ticket;

    public CancelarState(Ticket ticket) {
        this.ticket = ticket;
    }
    

    @Override
    public void activar() {
        //this.ticket.setState(new ActivoState(this.ticket));
    }

    @Override
    public void pausar() {
       // this.ticket.setState(new PausaState(this.ticket));
    
    }

    @Override
    public void cancelar() {
        throw new UnsupportedOperationException("El estado del ticket es cancelado."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void finalizar() {
        //this.ticket.setState(new FinalizarState(this.ticket));
    }
    @Override
    public String toString() {
        return "cancelado";
    }
    
    
}
