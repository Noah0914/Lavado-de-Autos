/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author niday
 */

public class ControladorRegistro {
    
    private List<RegistroServicio> registros;

    public ControladorRegistro() {
        registros = new ArrayList<>();
    }

    public void registrarServicio(Funcionario funcionario, Vehiculo vehiculo, Servicio servicio, Date fecha) {
        RegistroServicio registro = new RegistroServicio(funcionario, servicio, vehiculo, fecha);
        registros.add(registro);
        System.out.println("Servicio registrado: " + servicio.getNombre() + " - Costo: $" + registro.getCosto());
    }

    public List<RegistroServicio> obtenerTodosLosRegistros() {
        return registros;
    }

    // Filtrado por tipo de servicio
    public List<RegistroServicio> obtenerPorTipoServicio(String nombreServicio) {
        List<RegistroServicio> resultado = new ArrayList<>();
        for (RegistroServicio r : registros) {
            if (r.getServicio().getNombre().equalsIgnoreCase(nombreServicio)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    // Filtrado por funcionario
    public List<RegistroServicio> obtenerPorFuncionario(String cedulaFuncionario) {
        List<RegistroServicio> resultado = new ArrayList<>();
        for (RegistroServicio r : registros) {
            if (r.getFuncionario().getCedula().equals(cedulaFuncionario)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    // Filtrado por rango de fechas
    public List<RegistroServicio> obtenerPorRangoFechas(Date desde, Date hasta) {
        List<RegistroServicio> resultado = new ArrayList<>();
        for (RegistroServicio r : registros) {
            if (!r.getFecha().before(desde) && !r.getFecha().after(hasta)) {
                resultado.add(r);
            }
        }
        return resultado;
    }
}