package domain;


public class Department {
	String ime;
	String sifra;

	public Department(String ime, String sifra) {
		super();
		this.ime = ime;
		this.sifra = sifra;
	}

	public Department() {
		super();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	@Override
	public String toString() {
		return "Department [ime=" + ime + ", sifra=" + sifra + "]";
	}

}
