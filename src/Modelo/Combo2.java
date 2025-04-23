/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author niday
 */
public class Combo2 implements Servicio {
    @Override
    public String getNombre() {
        return "Combo 2: Combo 1 + Grafitado de Chasis";
    }

    @Override
    public double calcularCosto(String tipoVehiculo) {
        if (tipoVehiculo.equalsIgnoreCase("automovil")) {
            return 65000;
        } else if (tipoVehiculo.equalsIgnoreCase("camioneta")) {
            return 75000;
        } else {
            return 0;
        }
    }
    
}
