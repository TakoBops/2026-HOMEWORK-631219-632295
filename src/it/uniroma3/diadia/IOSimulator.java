package it.uniroma3.diadia;

public class IOSimulator implements IO {
    // Implementare array o liste per memorizzare righe lette e messaggi scritti
    @Override
    public void mostraMessaggio(String messaggio) {
        // Salva il messaggio per i test
    }

    @Override
    public String leggiRiga() {
        // Ritorna le righe "iniettate" dal test
        return null; 
    }
}
