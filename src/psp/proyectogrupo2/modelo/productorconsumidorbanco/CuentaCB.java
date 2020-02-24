package psp.proyectogrupo2.modelo.productorconsumidorbanco;

public class CuentaCB {
    double saldo, saldoMax;
    int turno = 1;
    boolean disponible = true;


    public CuentaCB(int saldo, int saldoMax) {
        this.saldo = saldo;
        this.saldoMax = saldoMax;
        System.out.println("SALDO INICIAL: " + saldo + " => SALDO MAXIMO: " + saldoMax);
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(int saldoMax) {
        this.saldoMax = saldoMax;
    }


    public synchronized void ingreso(double cantidad, String nombre) {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }

        if (this.saldo + cantidad > this.saldoMax)
            System.out.println("ERROR /!\\ NO PUEDE INGRESAR " + cantidad + " POR QUE EL SALDO MAXIMO ES " + this.saldo);
        else {
            this.saldo = this.saldo + cantidad;
            System.out.println(nombre+" INGRESA " + cantidad + " => EL SALDO ACTUAL ES: " + this.saldo);
        }
        disponible = false;

        notifyAll();

    }

    public synchronized void reintegro(double cantidad, String nombre) {
        while (disponible){
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        disponible = true;
        if ((this.saldo - cantidad) < 0)
            System.out.println("ERROR /!\\ NO PUEDE SACAR " + cantidad + " POR QUE EL SALDO ACTUAL ES " + this.saldo);
        else {
            this.saldo = this.saldo - cantidad;
            System.out.println(nombre+" RETIRA " + cantidad + " => EL SALDO ACTUAL ES: " + this.saldo);
        }
        notifyAll();
    }
}
