/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;
/**
 *
 * @author niday
 */
public class RegistroServicio {
    
        private Funcionario funcionario;
        private Servicio servicio;
        private Vehiculo vehiculo;
        private Date fecha;

        public RegistroServicio(Funcionario funcionario, Servicio servicio, Vehiculo vehiculo, Date fecha) {
            this.funcionario = funcionario;
            this.servicio = servicio;
            this.vehiculo = vehiculo;
            this.fecha = fecha;
        }

        public Funcionario getFuncionario() { 
            return funcionario; }
        public Servicio getServicio() { 
            return servicio; }
        public Vehiculo getVehiculo() { 
            return vehiculo; }
        public Date getFecha() { 
            return fecha; }

        public double getCosto() {
            return servicio.calcularCosto(vehiculo.getTipo());
        }    
}
