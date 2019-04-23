package DAO;

import conexion.Conexion;
import entidadesNegocio.VehiculoEN;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class VehiculoDAO {

    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion con;
    private Mensaje me;
    public VehiculoDAO() {
        con = new Conexion();
        me=new Mensaje();
    }

    public boolean gauradarVehiculos(VehiculoEN vehiculo) {
        boolean bandera = false;
        String sql = "INSERT INTO Vehiculo (placa,color,marca,modelo, tipo) VALUES(?,?,?,?,?)";
        try {
            ps = con.getConexion().prepareStatement(sql);
            ps.setString(1, vehiculo.getVehiculoPlaca());
            ps.setString(2, vehiculo.getVehiculoColor());
            ps.setString(3, vehiculo.getVehiculoMarca());
            ps.setString(4, vehiculo.getHeviculoModelo());
            ps.setString(5, vehiculo.getVehiculoTipo());
            if(ps.executeUpdate()>0){
            bandera=true;
            }
            ps.close();
            con.getConexion();
        } catch (SQLException e) {
            me.setMensaje(e.getMessage());
        }
        return bandera;
    }
    public boolean actualizar(VehiculoEN vehiculo) {
        boolean bandera = false;
        String sql = "UPDATE Vehiculo SET placa=?,color=?,marca=?,modelo=?, tipo=? WHERE idVehiculo='"+vehiculo.getVehiculoId()+"'";
        try {
            ps = con.getConexion().prepareStatement(sql);
            ps.setString(1, vehiculo.getVehiculoPlaca());
            ps.setString(2, vehiculo.getVehiculoColor());
            ps.setString(3, vehiculo.getVehiculoMarca());
            ps.setString(4, vehiculo.getHeviculoModelo());
            ps.setString(5, vehiculo.getVehiculoTipo());
            if(ps.executeUpdate()>0){
            bandera=true;
            }
            ps.close();
            con.getConexion();
        } catch (SQLException e) {
            me.setMensaje(e.getMessage());
        }
        return bandera;
    }
 public DefaultTableModel listaVehiculo(){
    DefaultTableModel model=new DefaultTableModel();
    model.addColumn("CODIGO");
    model.addColumn("PLACA");
    model.addColumn("COLOR");
    model.addColumn("MARCA");
    model.addColumn("MODELO");
    model.addColumn("TIPO");
        try {
            String sql="SELECT * FROM Vehiculo";
            ps=con.getConexion().prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Object data[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6)};
                model.addRow(data);
            }
        } catch (SQLException e) {
            me.setMensaje(e.getMessage());
        }
    return model;
    }
 public VehiculoEN buscarVehiculo(String placa){
    VehiculoEN veh=new VehiculoEN();
        try {
            String sql="SELECT * FROM Vehiculo WHERE placa='"+placa+"'";
            ps=con.getConexion().prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                veh.setVehiculoId(rs.getInt(1));
                veh.setVehiculoPlaca(rs.getString(2));
                veh.setVehiculoColor(rs.getString(3));
                veh.setVehiculoMarca(rs.getString(4));
                veh.setHeviculoModelo(rs.getString(5));
                veh.setVehiculoTipo(rs.getString(6));
            }
            ps.close();
            con.desconectar();
        } catch (SQLException e) {
            me.setMensaje(e.getMessage());
        }
    return veh;
    }
 public boolean eliminarVehiculo(int codigo){
 boolean bandera=false;
     try {
         String sql="DELETE FROM Vehiculo WHERE idVehiculo='"+codigo+"';";
         ps=con.getConexion().prepareStatement(sql);
         if(ps.executeUpdate()>0){
          bandera=true;
         }
         ps.close();
         con.desconectar();
     } catch (SQLException e) {
         me.setMensaje(e.getLocalizedMessage());
     }
 return bandera;
 }
}
