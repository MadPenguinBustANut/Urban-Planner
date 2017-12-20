package centrourbano;

import java.io.Serializable;
import edifici.EPubblico;

import eccezioni.LottoLibero;
import edifici.Edificabile;


public class Settori implements Serializable{
	private static final long serialVersionUID = 1L;

	public Settori() {
		setValore(0);
		lista = new Lotti[3][5];
		for(int x = 0; x < 3; x++)
			for(int i = 0; i < 5; i++)
				lista[x][i] = new Lotti();

	}


	/**
	 * Calcola il prezzo del lotto, questo metodo si applica solo per gli edifici privati
	 * essendo gli unici con un valore e elimina il lotto essendo stato venduto
	 * @param X Coordinata X, che insieme alla Y indicano che edificio vendere
	 * @param Y Coordinata Y, che insieme alla X indicano che edificio vendere
	 * @return	Ritorna il prezzo di vendita dell'edificio
	 */

	public int vendiEdificio(int X, int Y) {
		Lotti vend = getLotto(X, Y);
		int tot = (vend.getValore() + this.getValore()) * vend.getCeff();
		rmLotto(X, Y);
		return tot;

	}



	/**
	 * In base al tipo di lotto il metodo esegue una di 3 azioni
	 * -Edificio pubblico: Incrementa di 1 il valore del settore
	 * -Strada: Trova i lotti adiacenti nelle 8 direzioni e aumenta il loro valore di 1
	 * -Edificio privato: Controlla i lotti adiacenti in cerca di strade e aumenta per ogni strada il valore di 1
	 * @param Nuovo Il Lotto che va inserito
	 */

	public void addLotto(Edificabile Nuovo, int X, int Y) {
		if(Nuovo.getTipo() == STRADA)
			addStrada( Nuovo,X,Y);
		if(Nuovo.getTipo() == EPUB)
			addEpub(Nuovo,X,Y);
		if(Nuovo.getTipo() == EPRIV)
			addEpriv(Nuovo,  X, Y);
	}




	/**
	 * Rimuove l'edificio e inverte i cambiamenti che questo influiva sui vicini e sul settore.
	 * -Edificio privato: Semplice rimozione
	 * -Edificio pubblico: Il valore del settore viene ridotto di 1
	 * -Strada: Riduce di 1 il valore dei lotti adiacenti
	 *
	 *
	 * Nel caso in cui il lotto sia gia libero lancia un eccezione di tipo "LottoLibero"
	 * @param x Coordinata X, che insieme alla Y indicano che edificio rimuovere
	 * @param y Coordinata Y, che insieme alla X indicano che edificio rimuovere
	 */

	public void rmLotto(int x, int y) {
		if((getLotto(x, y)).getTip() == LIBERO)
			throw new LottoLibero();
		if((getLotto(x, y)).getTip() == STRADA)
			rmStrada(x,y);
		if((getLotto(x, y)).getTip() == EPUB)
			rmEpub(x,y);
		if((getLotto(x, y)).getTip() == EPRIV)
			rmEpriv(x,y);

	}

	/**
	 * Cambia l'edificio selezionato con un altro aggiornando gli effetti
	 * @param X Coordinata X, che insieme alla Y indicano che edificio cambiare
	 * @param Y Coordinata Y, che insieme alla X indicano che edificio cambiare
	 * @throws LottoLibero Nel caso il lotto sia gia libero lancia una eccezzione
	 */

	public void cgEdificio(Edificabile nuovo,int X, int Y) {
		rmLotto(X, Y);
		addLotto(nuovo, X , Y);
	}

	/**
	 * Restituisce il lotto in posizione X, Y
	 * @param X Coordinata X, che insieme alla Y indicano che edificio restituire
	 * @param y Coordinata Y, che insieme alla X indicano che edificio restituire
	 * @return
	 */

	public Lotti getLotto(int X, int y) {
		Lotti io = lista[X][y];


		return io;
	}

	/**
	 * Aggiunge una strada alla posizione indicata da X e Y e aumenta di uno
	 * il valore di tutti i lotti adiacenti interni al settore (per quelli esterni se ne occupa il
	 * metodo di CentroUrbano, perfavore usare quello e non questo nel caso si debba aggiungere una strada)
	 * @param Nuovo Il lotto da inserire
	 * @param X Coordinata X, che insieme alla Y indicano la posizione della strada
	 * @param Y Coordinata Y, che insieme alla X indicano la posizione della strada
	 */

	private void addStrada(Edificabile Nuovo, int X, int Y) {
			lista[(int) X][(int) Y].edificio = Nuovo;

			if((Y - 1) > -1)
				addOne(X,Y-1);
			if((Y + 1) < MAX_Y )
				addOne(X,Y+1);
			if((X - 1) > -1) {
				addOne(X-1, Y);
				if((Y-1) > -1)
					addOne(X-1, Y-1);
				if((Y + 1) < MAX_Y)
					addOne(X-1, Y+1);
			}
			if((X + 1) < MAX_X) {
				addOne(X+1, Y);
				if((Y-1) > -1)
					addOne(X+1, Y-1);
				if((Y+1) < MAX_Y)
					addOne(X+1,Y+1);
			}
	}



	/**
	 * Aggiunge un edificio pubblico e aumenta il valore del settore di 1
	 * @param Nuovo Il lotto da aggiungere
	 * @param X Coordinata X, che insieme alla Y indicano in che posizione aggiungere il lotto
	 * @param Y Coordinata Y, che insieme alla X indicano in che posizione aggiungere il lotto
	 */

	private void addEpub(Edificabile NuovoEdificio, int X, int Y) {
		lista[X][Y].edificio = NuovoEdificio;
		this.setValore(this.getValore() + 1);
	}

	/**
	 * Aggiunge un edificio privato
	 * @param Nuovo Il lotto da aggiungere
	 * @param X Coordinata X, che insieme alla Y indicano in che posizione aggiungere il lotto
	 * @param Y Coordinata Y, che insieme alla X indicano in che posizione aggiungere il lotto
	 */

	private void addEpriv(Edificabile Nuovo, int X, int Y) {
		lista[X][Y].edificio = Nuovo;
	}

	/**
	 * Rimuove la strada alla posizione indicata da X e Y
	 * Inoltre riduce di uno il valore di tutti i lotti adiacenti in modo da annullare il
	 * bonus dato dalla strada
	 * @param x Coordinata X, che insieme alla Y indicano la posizione della strada da rimuovere
	 * @param y Coordinata Y, che insieme alla X indicano la posizione della strada da rimuovere
	 */

	private void rmStrada(int x, int y) {
		lista[(int) x][(int) y].edificio = Lotti.VUOTO;
		if((y - 1) > -1)
			subOne(x,y-1);
		if((y + 1) < MAX_Y )
			subOne(x,y+1);
		if((x - 1) > -1) {
			subOne(x-1, y);
			if((y-1) > -1)
				subOne(x-1, y-1);
			if((y + 1) < MAX_Y)
				subOne(x-1, y+1);
		}
		if((x + 1) < MAX_X) {
			subOne(x+1, y);
			if((y-1) > -1)
				subOne(x+1, y-1);
			if((y+1) < MAX_Y)
				subOne(x+1,y+1);
			}
		}

	/**
	 * Rimuovi l'edificio pubblico e rimuove il +1 bonus al settore
	 * @param x Coordinata X, che insieme alla Y indicano in che posizione rimuovere il lotto
	 * @param y Coordinata Y, che insieme alla X indicano in che posizione rimuovere il lotto
	 */

	private void rmEpub(int x,int y) {
		if(((EPubblico) ( lista[x][y]).edificio).getStato() == 0)
			((EPubblico) ( lista[x][y]).edificio).addStato();
		else {
			lista[x][y].edificio = Lotti.VUOTO;
			setValore(getValore() - 1);
		}
	}

	/**
	 * Rimuovi l'edificio privato
	 * @param x Coordinata X, che insieme alla Y indicano in che posizione rimuovere il lotto
	 * @param y Coordinata Y, che insieme alla X indicano in che posizione rimuovere il lotto
	 */

	private void rmEpriv(int x,int y) {
		lista[(int) x][(int) y].edificio = Lotti.VUOTO;
	}

	/**
	 * Calcola il numero di lotti presenti nel settore compresi i lotti liberi
	 */

	public int calcolaLotti() {
		int totale = 0;
		totale+=calcolaLottiLiberi();
		totale+=calcolaLottiPrivati();
		totale+=calcolaLottiPubblici();
		totale+=calcolaStrade();
		return totale;
	}

	/**
	 * Calcola il numero di lotti liberi presenti nel settore
	 */

	public int calcolaLottiLiberi() {
		int lottiLiberi = 0;
		for(int i = 0; i < MAX_X ; i++ ) {
			for(int j=0;j < MAX_Y; j++) {
				if(lista[i][j].getTip() == LIBERO)
					lottiLiberi++;
			}

		}

		return lottiLiberi;
	}

	/**
	 * Calcola il numero di strade presenti nel settore
	 */

	public int calcolaStrade() {
		int strade = 0;
		for(int i = 0; i < MAX_X ; i++ ) {
			for(int j=0;j < MAX_Y; j++) {
				if(lista[i][j].getTip() == STRADA)
					strade++;
			}

		}

		return strade;
	}

	/**
	 * Calcola il numero di lotti pubblici presenti nel settore
	 */

	public int calcolaLottiPubblici() {
		int lottiPubblici = 0;
		for(int i = 0; i < MAX_X ; i++ ) {
			for(int j=0;j < MAX_Y; j++) {
				if(lista[i][j].getTip() == EPUB)
					lottiPubblici++;
			}

		}

		return lottiPubblici;
	}

/**
 * Calcola il numero di lotti privati presenti nel settore
 */

	public int calcolaLottiPrivati() {
		int lottiPrivati = 0;
		for(int i = 0; i < MAX_X ; i++ ) {
			for(int j=0;j < MAX_Y; j++) {
				if(lista[i][j].getTip() == EPRIV)
					lottiPrivati++;
			}

		}

		return lottiPrivati;
	}

	/**
	 *Questo metodo aumenta di uno il valore del lotto,  ma solo se  e' un edificio privato
	 * @param X Coordinata X, che insieme alla Y indicano in che posizione si trova il lotto a cui aumentare il valore
	 * @param Y Coordinata Y, che insieme alla X indicano in che posizione si trova il lotto a cui aumentare il valore
	 */

	public void addOne(int X,int Y) {
		if(lista[(int) X][(int) Y].getTip()==EPRIV)
			lista[(int) X][(int) Y].setValore(lista[(int) X][(int) Y].getValore() + 1);
	}

	/**
	 * Questo metodo riduce di uno il valore del lotto, ma solo se  e' un edificio privato
	 * @param X Coordinata X, che insieme alla Y indicano in che posizione si trova il lotto a cui ridurre il valore
	 * @param Y Coordinata Y, che insieme alla X indicano in che posizione si trova il lotto a cui ridurre il valore
	 */

	public void subOne(int X,int Y) {
		if(lista[(int) X][(int) Y].getTip()==EPRIV)
			lista[(int) X][(int) Y].setValore(lista[(int) X][(int) Y].getValore() - 1);
	}

	/**
	 * Questo metodo ritorna il valore del settore
	 * @return Valore del settore
	 */

	public int getValore() {
		return valore;
	}

	/**
	 * Questo metodo modifica il valore del settore
	 * @param valore Valore del settore
	 */

	public void setValore(int value) {
		valore = value;
	}



	//Ho associato delle MACRO ai limiti del settore in modo da rendere piu leggibile il codice
	private static final int MAX_X = 3;
	private static final int MAX_Y = 5;

	//A ogni tipo di edificio ho associato un valore, creando una MACRO che rende piu leggibile il codice
	private static final int LIBERO = 0;
	private static final int STRADA = 1;
	private static final int EPUB = 2;
	private static final int EPRIV = 3;
	private int valore;



	public Lotti[][] lista;
}
