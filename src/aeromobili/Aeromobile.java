package preappello.aeromobili;
import java.io.Serializable;
import java.util.GregorianCalendar;

public class Aeromobile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Aeromobile() {
		revisione = new GregorianCalendar();
		prossimoVolo = new GregorianCalendar(0, 0, 0, 0, 0);
		prenotazioni = 0;
	}
	
	public Aeromobile(GregorianCalendar revisione, GregorianCalendar prossimoVolo, int prenotazioni) {
		if (revisione.after(this.revisione))
			this.revisione = revisione;
		if (prossimoVolo.after(this.prossimoVolo))
			this.prossimoVolo = prossimoVolo;
		this.prenotazioni = prenotazioni;
	}
	
	public boolean isExpiredRevision() {
		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar check = new GregorianCalendar();
		check = this.revisione;
		check.set(GregorianCalendar.YEAR, check.get(GregorianCalendar.YEAR) + 3);
		return check.after(now);
	}
	
	public void effettuaRevisione() {
		revisione = new GregorianCalendar();
	}
	
	public GregorianCalendar getRevisione() {
		return revisione;
	}

	public void setRevisione(GregorianCalendar revisione) {
		this.revisione = revisione;
	}

	public GregorianCalendar getProssimoVolo() {
		return prossimoVolo;
	}

	public void setProssimoVolo(GregorianCalendar prossimoVolo) {
		this.prossimoVolo = prossimoVolo;
	}

	public int getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(int prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "[revisione=" + revisione + ", prossimoVolo=" + prossimoVolo + ", prenotazioni="
				+ prenotazioni + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Aeromobile other = (Aeromobile) obj;
		if (prenotazioni != other.prenotazioni)
			return false;
		if (prossimoVolo == null) {
			if (other.prossimoVolo != null)
				return false;
		} else if (!prossimoVolo.equals(other.prossimoVolo))
			return false;
		if (revisione == null) {
			if (other.revisione != null)
				return false;
		} else if (!revisione.equals(other.revisione))
			return false;
		return true;
	}

	private GregorianCalendar revisione; 
	private GregorianCalendar prossimoVolo; 
	private int prenotazioni;
}
