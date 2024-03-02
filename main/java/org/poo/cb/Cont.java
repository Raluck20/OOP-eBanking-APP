package org.poo.cb;

public class Cont {
	private String tipValuta;
	private double suma;

	public Cont(String tipValuta, double suma) {
		this.tipValuta = tipValuta;
		this.suma = suma;
	}

	public static Cont createCont(String tipValuta, double suma) {
		if (tipValuta.equals("USD")) {
			return new ContUSD(suma);
		}

		if (tipValuta.equals("EUR")) {
			return new ContEUR(suma);
		}

		if (tipValuta.equals("GBP")) {
			return new ContGBP(suma);
		}

		if (tipValuta.equals("CAD")) {
			return new ContCAD(suma);
		}

		if (tipValuta.equals("JPY")) {
			return new ContJPY(suma);
		}

		return null;
	}

	public String getTipValuta() {
		return tipValuta;
	}

	public void setTipValuta(String tipValuta) {
		this.tipValuta = tipValuta;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}
}
