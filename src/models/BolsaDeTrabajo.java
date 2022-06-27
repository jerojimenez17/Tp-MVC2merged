/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JeroJimenez
 */
public class BolsaDeTrabajo {

    private boolean available = false;
    private List<TicketSimplificado> ticketsSimplificados;

    public synchronized void addTicket(TicketSimplificado ts) {
        // System.out.println("agrego si available es false, avalable es " + available);
        // while (available == true) {
        // try {
        // wait();
        // } catch (InterruptedException e) {
        // System.out.println(e.getMessage());
        // }
        // }
        this.ticketsSimplificados.add(ts);
        available = true;
        notifyAll();

    }

    public BolsaDeTrabajo() {
        this.ticketsSimplificados = new ArrayList<>();
    }

    public synchronized TicketSimplificado removeTicket(int eleccionLocacion, int eleccionTicket) {

        // System.out.println("remove si available es true, avalable es " + available);
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        TicketSimplificado ts = this.ticketsSimplificados.get(eleccionTicket);
        if (eleccionLocacion == ts.getEleccionLocacion()) {
            available = false;
            this.ticketsSimplificados.remove(eleccionTicket);
            notifyAll();
            return ts;
        } else {
            available = false;
            notifyAll();
            return null;

        }
    }

    public synchronized List<TicketSimplificado> getListTicketsSimpl() {
        return this.ticketsSimplificados;
    }

}
