/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.implement;

import config.Conexion;
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

/**
 *
 * @author Alumno
 */
public interface EmpleadoDao  {
    public void insertarEmpleado(Empleado empleado)     ;
    
    public void actualizarEmpleado(Empleado empleado) ;
    
    public void eliminarEmpleado(int idEmpleado) ;
    
    public Empleado obtenerEmpleadoPorId(int idEmpleado);
    
    public List<Empleado> obtenerTodosLosEmpleados() ;
    
    public void soloNcarc(int numcarac, JTextField tf, KeyEvent e);
    
     public void soloTodosNum (KeyEvent e);
}
