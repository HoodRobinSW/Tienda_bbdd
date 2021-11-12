package DAO;

import Modelo.Comerciales;
import Modelo.ListadoVentas;
import Modelo.Producto;
import Modelo.Usuario;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bd {
        private static String usuario="alejdnxu";
        private static String password="hFWucoCz1K26";
        private static String servidor="localhost:3306";
        private static String basedatos="ventas_comerciales";
        
    public static Connection CrearConexion() {
        Connection cnn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //invocamos al driver
            String url = "jdbc:mysql://" + servidor + "/" + basedatos;
            cnn = DriverManager.getConnection(url, usuario, password); //nos conectamos a la BD
        } catch (ClassNotFoundException c) {
            System.out.println("Controlador JDBC no encontrado"+c.toString());   
        } catch (SQLException ex) {
            System.out.println("Fallo en la conexion"+ex.toString()); 
        }
        return cnn;
    }
    
    public static ArrayList<Usuario> getUsuarios() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = null;
        Connection conn = CrearConexion();
        String sql = "SELECT * FROM usuario";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usuario = new Usuario(rs.getString(2), rs.getString(3));
            usuarios.add(usuario);
            usuario = null;
        }
        
        return usuarios;
    }
    
    public static ArrayList<Producto> getListaPodructos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM productos;";
        Connection conn = CrearConexion();
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Producto p = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
                    listaProductos.add(p);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return listaProductos;
    }
    
    public static ArrayList<ListadoVentas> getListadoVentas(String producto) throws SQLException, ParseException {
        ArrayList<ListadoVentas> listadoVentas = new ArrayList<>();
        Connection conn = CrearConexion();
        ListadoVentas lv = null;
        String sql = "SELECT ventas.fecha, comerciales.nombre, ventas.cantidad, "+
                "productos.precio, productos.descuento FROM productos, ventas, comerciales WHERE "+
                "ventas.refProducto = productos.referencia AND comerciales.codigo = ventas.codComercial "+
                "AND productos.nombre = '"+producto+"';";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lv = new ListadoVentas(rs.getDate(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5));
            listadoVentas.add(lv);
            lv = null;
        }
        
        return listadoVentas;
    }
    
    public static ArrayList<Comerciales> getListaComerciales() throws SQLException, ParseException {
        ArrayList<Comerciales> listadoComerciales = new ArrayList<>();
        Connection conn = CrearConexion();
        Comerciales c = null;
        String sql = "SELECT * FROM comerciales";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           c = new Comerciales(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
           listadoComerciales.add(c);
           c = null;
        }
        
        return listadoComerciales;
    }
        
    public static void insertarVenta(String producto, String comercial, int cantidad, String fecha) throws SQLException, ParseException {
        Connection conn = CrearConexion();
        String sql = "SELECT productos.referencia, comerciales.codigo FROM productos, comerciales "+
                "WHERE productos.nombre = '"+producto+"' AND comerciales.nombre = '"+comercial+"';";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String refProducto = rs.getString(1);
        String codComercial = rs.getString(2);
        
        Venta v = new Venta(codComercial, refProducto, cantidad, fecha);
        
        sql = "INSERT INTO ventas VALUES(?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, v.getCodComercial());
        ps.setString(2, v.getRefProducto());
        ps.setInt(3, v.getCantidad());
        ps.setDate(4, v.getFecha());
        ps.executeUpdate();
    }
    
    public static void insertarProducto(Producto producto) throws SQLException {
        Connection conn = CrearConexion();
        String sql = "INSERT INTO productos VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producto.getReferencia());
        ps.setString(2, producto.getNombre());
        ps.setString(3, producto.getDescripcion());
        ps.setDouble(4, producto.getPrecio());
        ps.setInt(5, producto.getDescuento());
        ps.executeUpdate();
    }
    
    public static void modificarProducto(Producto producto) throws SQLException {
        Connection conn = CrearConexion();
        String sql = "UPDATE productos SET nombre = '"+producto.getNombre()+
                "', descripcion = '"+producto.getDescripcion()+"', precio = '"+
                producto.getPrecio()+"', descuento = '"+producto.getDescuento()+"' "+
                "WHERE referencia = '"+producto.getReferencia()+"';";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }
    
    public static void insertarComercial(Comerciales comercial) throws SQLException {
        Connection conn = CrearConexion();
        String sql = "INSERT INTO comerciales VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, comercial.getCodigo());
        ps.setString(2, comercial.getNombre());
        ps.setDouble(3, comercial.getSalario());
        ps.setInt(4, comercial.getHijos());
        ps.setDate(5, comercial.getfNacimiento());
        ps.executeUpdate();
    }

}