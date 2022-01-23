package server;

public class Tarea {
    //Atributos
    private String descripcion;
    private String estado;

    //Constructor
    public Tarea(){
    	descripcion = "";
        estado = "";
    }

    //Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //ToString
    @Override
    public String toString() {
        return "Tarea{" +
                "descripción='" + descripcion +
                ", estado='" + estado +
                "}";
    }
}


