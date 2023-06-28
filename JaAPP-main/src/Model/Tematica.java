/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Sebastian Murillo
 * @version 1.1
 */
public abstract class Tematica {
    
    private static String nombreTematica;
    
    /**
     * Constructor 
    */
    public Tematica() {
    }
    
    /**
     * Getter 
    */
    public String getNombreTematica() {
        return Tematica.nombreTematica;
    }

    /**
     * Setter 
    */
    public final void setNombreTematica(String nombreTematica) {
        Tematica.nombreTematica = nombreTematica;
    }

    
    
}
