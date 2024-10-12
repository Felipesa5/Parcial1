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
        
        
        //Niño niño1 = new Niño("Andres", 1, 0);
        //Niño niño2 = new Niño("Felipe", 2, 1);
        //Niño niño3 = new Niño("Luisa", 3, 2);
        //Niño niño4 = new Niño("Fernanda", 4, 3);
        //Niño niño5 = new Niño("Alejandra", 5, 4);
        //Niño niño6 = new Niño("Sebastian", 5, 5);
        //
        //nivel1.estudiantes.add(niño1);
        //nivel1.estudiantes.add(niño2);
        //nivel2.estudiantes.add(niño3);
        //nivel2.estudiantes.add(niño4);
        //nivel3.estudiantes.add(niño5);
        //nivel3.estudiantes.add(niño6);
        
        
        do{
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
                int confirmacion= JOptionPane.showConfirmDialog(null, "Desea inscribir a " + nombre + " en el " + nivelAplicable.nombre + " con un valor base de: "+ formater.format(nivelAplicable.valorBase)  , null, JOptionPane.YES_NO_OPTION);
                if (confirmacion == 1) {
                    JOptionPane.showMessageDialog(null, "Muchas gracias por visitar MIS PASITOS ❤️");
                }else{
                    String cantHermanostxt = JOptionPane.showInputDialog("Cuantos hermanos tiene "+ nombre);
                    int cantHermanos = Integer.parseInt(cantHermanostxt);
                    Niño niño = new Niño(nombre, edad, cantHermanos);
                    niño.descuentoRealizado();
                    nivelAplicable.getEstudiantes().add(niño);
                    double pago = nivelAplicable.valorBase - ((niño.descuento/100) * nivelAplicable.valorBase) + nivelAplicable.TRANSPORTE;
                    JOptionPane.showMessageDialog(null, "El total a pagar de "+ nombre + " es: "+ formater.format(pago));

                }
            }else{
                JOptionPane.showMessageDialog(null,"Lo sentimos, "+ nombre + " no aplica a ningún nivel");
            }
            continuidad = JOptionPane.showConfirmDialog(null,"Desea seguir registrando niños?",null,JOptionPane.YES_NO_OPTION);
        }while (continuidad == 0);

        String mensajeFinal = "";

        for (Nivel nivel : niveles) {
            if (nivel.estudiantes.size() == 0) {
                mensajeFinal += "El nivel "+ nivel + " no tiene ningún estudiante inscrito \n";
            }else{
                mensajeFinal += "Estudiantes del "+ nivel.nombre + " son: \n";
                for (Niño niño : nivel.estudiantes) {
                    double pago = nivel.valorBase - ((niño.descuento/100) * nivel.valorBase);
                    mensajeFinal += "   *"+ niño.nombre + " = $"+ formater.format(pago) + "\n";
                }
            }            
            
        }
        JOptionPane.showMessageDialog(null, mensajeFinal);
    }
}

