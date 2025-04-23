/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author niday
 */
public class Funcionario {
    private String nombre;
    private String cedula;

    public Funcionario(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() { 
        return nombre; }
    public String getCedula() { 
        return cedula; }
}
