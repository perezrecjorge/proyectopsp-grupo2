package psp.proyectogrupo2.modelo.productorconsumidorbanco;

public class ProductorCB extends Thread {
    CuentaCB cuenta;
    String nombre;
    int cantidad;
    double saldoingresar;

    public ProductorCB(String nombre, CuentaCB cuenta, double salgoingresar) {
        this.nombre = nombre.toUpperCase();
        this.cuenta = cuenta;
        this.saldoingresar = salgoingresar;
    }

    @Override
    public void run() {
        try {
            System.out.println("LLEGA AQUI INGRESO");
            cuenta.ingreso(saldoingresar, this.nombre);
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
