/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author niday
 */
public class Combo3 implements Servicio {
    @Override
    public String getNombre() {
        return "Combo 3: Combo 2 + Limpieza de Tapicería (Desmontado)";
    }

    @Override
    public double calcularCosto(String tipoVehiculo) {
        if (tipoVehiculo.equalsIgnoreCase("automovil")) {
            return 85000;
        } else if (tipoVehiculo.equalsIgnoreCase("camioneta")) {
            return 100000;
        } else {
            return 0;
        }
    }    
}
