package Modelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ListadoVentas {
    private Date fecha;
    private String comercial;
    private int cantidad;
    private double precio;
    private int descuento;
    
    public ListadoVentas() {
        this.fecha = null;
        this.comercial = null;
        this.cantidad = 0;
        this.precio = 0.0;
        this.descuento = 0;
    }

    public ListadoVentas(Date fecha, String comercial, int cantidad, double precio, int descuento) throws ParseException {
        setFecha(fecha);
        setComercial(comercial);
        setCantidad(cantidad);
        setPrecio(precio);
        setDescuento(descuento);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    
    
}
