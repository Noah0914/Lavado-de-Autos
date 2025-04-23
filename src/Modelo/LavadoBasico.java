/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author niday
 */
public class LavadoBasico implements Servicio {
    @Override
    public String getNombre() {
        return "Lavado Básico";
    }

    @Override
    public double calcularCosto(String tipoVehiculo) {
        if (tipoVehiculo.equalsIgnoreCase("automovil")) {
            return 20000; // Precio ejemplo para automóvil
        } else if (tipoVehiculo.equalsIgnoreCase("camioneta")) {
            return 30000; // Precio ejemplo para camioneta
        } else {
            return 0; // Tipo no reconocido
        }
    }
}
