package observer;

import java.util.Observable;

public class Voo extends Observable {

    private String codigo;
    private String destino;

    public Voo(String codigo, String destino) {
        this.codigo = codigo;
        this.destino = destino;
    }

    public void atrasar() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Voo{" +
                "codigo='" + codigo + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }
}
