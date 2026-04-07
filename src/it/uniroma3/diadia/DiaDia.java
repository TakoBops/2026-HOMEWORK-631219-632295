package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {
	private Partita partita;
	private IOConsole console;
	
	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto","borsa(info borsa)","info(direzioni possibili e attrezzi)","cfu","fine"};
	
	//prende la console creata nel main in caso ti spiego
	public DiaDia(IOConsole console) {
		this.partita = new Partita();
		this.console = console;
	}

	public void gioca() {
		String istruzione; 

		this.console.consoleMsg(MESSAGGIO_BENVENUTO);	
		do	istruzione = this.console.readInput();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		 else if (comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		//Aggiunto io perche' manca roba _Arnel Pastor
		else if (comandoDaEseguire.getNome().equals("borsa"))
			this.console.consoleMsg(this.partita.getGiocatore().getBorsa().toString());
		else if (comandoDaEseguire.getNome().equals("info"))
			this.console.consoleMsg(this.partita.getStanzaCorrente().toString());
		else if (comandoDaEseguire.getNome().equals("cfu"))
			this.console.consoleMsg("Hai "+this.partita.getGiocatore().getCfu()+"!");
		else
			this.console.consoleMsg("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.console.consoleMsg("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.println("-"+elencoComandi[i]);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.console.consoleMsg("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.console.consoleMsg("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);;
		}
		this.console.consoleMsg(partita.getStanzaCorrente().getDescrizione());
	}
	
	//____________________________________________________________________________________
	private void prendi(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			this.console.consoleMsg("Cosa vuoi prendere?");
			return;
		}

		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		Attrezzo attrezzoDaPrendere = stanzaCorrente.getAttrezzo(nomeAttrezzo);

		if (attrezzoDaPrendere != null) {
			stanzaCorrente.removeAttrezzo(attrezzoDaPrendere);
			
			this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
			this.console.consoleMsg("Hai preso l'attrezzo: " + nomeAttrezzo);
			} 
		else 
			this.console.consoleMsg("L'attrezzo '" + nomeAttrezzo + "' non è presente in questa stanza.");
		
		
	}
	private void posa(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			this.console.consoleMsg("Cosa vuoi posare?");
			return;
		}

		// Rimuoviamo l'attrezzo dalla borsa (il tuo metodo perfetto!)
		Attrezzo attrezzoDaPosare = this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);

		if (attrezzoDaPosare != null) {
			// Lo mettiamo nella stanza corrente
			this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			this.console.consoleMsg("Hai posato l'attrezzo: " + nomeAttrezzo);
		} else {
			this.console.consoleMsg("L'attrezzo '" + nomeAttrezzo + "' non è presente nella tua borsa.");
		}
	}
	
	//____________________________________________________________________________________
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.console.consoleMsg("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}