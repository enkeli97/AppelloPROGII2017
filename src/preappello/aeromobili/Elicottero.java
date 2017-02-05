package preappello.aeromobili;
import java.util.GregorianCalendar;

public class Elicottero extends Aeromobile {
	public Elicottero() {
		codice = "";
		destinazione = "";
	}
	
	public Elicottero(GregorianCalendar revisione, GregorianCalendar prossimoVolo, int prenotazioni,
			String codice, String destinazio){
		super(revisione, prossimoVolo, prenotazioni);
		this.codice = codice;
		this.destinazione = destinazio;
		
	}
	
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[codice=" + codice + ", destinazione=" + destinazione + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Elicottero other = (Elicottero) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		if (destinazione == null) {
			if (other.destinazione != null)
				return false;
		} else if (!destinazione.equals(other.destinazione))
			return false;
		return true;
	}

	private String codice;
	private String destinazione;
}
