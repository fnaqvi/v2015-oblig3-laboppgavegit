import java.util.GregorianCalendar;

public class Ansatt extends Kort {

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
		
		if(this.isSperret())
			return false;
		
		GregorianCalendar now = new GregorianCalendar();
		if(now.after(this.getStartTid()) && now.before(this.getSluttTid()))
			return true;
		else 
			return (this.getPINCode() == pin);
			
		
	}
}
