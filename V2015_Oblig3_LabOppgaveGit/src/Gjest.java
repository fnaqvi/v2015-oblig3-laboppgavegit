import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gjest extends Kort {

	private GregorianCalendar utstedelsesTidspunkt;

	public GregorianCalendar getUtstedelsesTidspunkt() {
		return this.utstedelsesTidspunkt;
	}

	public Gjest(String forNavn, String etterNavn) {
		super(forNavn, etterNavn, 9999);

		this.utstedelsesTidspunkt = new GregorianCalendar();
	}

	public Gjest(String navn) {
		super(navn, 9999);

		this.utstedelsesTidspunkt = new GregorianCalendar();
	}

	@Override
	public boolean sjekkPIN(int pin) {

		if (this.isSperret())
			return false;

		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar frist = (GregorianCalendar) this
				.getUtstedelsesTidspunkt().clone();
		frist.add(Calendar.DAY_OF_MONTH, 7);

		if (now.after(frist)) {
			this.setSperretKort(true);
			return false;
		} else
			return (this.getPINCode() == pin);
	}

	@Override
	public int compareTo(Kort anotherGjest) {

		if (this.getEtterNavn().equals(anotherGjest.getEtterNavn())) {
			if (this.getForNavn().equals(anotherGjest.getForNavn())) {
				return 0;
			} else {
				return this.getForNavn().compareTo(anotherGjest.getForNavn());
			}
		} else {
			return this.getEtterNavn().compareTo(anotherGjest.getEtterNavn());
		}

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Gjest clonedGjest = (Gjest) super.clone();

		clonedGjest.utstedelsesTidspunkt = (GregorianCalendar) this.utstedelsesTidspunkt
				.clone();

		return clonedGjest;
	}

	@Override
	public String toString() {
		return "Navn: " + this.getNavn() + ", Kortnummer: "
				+ this.getKortNummer() + ", PIN: " + this.getPINCode()
				+ ", Sperret: " + (this.isSperret() ? "Ja" : "Nei") + ", Utstedt: "
				+ this.getUtstedelsesTidspunkt().getTime();
	}

}
