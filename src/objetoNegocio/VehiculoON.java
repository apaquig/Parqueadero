package objetoNegocio;

import DAO.Mensaje;
import DAO.VehiculoDAO;
import entidadesNegocio.VehiculoEN;
import javax.swing.table.DefaultTableModel;

public class VehiculoON {

    Mensaje m = new Mensaje();
    VehiculoDAO veh = new VehiculoDAO();

    public void agregarVehiculo(String placa, String color, String marca, String modelo, String tipo) {
        if (veh.gauradarVehiculos(new VehiculoEN(placa, color, marca, modelo, tipo))) {
            m.setMensaje("Registrado correctamente");
        }

    }

    public void actualizar(int codigo, String placa, String color, String marca, String modelo, String tipo) {
        if (veh.actualizar(new VehiculoEN(codigo, placa, color, marca, modelo, tipo))) {
            m.setMensaje("Modificado corecctamente");
        }
    }

    public DefaultTableModel listaVehiculo() {
        return veh.listaVehiculo();
    }

    public VehiculoEN buscarVehiculo(String placa) {
        return veh.buscarVehiculo(placa);
    }

    public void elimianrVehiculo(int codigo) {
        if(veh.eliminarVehiculo(codigo)){
        m.setMensaje("Eliminado correctamente");
        }
    }
}
