/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.t13.empleados;

import com.toedter.calendar.JDateChooser;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Pietro
 */
public class T13Empleados {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JCalendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Crear un componente JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        frame.add(dateChooser);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
