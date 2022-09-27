package Models;

import java.time.LocalDateTime;

public class Alquiler {
    private String documentoCliento;
    private String placaAutomovil;
    private LocalDateTime fecha;
    private String dias;

    public Alquiler() {}

    public Alquiler(String documentoCliento, String placaAutomovil, LocalDateTime fecha, String dias) {
        this.documentoCliento = documentoCliento;
        this.placaAutomovil = placaAutomovil;
        this.fecha = fecha;
        this.dias = dias;
    }

    public String getDocumentoCliente() {
        return documentoCliento;
    }

    public void setDocumentoCliente(String documentoCliento) {
        this.documentoCliento = documentoCliento;
    }

    public String getPlacaAutomovil() {
        return placaAutomovil;
    }

    public void setPlacaAutomovil(String placaAutomovil) {
        this.placaAutomovil = placaAutomovil;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
}
