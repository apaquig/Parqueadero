package DAO;

import conexion.Conexion;
import entidadesNegocio.TicketEN;
import entidadesNegocio.VehiculoEN;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class TicketDAO {

    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion con;
    Date f = new Date();
    Mensaje m = new Mensaje();

    public TicketDAO() {
        con = new Conexion();
    }

    public boolean registrar(TicketEN ticket) {
        boolean bandera = false;
        try {
            String sql = "INSERT INTO Ticket (numeroTicket, horaEntrada, horaSalida, Vehiculo_idVehiculo) VALUES(?,?,?,?)";
            ps = con.getConexion().prepareStatement(sql);
            ps.setString(1, ticket.getNumeroTicket());
            ps.setString(2, ticket.getHoraEntrada());
            ps.setString(3, ticket.getHoraSalida());
            ps.setInt(4, ticket.getVeh().getVehiculoId());
            if (ps.executeUpdate() > 0) {
                bandera = true;
            }
        } catch (SQLException e) {
            m.setMensaje(e.getLocalizedMessage());
        }
        return bandera;
    }

    public boolean actualizar(TicketEN ticket) {
        boolean bandera = false;
        try {
            String sql = "UPDATE Ticket SET numeroTicket=?, horaEntrada=?, horaSalida=?, Vehiculo_idVehiculo=? WHERE idTicket='" + ticket.getTicketId() + "'";
            ps = con.getConexion().prepareStatement(sql);
            ps.setString(1, ticket.getNumeroTicket());
            ps.setString(2, ticket.getHoraEntrada());
            ps.setString(3, ticket.getHoraSalida());
            ps.setInt(4, ticket.getVeh().getVehiculoId());
            if (ps.executeUpdate() > 0) {
                bandera = true;
            }
        } catch (SQLException e) {
            m.setMensaje(e.getMessage());
        }
        return bandera;
    }

    public DefaultTableModel listaTicket() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NUMERO");
        modelo.addColumn("HORA ENTRADA");
        modelo.addColumn("HORA SALIDA");
        modelo.addColumn("PLACA");
        try {
            String sql = "SELECT idTicket,numeroTicket,horaEntrada,horaSalida,placa FROM Vehiculo  INNER JOIN Ticket on Vehiculo_idVehiculo=idVehiculo;";
            ps = con.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object datos[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                modelo.addRow(datos);
            }
            ps.close();
            con.desconectar();
        } catch (Exception e) {
        }
        return modelo;
    }

    public TicketEN buscarTicket(int codigo) {
        TicketEN ticket = new TicketEN();
        try {
            String sql = "SELECT idTicket, numeroTicket, horaEntrada, horaSalida, placa FROM Ticket inner join Vehiculo on Vehiculo_idVehiculo=idVehiculo and idTicket='" + codigo + "';";
            ps = con.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ticket.setTicketId(rs.getInt(1));
                ticket.setNumeroTicket(rs.getString(2));
                ticket.setHoraEntrada(rs.getString(3));
                ticket.setHoraSalida(rs.getString(4));
                VehiculoDAO v = new VehiculoDAO();
                VehiculoEN ve = v.buscarVehiculo(rs.getString(5));
                ticket.setVeh(ve);
            }
            ps.close();
            con.desconectar();
        } catch (Exception e) {
        }
        return ticket;
    }
public boolean eliminarTicket(int codigo){
boolean bandera=false;
    try {
        String sql="DELETE from Ticket WHERE idTicket='"+codigo+"'";
        ps=con.getConexion().prepareStatement(sql);
        if(ps.executeUpdate()>0){
        bandera=true;
        }
    } catch (SQLException e) {
        m.setMensaje("Error "+e.getMessage());
    }
return bandera;
}
}
