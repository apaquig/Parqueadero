/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class Mensaje {

    private String mensaje;

    public Mensaje() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
        mostrarMensaje();
    }

    private void mostrarMensaje() {
        JOptionPane.showMessageDialog(null, getMensaje());

    }

}
