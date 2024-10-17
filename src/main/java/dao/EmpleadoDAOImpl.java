package dao;

import config.Conexion;
import dao.implement.EmpleadoDao;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import modelos.Empleado;

public class EmpleadoDAOImpl implements EmpleadoDao {
    
    @Override
    public void insertarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO Empleado (nombres, apellidos, direccion, fechaNacimiento, correo, sexo, tipoDocumento, numeroDocumento, telefono, estadoCivil, informacionAdicional, fechaInicio, fechaFin, departamento, salario, cargo, estadoLaboral, metodoPago, ultimaEmpresa, anosExperiencia, comunicacion, analisis, trabajoEquipo, resolucionProblemas, liderazgo, adaptabilidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, empleado.getNombres());
            pst.setString(2, empleado.getApellidos());
            pst.setString(3, empleado.getDireccion());
            
            if (empleado.getFechaNacimiento() != null) {
                pst.setDate(4, new java.sql.Date(empleado.getFechaNacimiento().getTime()));
            } else { pst.setDate(4, null); }
            
            pst.setString(5, empleado.getCorreo());
            pst.setString(6, empleado.getSexo());
            pst.setString(7, empleado.getTipoDocumento());
            pst.setString(8, empleado.getNumeroDocumento());
            pst.setString(9, empleado.getTelefono());
            pst.setString(10, empleado.getEstadoCivil());
            pst.setString(11, empleado.getInformacionAdicional());
            
            if (empleado.getFechaInicio() != null) {
                pst.setDate(12, new java.sql.Date(empleado.getFechaInicio().getTime()));
            } else { pst.setDate(12, null); }

            if (empleado.getFechaFin() != null) {
                pst.setDate(13, new java.sql.Date(empleado.getFechaFin().getTime()));
            } else { pst.setDate(13, null); }
            
            pst.setString(14, empleado.getDepartamento());
            pst.setDouble(15, empleado.getSalario());
            pst.setString(16, empleado.getCargo());
            pst.setString(17, empleado.getEstadoLaboral());
            pst.setString(18, empleado.getMetodoPago());
            pst.setString(19, empleado.getUltimaEmpresa());
            pst.setInt(20, empleado.getAnosExperiencia());
            pst.setBoolean(21, empleado.isComunicacion());
            pst.setBoolean(22, empleado.isAnalisis());
            pst.setBoolean(23, empleado.isTrabajoEquipo());
            pst.setBoolean(24, empleado.isResolucionProblemas());
            pst.setBoolean(25, empleado.isLiderazgo());
            pst.setBoolean(26, empleado.isAdaptabilidad());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void actualizarEmpleado(Empleado empleado) {
        String sql = "UPDATE Empleado SET nombres = ?, apellidos = ?, direccion = ?, fechaNacimiento = ?, correo = ?, sexo = ?, tipoDocumento = ?, numeroDocumento = ?, telefono = ?, estadoCivil = ?, informacionAdicional = ?, fechaInicio = ?, fechaFin = ?, departamento = ?, salario = ?, cargo = ?, estadoLaboral = ?, metodoPago = ?, ultimaEmpresa = ?, anosExperiencia = ?, comunicacion = ?, analisis = ?, trabajoEquipo = ?, resolucionProblemas = ?, liderazgo = ?, adaptabilidad = ? WHERE idEmpleado = ?";
        try (Connection con = Conexion.getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, empleado.getNombres());
            pst.setString(2, empleado.getApellidos());
            pst.setString(3, empleado.getDireccion());
            if (empleado.getFechaNacimiento() != null) {
                pst.setDate(4, new java.sql.Date(empleado.getFechaNacimiento().getTime()));
            } else { pst.setDate(4, null); }
            pst.setString(5, empleado.getCorreo());
            pst.setString(6, empleado.getSexo());
            pst.setString(7, empleado.getTipoDocumento());
            pst.setString(8, empleado.getNumeroDocumento());
            pst.setString(9, empleado.getTelefono());
            pst.setString(10, empleado.getEstadoCivil());
            pst.setString(11, empleado.getInformacionAdicional());
            if (empleado.getFechaInicio() != null) {
                pst.setDate(12, new java.sql.Date(empleado.getFechaInicio().getTime()));
            } else { pst.setDate(12, null); }

            if (empleado.getFechaFin() != null) {
                pst.setDate(13, new java.sql.Date(empleado.getFechaFin().getTime()));
            } else { pst.setDate(13, null); }
            pst.setString(14, empleado.getDepartamento());
            pst.setDouble(15, empleado.getSalario());
            pst.setString(16, empleado.getCargo());
            pst.setString(17, empleado.getEstadoLaboral());
            pst.setString(18, empleado.getMetodoPago());
            pst.setString(19, empleado.getUltimaEmpresa());
            pst.setInt(20, empleado.getAnosExperiencia());
            pst.setBoolean(21, empleado.isComunicacion());
            pst.setBoolean(22, empleado.isAnalisis());
            pst.setBoolean(23, empleado.isTrabajoEquipo());
            pst.setBoolean(24, empleado.isResolucionProblemas());
            pst.setBoolean(25, empleado.isLiderazgo());
            pst.setBoolean(26, empleado.isAdaptabilidad());
             pst.setInt(27, empleado.getIdEmpleado());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void eliminarEmpleado(int idEmpleado) {
        String sql = "DELETE FROM Empleado WHERE idEmpleado = ?";
        try (Connection con = Conexion.getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idEmpleado);
            int filasAfectadas = pst.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Empleado eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún empleado con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Empleado obtenerEmpleadoPorId(int idEmpleado) {
        String sql = "SELECT * FROM Empleado WHERE idEmpleado = ?";
        try (Connection con = Conexion.getConexion(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idEmpleado);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Empleado empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                    empleado.setNombres(rs.getString("nombres"));
                    empleado.setApellidos(rs.getString("apellidos"));
                    empleado.setDireccion(rs.getString("direccion"));
                    empleado.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    empleado.setCorreo(rs.getString("correo"));
                    empleado.setSexo(rs.getString("sexo"));
                    empleado.setTipoDocumento(rs.getString("tipoDocumento"));
                    empleado.setNumeroDocumento(rs.getString("numeroDocumento"));
                    empleado.setTelefono(rs.getString("telefono"));
                    empleado.setEstadoCivil(rs.getString("estadoCivil"));
                    empleado.setInformacionAdicional(rs.getString("informacionAdicional"));
                    empleado.setFechaInicio(rs.getDate("fechaInicio"));
                    empleado.setFechaFin(rs.getDate("fechaFin"));
                    empleado.setDepartamento(rs.getString("departamento"));
                    empleado.setSalario(rs.getDouble("salario"));
                    empleado.setCargo(rs.getString("cargo"));
                    empleado.setEstadoLaboral(rs.getString("estadoLaboral"));
                    empleado.setMetodoPago(rs.getString("metodoPago"));
                    empleado.setUltimaEmpresa(rs.getString("ultimaEmpresa"));
                    empleado.setAnosExperiencia(rs.getInt("anosExperiencia"));
                    empleado.setComunicacion(rs.getBoolean("comunicacion"));
                    empleado.setAnalisis(rs.getBoolean("analisis"));
                    empleado.setTrabajoEquipo(rs.getBoolean("trabajoEquipo"));
                    empleado.setResolucionProblemas(rs.getBoolean("resolucionProblemas"));
                    empleado.setLiderazgo(rs.getBoolean("liderazgo"));
                    empleado.setAdaptabilidad(rs.getBoolean("adaptabilidad"));
                    return empleado;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT idEmpleado, nombres, apellidos, correo, telefono, salario FROM Empleado";
        
        try (Connection con = Conexion.getConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setNombres(rs.getString("nombres"));
                empleado.setApellidos(rs.getString("apellidos"));
                empleado.setCorreo(rs.getString("correo"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setSalario(rs.getDouble("salario"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }
    
    @Override
    public void soloNcarc (int numcarac, JTextField tf, KeyEvent e){
        if (tf.getText().length() >= numcarac){
            e.consume();
        }
    }
    
    @Override
    public void soloTodosNum (KeyEvent e){
        char c = e.getKeyChar();
        if (c < 48 || c > 57){
            e.consume();
        }
    }
}
