package objetoNegocio;

import DAO.Mensaje;
import DAO.TicketDAO;
import entidadesNegocio.TicketEN;
import entidadesNegocio.VehiculoEN;
import javax.swing.table.DefaultTableModel;

public class TicketON {

    Mensaje me = new Mensaje();
    TicketDAO ticket = new TicketDAO();

    public void registrar(String numero, String horaEntrada, String horaSalida, VehiculoEN veh) {
        if (ticket.registrar(new TicketEN(numero, horaEntrada, horaSalida, veh))) {
            me.setMensaje("Registrado correctamente");
        } else {
            me.setMensaje("Error al registrar ticke");
        }
    }

    public DefaultTableModel listaTicket() {
        return ticket.listaTicket();
    }
    public void modificar(int cod,String numero,String horaE, String horaS,VehiculoEN ve){
    if(ticket.actualizar(new TicketEN(cod, numero, horaE, horaS, ve))){
    me.setMensaje("Modificado correctamente");
    }
    
    }
    public TicketEN buscarTicket(int c){
    return ticket.buscarTicket(c);
    }
    public void eliminarTicket(int c){
    if(ticket.eliminarTicket(c)){
    me.setMensaje("Eliminado correctamente");
    }
    }
}
