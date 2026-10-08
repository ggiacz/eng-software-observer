package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassageiroTest {

    @Test
    void deveNotificarUmPassageiro() {
        Voo voo = new Voo("LA3050", "Sao Paulo");
        Passageiro passageiro = new Passageiro("Passageiro 1");

        passageiro.acompanhar(voo);
        voo.atrasar();

        assertEquals(
                "Passageiro 1, voo atrasado: Voo{codigo='LA3050', destino='Sao Paulo'}",
                passageiro.getUltimaNotificacao()
        );
    }

    @Test
    void deveNotificarPassageiros() {
        Voo voo = new Voo("LA3050", "Sao Paulo");
        Passageiro passageiro1 = new Passageiro("Passageiro 1");
        Passageiro passageiro2 = new Passageiro("Passageiro 2");

        passageiro1.acompanhar(voo);
        passageiro2.acompanhar(voo);

        voo.atrasar();

        assertEquals(
                "Passageiro 1, voo atrasado: Voo{codigo='LA3050', destino='Sao Paulo'}",
                passageiro1.getUltimaNotificacao()
        );

        assertEquals(
                "Passageiro 2, voo atrasado: Voo{codigo='LA3050', destino='Sao Paulo'}",
                passageiro2.getUltimaNotificacao()
        );
    }

    @Test
    void naoDeveNotificarPassageiro() {
        Voo voo = new Voo("LA3050", "Sao Paulo");
        Passageiro passageiro = new Passageiro("Passageiro 1");

        voo.atrasar();

        assertEquals(null, passageiro.getUltimaNotificacao());
    }

    @Test
    void deveNotificarPassageiroVooAcompanhado() {
        Voo vooA = new Voo("LA3050", "Sao Paulo");
        Voo vooB = new Voo("G31420", "Rio de Janeiro");

        Passageiro passageiro1 = new Passageiro("Passageiro 1");
        Passageiro passageiro2 = new Passageiro("Passageiro 2");

        passageiro1.acompanhar(vooA);
        passageiro2.acompanhar(vooB);

        vooA.atrasar();

        assertEquals(
                "Passageiro 1, voo atrasado: Voo{codigo='LA3050', destino='Sao Paulo'}",
                passageiro1.getUltimaNotificacao()
        );

        assertEquals(null, passageiro2.getUltimaNotificacao());
    }
}
