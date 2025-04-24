/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lavadodeautos;

import Vista.PanelConsultaProduccion;
import Controlador.ControladorRegistro;
import Vista.PanelRegistroServicio;

/**
 *
 * @author niday
 */
public class LavadoDeAutos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            ControladorRegistro controlador = new ControladorRegistro();
        PanelRegistroServicio ventana = new PanelRegistroServicio(controlador);
        ventana.setVisible(true);
        PanelConsultaProduccion ventanaConsulta = new PanelConsultaProduccion(controlador);
        ventanaConsulta.setVisible(true);
    }
    
}
