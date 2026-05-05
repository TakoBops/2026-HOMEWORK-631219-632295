package it.uniroma3.diadia.comandi;[cite: 1]
import it.uniroma3.diadia.Partita;

public interface Comando {
    public void esegui(Partita partita);
    public void setParametro(String parametro);
    public String getNome();
    public String getParametro();
}
