package Models;

public class Automovil {
    private String marca;
    private String linea;
    private String placa;
    private String estado;

    public Automovil() {}

    public Automovil(String marca, String linea, String placa, String estado) {
        this.marca = marca;
        this.linea = linea;
        this.placa = placa;
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
