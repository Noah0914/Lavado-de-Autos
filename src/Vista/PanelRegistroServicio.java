/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorRegistro;
import Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 *
 * @author niday
 */
public class PanelRegistroServicio extends javax.swing.JFrame {

    
    public PanelRegistroServicio() {
        initComponents();
    }

    private JTextField txtPlaca, txtNombreFuncionario, txtCedulaFuncionario;
    private JComboBox<String> cbTipoVehiculo, cbTipoServicio;
    private JButton btnRegistrar;

    private ControladorRegistro controlador;

    public PanelRegistroServicio(ControladorRegistro controlador) {
        this.controlador = controlador;

        setTitle("Registro de Servicio - Centro de Lavado");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        panel.add(new JLabel("Tipo de Vehículo:"));
        cbTipoVehiculo = new JComboBox<>(new String[]{"automovil", "camioneta"});
        panel.add(cbTipoVehiculo);

        panel.add(new JLabel("Placa:"));
        txtPlaca = new JTextField();
        panel.add(txtPlaca);

        panel.add(new JLabel("Tipo de Servicio:"));
        cbTipoServicio = new JComboBox<>(new String[]{
            "Lavado Básico", "Lavado Especial", "Desinfección Básica", "Desinfección Avanzada",
            "Combo 1", "Combo 2", "Combo 3"
        });
        panel.add(cbTipoServicio);

        panel.add(new JLabel("Nombre Funcionario:"));
        txtNombreFuncionario = new JTextField();
        panel.add(txtNombreFuncionario);

        panel.add(new JLabel("Cédula Funcionario:"));
        txtCedulaFuncionario = new JTextField();
        panel.add(txtCedulaFuncionario);

        btnRegistrar = new JButton("Registrar Servicio");
        btnRegistrar.addActionListener(this::registrarServicio);
        panel.add(btnRegistrar);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void registrarServicio(ActionEvent e) {
        String tipoVehiculo = cbTipoVehiculo.getSelectedItem().toString();
        String placa = txtPlaca.getText().trim();
        String tipoServicio = cbTipoServicio.getSelectedItem().toString();
        String nombreFunc = txtNombreFuncionario.getText().trim();
        String cedulaFunc = txtCedulaFuncionario.getText().trim();

        if (placa.isEmpty() || nombreFunc.isEmpty() || cedulaFunc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
            return;
        }else{

        Vehiculo vehiculo = new Vehiculo(placa, tipoVehiculo);
        Funcionario funcionario = new Funcionario(nombreFunc, cedulaFunc);
        Servicio servicio = crearServicio(tipoServicio);
        Date fecha = new Date();

        controlador.registrarServicio(funcionario, vehiculo, servicio, fecha);
        JOptionPane.showMessageDialog(this, "Servicio registrado exitosamente.");
        limpiarCampos();
        }
    }

    private Servicio crearServicio(String nombre) {
        switch (nombre) {
            case "Lavado Básico": return new LavadoBasico();
            case "Lavado Especial": return new LavadoEspecial();
            case "Desinfección Básica": return new DesinfeccionBasica();
            case "Desinfección Avanzada": return new DesinfeccionAvanzada();
            case "Combo 1": return new Combo1();
            case "Combo 2": return new Combo2();
            case "Combo 3": return new Combo3();
            default: return null;
        }
    }

    private void limpiarCampos() {
        txtPlaca.setText("");
        txtNombreFuncionario.setText("");
        txtCedulaFuncionario.setText("");
        cbTipoVehiculo.setSelectedIndex(0);
        cbTipoServicio.setSelectedIndex(0);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
