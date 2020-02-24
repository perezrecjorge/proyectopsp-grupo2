package psp.proyectogrupo2.modelo.productorconsumidorbanco;

public class ConsumidorCB extends Thread {
    CuentaCB cuenta;
    String nombre;
    int cantidad;
    double saldoretirar;

    public ConsumidorCB(String nombre, CuentaCB cuenta, double salgoretirar) {
        this.nombre = nombre.toUpperCase();
        this.cuenta = cuenta;
        this.saldoretirar = salgoretirar;
    }

    @Override
    public void run() {
        try {
            System.out.println("LLEGA AQUI RETIRO");
            cuenta.reintegro(saldoretirar, this.nombre);
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
