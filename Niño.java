public class Niño {
    String nombre;
    int edad;
    int cantidadHermanos;
    double descuento;


    public Niño(String nombre, int edad, int cantidadHermanos) {
        this.nombre = nombre;
        this.edad = edad;
        this.cantidadHermanos = cantidadHermanos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getCantidadHermanos() {
        return cantidadHermanos;
    }
    public void setCantidadHermanos(int cantidadHermanos) {
        this.cantidadHermanos = cantidadHermanos;
    }
    public double getDescuento() {
        return descuento;
    }
    public void descuentoRealizado() {
        if (this.cantidadHermanos == 0) {
            this.descuento = 0;
        }else {
            if (this.cantidadHermanos == 1) {
                this.descuento = 15;
            }else{
                int hermanosDescuento = cantidadHermanos - 1;
                this.descuento = (hermanosDescuento * 5) + 15;
            }
        }
    }

}

