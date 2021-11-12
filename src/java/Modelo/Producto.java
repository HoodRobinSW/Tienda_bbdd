package Modelo;

public class Producto {
    private String referencia;
    private String nombre;
    private String descripcion;
    private double precio;
    private int descuento;

    public Producto() {
        this.referencia = null;
        this.nombre = null;
        this.descripcion = null;
        this.precio = 0.0;
        this.descuento = 0;
    }
    
    public Producto(String referencia, String nombre, String descripcion, double precio, int descuento) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Producto{" + "referencia=" + referencia + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", descuento=" + descuento + '}';
    }
    
}
