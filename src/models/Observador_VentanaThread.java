/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Observer;

/**
 *
 * @author JeroJimenez
 */
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Observador_VentanaThread extends JFrame implements Observer {

    private JTextArea area = new JTextArea();
    protected ArrayList<Usuario> observados = new ArrayList<Usuario>();

    public Observador_VentanaThread() {
        JScrollPane scroll = new JScrollPane(area);
        this.getContentPane().add(scroll);
        this.setVisible(true);
        this.setSize(new Dimension(600, 600));

    }

    public void agregarObservable(Usuario observable) {
        observable.addObserver(this);
        this.observados.add(observable);
    }

    public void borrarObservable(Usuario observable) {
        observable.deleteObserver(this);
        this.observados.remove(observable);
    }

    @Override
    public void update(Observable o, Object arg) {
        Usuario observable = (Person) o;
        if (this.observados.contains(o)) {
            if (arg == null) {
                this.area
                        .append("\n" + o.toString() + "\nConsumio el ticket\n");
            } else {
                this.area.append("\n" + o.toString() + "\nCreo el ticket: " + arg + "\n");

            }

        } else
            throw new IllegalArgumentException();

    }

}
