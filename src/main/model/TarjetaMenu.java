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
    private float ccb;

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
        this.ccb = this.calcular(constante,variable,cantidadUsuarios);
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

    public Float calcular(double cf, double cv, int nb){

        Float MERMA = 0.2f;
        Float ccb = null;
        
        ccb = (float)((cf + cv)/nb);
        ccb = ccb * (1 + MERMA);

        ccb = Math.round(ccb * 100) / 100.0f;
   
        return ccb;
    }

    public float getCCB() {
        return ccb;
    }

    public void setCCB(float ccb){
        this.ccb = ccb;
    }


    public void setId(int i) {
        this.id=i;
    }
}