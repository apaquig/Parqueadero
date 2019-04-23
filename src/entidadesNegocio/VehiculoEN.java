package entidadesNegocio;

public class VehiculoEN {

    private int vehiculoId;
    private String vehiculoPlaca;
    private String vehiculoColor;
    private String vehiculoMarca;
    private String heviculoModelo;
    private String vehiculoTipo;

    public VehiculoEN() {
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getVehiculoPlaca() {
        return vehiculoPlaca;
    }

    public void setVehiculoPlaca(String vehiculoPlaca) {
        this.vehiculoPlaca = vehiculoPlaca;
    }

    public String getVehiculoColor() {
        return vehiculoColor;
    }

    public void setVehiculoColor(String vehiculoColor) {
        this.vehiculoColor = vehiculoColor;
    }

    public String getVehiculoMarca() {
        return vehiculoMarca;
    }

    public void setVehiculoMarca(String vehiculoMarca) {
        this.vehiculoMarca = vehiculoMarca;
    }

    public String getHeviculoModelo() {
        return heviculoModelo;
    }

    public void setHeviculoModelo(String heviculoModelo) {
        this.heviculoModelo = heviculoModelo;
    }

    public String getVehiculoTipo() {
        return vehiculoTipo;
    }

    public void setVehiculoTipo(String vehiculoTipo) {
        this.vehiculoTipo = vehiculoTipo;
    }

    public VehiculoEN(String vehiculoPlaca, String vehiculoColor, String vehiculoMarca, String heviculoModelo, String vehiculoTipo) {
        this.vehiculoPlaca = vehiculoPlaca;
        this.vehiculoColor = vehiculoColor;
        this.vehiculoMarca = vehiculoMarca;
        this.heviculoModelo = heviculoModelo;
        this.vehiculoTipo = vehiculoTipo;
    }

    public VehiculoEN(int vehiculoId, String vehiculoPlaca, String vehiculoColor, String vehiculoMarca, String heviculoModelo, String vehiculoTipo) {
        this.vehiculoId = vehiculoId;
        this.vehiculoPlaca = vehiculoPlaca;
        this.vehiculoColor = vehiculoColor;
        this.vehiculoMarca = vehiculoMarca;
        this.heviculoModelo = heviculoModelo;
        this.vehiculoTipo = vehiculoTipo;
    }

    @Override
    public String toString() {
        return "VehiculoEN{" + "vehiculoId=" + vehiculoId + ", vehiculoPlaca=" + vehiculoPlaca + ", vehiculoColor=" + vehiculoColor + ", vehiculoMarca=" + vehiculoMarca + ", heviculoModelo=" + heviculoModelo + ", vehiculoTipo=" + vehiculoTipo + '}';
    }


}
