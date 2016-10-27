/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Oscar
 */
public class EjemplosFicheros
{
    static File directorio = new File("C:\\Users\\Oscar\\Desktop");
    static File fichero    = new File("C:\\Users\\Oscar\\Desktop\\file.txt");
    
    public static void ListarDirectorioGuardarEnFichero()
    {      
        String[] listaEscritorio;
        
        try
        {
            FileWriter writer = new FileWriter(fichero);
        
            if(directorio.isDirectory())
            {
                listaEscritorio = directorio.list();
                for (String elemento : listaEscritorio)
                {
                    //Guardar en fichero
                    writer.write(elemento + "\r\n");
                }
                writer.close();
            }
            else
            {
                System.out.println("La ruta "+directorio.getPath()+" no es un directorio");
            }
        } catch (IOException ex) {
            System.out.println("ERROR!!!");
        }
    }
    
    static void compararElementosFicheroDirectorio()
    {
        String[] listaEscritorio;
        String[] listaFichero;
        
        try
        {
            //LISTAR EL DIRECTORIO
            listaEscritorio = directorio.list();
            
            // LEER EL CONTENIDO DEL FICHERO
            FileReader reader       = new FileReader(fichero);
            char[] bufferLectura    = new char[100];
            int caracteresLeidos    = 0;
            
            String contenidoFichero = "";
            
                // Guardo en 'contenidoFichero' (String) el contenido del fichero
            while (-1 != ( caracteresLeidos = reader.read(bufferLectura) ) )
            {
                for(int i = 0; i < caracteresLeidos; i++)
                {
                    contenidoFichero += bufferLectura[i];
                }
            }
            
                // Cada elemento 'listaFichero' contendra cada elemento
            listaFichero = contenidoFichero.split("\r\n");
            
                // Comprobar que elementos del fichero no estan en el escritorio
            boolean existe;
            for(String eleFile : listaFichero)
            {
                existe = false;
                for(String eleDir : listaEscritorio)
                {
                    if(eleFile.equals(eleDir))
                        existe = true;
                }
                
                if(!existe)
                    System.out.println(eleFile + " no esta en el escritorio");
            }
            
                // Comprobar que elementos del escritorio no estan en el fichero
            for(String eleDir : listaEscritorio)
            {
                existe = false;
                for(String  eleFile: listaFichero)
                {
                    if(eleDir.equals(eleFile))
                        existe = true;
                }
                
                if(!existe)
                    System.out.println(eleDir + " no esta en el fichero");
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("ERROR!!!!");
        }
        catch (IOException ex)
        {
            System.out.println("ERROR!!!!");
        }
    }
    
    public static void main(String[] args)
    {
        ListarDirectorioGuardarEnFichero();
        compararElementosFicheroDirectorio();
    }
}