/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author niday
 */
public class Combo1 implements Servicio {
    @Override
    public String getNombre() {
        return "Combo 1: Lavado + Polichado + Desengrasante";
    }

    @Override
    public double calcularCosto(String tipoVehiculo) {
        if (tipoVehiculo.equalsIgnoreCase("automovil")) {
            return 50000;
        } else if (tipoVehiculo.equalsIgnoreCase("camioneta")) {
            return 60000;
        } else {
            return 0;
        }
    }
    
}
