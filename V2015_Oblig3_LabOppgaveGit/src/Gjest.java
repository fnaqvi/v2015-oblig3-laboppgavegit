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

}
