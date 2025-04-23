/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lavadodeautos;

import Controlador.ControladorRegistro;
import Modelo.RegistroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author niday
 */
public class PanelConsultaProduccion extends javax.swing.JFrame {

    
    public PanelConsultaProduccion() {
        initComponents();
    }

    private ControladorRegistro controlador;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private JTextField txtServicio, txtFuncionario, txtDesde, txtHasta;

    public PanelConsultaProduccion(ControladorRegistro controlador) {
        this.controlador = controlador;

        setTitle("Consulta de Producción");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());

        JPanel panelFiltros = new JPanel(new GridLayout(4, 3, 10, 10));

        txtServicio = new JTextField();
        JButton btnConsultarServicio = new JButton("Por Servicio");
        btnConsultarServicio.addActionListener(e -> consultarPorServicio());

        txtFuncionario = new JTextField();
        JButton btnConsultarFuncionario = new JButton("Por Funcionario");
        btnConsultarFuncionario.addActionListener(e -> consultarPorFuncionario());

        txtDesde = new JTextField("yyyy-MM-dd");
        txtHasta = new JTextField("yyyy-MM-dd");
        JButton btnConsultarFechas = new JButton("Por Rango de Fechas");
        btnConsultarFechas.addActionListener(e -> consultarPorFechas());

        panelFiltros.add(new JLabel("Servicio:"));
        panelFiltros.add(txtServicio);
        panelFiltros.add(btnConsultarServicio);

        panelFiltros.add(new JLabel("Cédula Funcionario:"));
        panelFiltros.add(txtFuncionario);
        panelFiltros.add(btnConsultarFuncionario);

        panelFiltros.add(new JLabel("Desde (yyyy-MM-dd):"));
        panelFiltros.add(txtDesde);
        panelFiltros.add(new JLabel("Hasta (yyyy-MM-dd):"));
        panelFiltros.add(txtHasta);
        panelFiltros.add(new JLabel());
        panelFiltros.add(btnConsultarFechas);

        add(panelFiltros, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"Fecha", "Servicio", "Funcionario", "Vehículo", "Costo"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    private void mostrarResultados(List<RegistroServicio> registros) {
        modeloTabla.setRowCount(0); // limpiar tabla
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (RegistroServicio r : registros) {
            modeloTabla.addRow(new Object[]{
                sdf.format(r.getFecha()),
                r.getServicio().getNombre(),
                r.getFuncionario().getNombre(),
                r.getVehiculo().getPlaca(),
                r.getCosto()
            });
        }
    }

    private void consultarPorServicio() {
        String nombre = txtServicio.getText().trim();
        if (nombre.isEmpty()) return;
        mostrarResultados(controlador.obtenerPorTipoServicio(nombre));
    }

    private void consultarPorFuncionario() {
        String cedula = txtFuncionario.getText().trim();
        if (cedula.isEmpty()) return;
        mostrarResultados(controlador.obtenerPorFuncionario(cedula));
    }

    private void consultarPorFechas() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date desde = sdf.parse(txtDesde.getText().trim());
            Date hasta = sdf.parse(txtHasta.getText().trim());
            mostrarResultados(controlador.obtenerPorRangoFechas(desde, hasta));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fechas inválidas. Usa formato yyyy-MM-dd.");
        }
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
