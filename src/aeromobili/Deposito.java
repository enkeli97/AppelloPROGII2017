package preappello.aeromobili;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Deposito implements Serializable{

	public Deposito() {

	}

	public void addAeromobile(Aeromobile aeromobile){
		if (isPresent(aeromobile))
			throw new IllegalArgumentException("Aeromobile già presente nel deposito!");

		deposito.add(aeromobile);
	}

	public void revisione() {
		for (Aeromobile a : deposito) {
			a.effettuaRevisione();
		}
	}

	public ArrayList<Aeromobile> ricercaData(GregorianCalendar data) {
		ArrayList<Aeromobile> disponibili = new ArrayList<Aeromobile>();

		for (Aeromobile a: deposito) {
			if (a.getProssimoVolo().before(data))
				if (!a.isExpiredRevision())
					disponibili.add(a);
		}

		return disponibili;
	}

	public Aeromobile ricercaCodice(String codice){
		Aeromobile aeromobile = null;
		for (Aeromobile a: deposito){
			if(a instanceof Aeroplano) {
				Aeroplano plano = (Aeroplano) a;
				if (plano.getCodice().equals(codice)){
					aeromobile = plano;
					break;
				}
			}
			else {
				Elicottero eli = (Elicottero) a;
				if (eli.getCodice().equals(codice)){
					aeromobile = eli;
					break;
				}
			}
		}
		return aeromobile;
	}

	public ArrayList<Aeromobile> getDeposito() {
		return deposito;
	}

	public void setDeposito(ArrayList<Aeromobile> deposito) {
		this.deposito = deposito;
	}

	private boolean isPresent(Aeromobile aeromobile){
		for (Aeromobile a : deposito){
			if (aeromobile.equals(a))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Deposito [deposito=" + deposito + "]";
	}

	private ArrayList<Aeromobile> deposito = new ArrayList<Aeromobile>();
}
