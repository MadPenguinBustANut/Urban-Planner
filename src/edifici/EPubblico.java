package edifici;

public class EPubblico extends Edificabile{
	private static final long serialVersionUID = 1L;

	public int getTipo() {
		return 2;
	}
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
}
