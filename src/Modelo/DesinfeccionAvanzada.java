/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author niday
 */
public class DesinfeccionAvanzada implements Servicio {
    @Override
    public String getNombre() {
        return "Desinfección Avanzada";
    }

    @Override
    public double calcularCosto(String tipoVehiculo) {
        if (tipoVehiculo.equalsIgnoreCase("automovil")) {
            return 30000;
        } else if (tipoVehiculo.equalsIgnoreCase("camioneta")) {
            return 40000;
        } else {
            return 0;
        }
    }
    
}
