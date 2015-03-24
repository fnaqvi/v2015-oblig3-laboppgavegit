import java.util.GregorianCalendar;

public class Ansatt extends Kort implements Fast {

	public static final double KREDITPROSENT = 46;
	public static final double BONUSPROSENT = 13;

	private double timeLoenn;
	private int ansiennitet;

	public GregorianCalendar getStartTid() {
		GregorianCalendar startTid = new GregorianCalendar();
		startTid.set(GregorianCalendar.HOUR_OF_DAY, 7);
		startTid.set(GregorianCalendar.MINUTE, 0);
		startTid.set(GregorianCalendar.SECOND, 0);
		return startTid;
	}

	public GregorianCalendar getSluttTid() {
		GregorianCalendar startTid = new GregorianCalendar();
		startTid.set(GregorianCalendar.HOUR_OF_DAY, 17);
		startTid.set(GregorianCalendar.MINUTE, 0);
		startTid.set(GregorianCalendar.SECOND, 0);
		return startTid;
	}

	public Ansatt(String forNavn, String etterNavn, int pINKode) {
		super(forNavn, etterNavn, pINKode);

	}

	public Ansatt(String navn, int pINKode) {
		super(navn, pINKode);

	}

	@Override
	public boolean sjekkPIN(int pin) {

		if (this.isSperret())
			return false;

		GregorianCalendar now = new GregorianCalendar();
		if (now.after(this.getStartTid()) && now.before(this.getSluttTid()))
			return true;
		else
			return (this.getPINCode() == pin);

	}

	@Override
	public void settForNavn(String forNavn) {
		super.setForNavn(forNavn);
	}

	@Override
	public String hentForNavn() {
		return super.getForNavn();
	}

	@Override
	public void settEtterNavn(String etterNavn) {
		super.setEtterNavn(etterNavn);
	}

	@Override
	public String hentEtterNavn() {
		return super.getEtterNavn();
	}

	@Override
	public void settFulltNavn(String fulltNavn) {
		super.setNavn(fulltNavn);
	}

	@Override
	public String hentFulltNavn() {
		return super.getNavn();
	}

	@Override
	public double beregnKreditt() {
		return KREDITPROSENT * this.timeLoenn;
	}

	@Override
	public double beregnBonus() {
		return BONUSPROSENT * this.ansiennitet;
	}
}
