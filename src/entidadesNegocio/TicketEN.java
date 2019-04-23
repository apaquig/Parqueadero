package entidadesNegocio;
import java.sql.Timestamp;

public class TicketEN {

    private int ticketId;
    private String numeroTicket;
    private String horaEntrada;
    private String horaSalida;
    private VehiculoEN veh;

    public TicketEN() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public VehiculoEN getVeh() {
        return veh;
    }

    public void setVeh(VehiculoEN veh) {
        this.veh = veh;
    }

    public TicketEN(String numeroTicket, String horaEntrada, String horaSalida, VehiculoEN veh) {
        this.numeroTicket = numeroTicket;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.veh = veh;
    }

    public TicketEN(int ticketId, String numeroTicket, String horaEntrada, String horaSalida, VehiculoEN veh) {
        this.ticketId = ticketId;
        this.numeroTicket = numeroTicket;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.veh = veh;
    }

    @Override
    public String toString() {
        return "TicketEN{" + "ticketId=" + ticketId + ", numeroTicket=" + numeroTicket + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", veh=" + veh + '}';
    }

   

}
