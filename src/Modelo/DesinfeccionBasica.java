/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author niday
 */
public class DesinfeccionBasica implements Servicio {
    @Override
    public String getNombre() {
        return "Desinfección Básica";
    }

    @Override
    public double calcularCosto(String tipoVehiculo) {
        if (tipoVehiculo.equalsIgnoreCase("automovil")) {
            return 15000;
        } else if (tipoVehiculo.equalsIgnoreCase("camioneta")) {
            return 20000;
        } else {
            return 0;
        }
    }
    
}
