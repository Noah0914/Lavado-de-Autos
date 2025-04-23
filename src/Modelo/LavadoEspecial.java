/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author niday
 */
public class LavadoEspecial implements Servicio {
    @Override
    public String getNombre() {
        return "Lavado Especial";
    }

    @Override
    public double calcularCosto(String tipoVehiculo) {
        if (tipoVehiculo.equalsIgnoreCase("automovil")) {
            return 35000;
        } else if (tipoVehiculo.equalsIgnoreCase("camioneta")) {
            return 45000;
        } else {
            return 0;
        }
    }
}
