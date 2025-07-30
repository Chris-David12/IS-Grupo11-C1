package main.model;

public class TarjetaMenu {
    private int id;
    private String tipo;
    private String fecha;
    private String horario;
    private String descripcion;
    private int cantidadUsuarios;
    private double constante;
    private double variable;

    public TarjetaMenu(int id, String tipo, String fecha, String horario, String descripcion,
            int cantidadUsuarios, double constante, double variable) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.horario = horario;
        this.descripcion = descripcion;
        this.cantidadUsuarios = cantidadUsuarios;
        this.constante = constante;
        this.variable = variable;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadUsuarios() {
        return cantidadUsuarios;
    }

    public void setCantidadUsuarios(int cantidadUsuarios) {
        this.cantidadUsuarios = cantidadUsuarios;
    }

    public double getConstante() {
        return constante;
    }

    public void setConstante(double constante) {
        this.constante = constante;
    }

    public double getVariable() {
        return variable;
    }

    public void setVariable(double variable) {
        this.variable = variable;
    }

    public double getCCB() {
        return constante + variable;
    }

    public void setId(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}