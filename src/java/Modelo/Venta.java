package Modelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Venta {
    private String codComercial;
    private String refProducto;
    private int cantidad;
    private Date fecha;
    
    public Venta() {
        this.codComercial = null;
        this.refProducto = null;
        this.cantidad = 0;
        this.fecha = null;
    }

    public Venta(String codComercial, String refProducto, int cantidad, String fecha) throws ParseException {
        setCodComercial(codComercial);
        setRefProducto(refProducto);
        setCantidad(cantidad);
        setFecha(fecha);
    }

    public String getCodComercial() {
        return codComercial;
    }

    public void setCodComercial(String codComercial) {
        this.codComercial = codComercial;
    }

    public String getRefProducto() {
        return refProducto;
    }

    public void setRefProducto(String refProducto) {
        this.refProducto = refProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) throws ParseException {
        java.util.Date fechaUtil = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        fechaUtil = sdf.parse(fecha);
        this.fecha = new Date(fechaUtil.getTime());
    }
}
