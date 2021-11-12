package Modelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Comerciales {
    private String codigo;
    private String nombre;
    private double salario;
    private int hijos;
    private Date fNacimiento;
    
    public Comerciales() {
        this.codigo = null;
        this.nombre = null;
        this.salario = 0.0;
        this.hijos = 0;
        this.fNacimiento = null;
    }
    
    public Comerciales(String codigo, String nombre, double salario, int hijos, String fNacimiento) throws ParseException {
        setCodigo(codigo);
        setNombre(nombre);
        setSalario(salario);
        setHijos(hijos);
        setfNacimiento(fNacimiento);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) throws ParseException {
        java.util.Date fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        fecha = sdf.parse(fNacimiento);
        this.fNacimiento = new Date(fecha.getTime());
    }
    
    
}
