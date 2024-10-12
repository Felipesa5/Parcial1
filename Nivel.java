import java.util.ArrayList;

public class Nivel {
    final double TRANSPORTE = 400000;
    String nombre;
    double valorBase;
    int edadMinima;
    int edadMaxima;
   // double descuento;
    ArrayList<Niño> estudiantes;
    
    public Nivel(String nombre, double valorBase, int edadMinima, int edadMaxima){
        this.nombre = nombre;
        this.valorBase = valorBase;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.estudiantes = new ArrayList<>();
    }

    public double getTRANSPORTE() {
        return TRANSPORTE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public ArrayList<Niño> getEstudiantes() {
        return this.estudiantes;
    }

}
