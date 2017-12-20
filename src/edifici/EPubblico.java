package edifici;

public class EPubblico extends Edificabile{
	private static final long serialVersionUID = 1L;

	public int getTipo() {
		return 2;
	}
<<<<<<< HEAD
	
	//Fai in rimuovi If getStato ==0 addStato() else fare eccezione controllata 
	//Se tenti di rimuovere un ed Publico che sta già in demolizione aprire un altro pannel che indica 
	//che sta già venendo demolito
	
	public short getStato() {
		return stato;
	}
	
	public void addStato() {
		stato++;
	}
	
	private short stato = 0;
=======
	//Fai in rimuovi If getStato ==0 addStato() else fare eccezione controllata 
    //Se tenti di rimuovere un ed Publico che sta già in demolizione aprire un altro pannel che indica 
    //che sta già venendo demolito

    public short getStato() {
        return stato;
    }

    public void addStato() {
        stato++;
    }
    private short stato;
>>>>>>> d1403b8d094b79b6e0367945d740286c1b8e1b9d
}
