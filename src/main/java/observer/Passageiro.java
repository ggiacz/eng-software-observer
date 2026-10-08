package observer;

import java.util.Observable;
import java.util.Observer;

public class Passageiro implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Passageiro(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void acompanhar(Voo voo) {
        voo.addObserver(this);
    }

    @Override
    public void update(Observable voo, Object arg) {
        this.ultimaNotificacao =
                this.nome + ", voo atrasado: " + voo.toString();
    }
}
