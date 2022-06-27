/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author JeroJimenez
 */
public class PausaState implements IStateTicket {
    
    private Ticket ticket;
    
      public PausaState(Ticket ticket) {
          this.ticket=ticket;
    }

    @Override
    public void activar() {
        this.ticket.setState(new ActivoState(this.ticket));
    }

    @Override
    public void pausar() {
        throw new UnsupportedOperationException("El ticket ya esta pausado");
    }

    @Override
    public void cancelar() {
        ticket.setState(new CancelarState(this.ticket));
    }

    @Override
    public void finalizar() {
        ticket.setState(new FinalizarState(this.ticket));
    }
    @Override
    public String toString() {
        return "pausado";
    }
    

  
    
}
