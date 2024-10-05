package utp.edu.pe.poo.pantalla;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class LecturaInformacion {
    Scanner scanner = new Scanner(System.in);   
    
    private void escribeMensaje(String titulo, String mensaje){
        if(titulo.length()>0)
            Titulo.titulo(titulo);
        System.out.print(mensaje);
    }
    
    public  double lecturaDouble(String titulo, String mensaje){
        escribeMensaje(titulo, mensaje);
        double ingreso = scanner.nextDouble();
        return ingreso;
    }  
    public int lecturaInt(String titulo, String mensaje){
        escribeMensaje(titulo, mensaje);
        int ingreso = scanner.nextInt();
        return ingreso;
    }   
    public int lecturaInt(){
        int ingreso = scanner.nextInt();
        return ingreso;
    }   
    public char lecturaChar(String titulo, String mensaje){
        escribeMensaje(titulo, mensaje);
        char ingreso = scanner.next().charAt(0);
        return ingreso;
    }
    public String lecturaString(String titulo, String mensaje){
        escribeMensaje(titulo, mensaje);
        String ingreso = scanner.nextLine();
        return ingreso;
    }
    
    public LocalDate lecturaFecha(String titulo, String mensaje){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");       
        LocalDate fecha = null;
      
        while (fecha == null) {
            String fechaInput = lecturaString(titulo, mensaje);
            try {
                fecha = LocalDate.parse(fechaInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Por favor, inténtalo de nuevo.");
            }
        }
        return fecha;
    }
}
