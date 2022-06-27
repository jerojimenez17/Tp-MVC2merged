/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;

/**
 *
 * @author JeroJimenez
 */
public interface IStateTicket extends Serializable {
   public void activar();
   public void pausar();
   public void cancelar();
   public void finalizar();
   public String toString();
}
