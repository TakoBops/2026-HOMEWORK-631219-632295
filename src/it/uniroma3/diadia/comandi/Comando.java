package it.uniroma3.diadia.comandi;

public interface Comando {
    void esegui();
    void setParametro(String parametro);
    String getNome(); // Nuovo metodo richiesto
    String getParametro(); // Nuovo metodo richiesto
}
