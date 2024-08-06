package interfaces;

public interface Combatiente {
    void ataqueBasico(Combatiente enemigo);
    void ataqueEspecial(Combatiente enemigo);

    boolean estaVivo();
}