/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Random;

/**
 *
 * @author Sebastian Murillo
 */
public class Palabra extends Tematica{
    
    private String palabraSecreta;
    private String cantLetras;
    
    private String[] diccionarioAnimales = {"ELEFANTE","JIRAFA","PUERCOESPIN","SURICATA","FLAMENCO","GORILA","ESCORPION","MURCIELAGO","CUCARACHA","NUTRIA"};
    private String[] diccionarioPaises = {"AFGANISTAN","COLOMBIA","ARGENTINA","ALEMANIA","ECUADOR","JAPON","JAMAICA","INGLATERRA","BRASIL","ANDORRA"};
    private String[] diccionarioPeliculas = {"TITANIC","CENICIENTA","AVATAR","FRANKENSTEIN","MATILDA","DRACULA","INTERESTELAR","MOONFALL","TERRIFIER"};
    private String[] diccionarioComidas = {"HAMBURGUESA","PAELLA","EMPANADA","PIZZA","HOTDOG","SANDWICH","LASAGNA","FRIJOLADA","RATATOUILLE"};

    
    public void setPalabra(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
    }

    public String getPalabra() {
        return palabraSecreta;
    }

    public void setCantLetras(String cantLetras) {
        this.cantLetras = cantLetras;
    }
    
    public String getCantLetras() {
        return cantLetras;
    }
    
    public String generarPalabraAleatoria(){
        String tematica = getNombreTematica();
        Random random = new Random();
        int p;
        
        switch (tematica) {
            case "animales":
                p = random.nextInt(diccionarioAnimales.length);
                palabraSecreta = diccionarioAnimales[p];
                break;
            case "paises":
                p = random.nextInt(diccionarioPaises.length);
                palabraSecreta = diccionarioPaises[p];
                break;
            case "peliculas":
                p = random.nextInt(diccionarioPeliculas.length);
                palabraSecreta = diccionarioPeliculas[p];
                break; 
            case "comidas":
                p = random.nextInt(diccionarioComidas.length);
                palabraSecreta = diccionarioComidas[p];
                break;
            default:
            System.out.println("Tematica no Valida");
        }
        
        return palabraSecreta;
    }

    
    
    
 
    
}
