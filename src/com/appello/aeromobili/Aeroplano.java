package com.appello.aeromobili;

import java.util.Arrays;
import java.util.GregorianCalendar;

public class Aeroplano extends Aeromobile {
	public Aeroplano() {
		super();
		modello = "";
		codice = "";
		rotte = null;
		durataVolo = 0;
	}
	
	public Aeroplano(GregorianCalendar revisione, GregorianCalendar prossimoVolo, int prenotazioni, 
			String modello, String codice, String[] rotte, int durataVolo){
		super(revisione, prossimoVolo, prenotazioni);
		this.modello = modello;
		this.codice = codice;
		this.rotte = rotte;
		this.durataVolo = durataVolo;
	}
	
	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String[] getRotte() {
		return rotte;
	}

	public void setRotte(String[] rotte) {
		this.rotte = rotte;
	}

	public int getDurataVolo() {
		return durataVolo;
	}

	public void setDurataVolo(int durataVolo) {
		this.durataVolo = durataVolo;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[modello=" + modello + ", codice=" + codice + ", rotte=" + Arrays.toString(rotte)
				+ ", durataVolo=" + durataVolo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Aeroplano other = (Aeroplano) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		if (durataVolo != other.durataVolo)
			return false;
		if (modello == null) {
			if (other.modello != null)
				return false;
		} else if (!modello.equals(other.modello))
			return false;
		if (!Arrays.equals(rotte, other.rotte))
			return false;
		return true;
	}

	private String modello;
	private String codice;
	private String[] rotte;
	private int durataVolo;
}
