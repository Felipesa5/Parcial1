import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        DecimalFormat formater = new DecimalFormat("###,###.##");
        ArrayList<Nivel> niveles = new ArrayList<>();
        int continuidad;

        Nivel nivel1 = new Nivel("Nivel 1", 4300000, 1, 2);
        Nivel nivel2 = new Nivel("Nivel 2", 3900000, 3, 4);
        Nivel nivel3 = new Nivel("Nivel 3", 3500000, 5, 5);

        niveles.add(nivel1);
        niveles.add(nivel2);
        niveles.add(nivel3);
        do {
            
        
        Nivel nivelAplicable = null;
       
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del niño");
        String edadTxt = JOptionPane.showInputDialog("Por favor ingrese la edad del niño");
        int edad = Integer.parseInt(edadTxt);

        
        for (Nivel nivel : niveles) {
            if (edad >= nivel.edadMinima && edad <= nivel.edadMaxima ) {
                nivelAplicable = nivel;
                break;
            }    
        }
       
        if (nivelAplicable != null){
            JOptionPane.showMessageDialog(null, nombre + " aplica a: "+ nivelAplicable.nombre );
            int confirmacion= JOptionPane.showConfirmDialog(null, "Desea inscribir a " + nombre + " en el " + nivelAplicable.nombre + " con un valor base de: "+ nivelAplicable.valorBase , null, JOptionPane.YES_NO_OPTION);
            if (confirmacion == 1) {
                JOptionPane.showMessageDialog(null, "Muchas gracias por visitar MIS PASITOS ❤️");
            }else{
                String cantHermanostxt = JOptionPane.showInputDialog("Cuantos hermanos tiene "+ nombre);
                int cantHermanos = Integer.parseInt(cantHermanostxt);
                Niño niño = new Niño(nombre, edad, cantHermanos);
                niño.descuentoRealizado();
                nivelAplicable.getEstudiantes().add(niño);
                double pago = nivelAplicable.valorBase - ((niño.descuento/100) * nivelAplicable.valorBase) + nivelAplicable.TRANSPORTE;
                JOptionPane.showMessageDialog(null, "El total a pagar de "+ nombre + " es: "+ pago);
            }

        }else{
            JOptionPane.showMessageDialog(null,"Lo sentimos, "+ nombre + " no aplica a ningún nivel");
        }
        continuidad = JOptionPane.showConfirmDialog(null,"Desea seguir registrando niños?",null,JOptionPane.YES_NO_OPTION);
    } while (continuidad == JOptionPane.YES_OPTION);

    for (Nivel nivel : niveles) {
        System.out.println(nivel.nombre);
        for (Niño niño : nivel.estudiantes) {
            System.out.println(niño.nombre);
        }
    }
        
        
        










    }

    
}
