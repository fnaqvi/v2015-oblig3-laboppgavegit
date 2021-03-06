public abstract class Kort implements Cloneable, Comparable<Kort> {

	private String forNavn;
	private String etterNavn;
	private int pINKode;
	private String kortNummer;
	// private int aksessKode;
	private boolean sperretKort;

	public Kort(String forNavn, String etterNavn, int pINKode /* , int aksessKode */) {
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.pINKode = pINKode;
		// this.aksessKode = aksessKode;

		kortNummer = generateCreditCardNbr(16);

		this.sperretKort = false;
	}

	public Kort(String navn, int pINKode /* , int aksessKode */) {

		String[] arrNavn = navn.split(" ");
		this.forNavn = arrNavn[0];
		this.etterNavn = arrNavn[1];

		this.pINKode = pINKode;
		// this.aksessKode = aksessKode;

		kortNummer = generateCreditCardNbr(16);

		this.sperretKort = false;
	}

	private static String generateCreditCardNbr(int length) {
		String randomCardNbr = "";

		for (int i = 0; i < length; i++) {
			randomCardNbr += (int) (Math.random() * 10);
		}

		return randomCardNbr;
	}

	public String getNavn() {
		return this.forNavn + " " + this.etterNavn;
	}

	public boolean isSperret() {
		return this.sperretKort;
	}

	public void setSperretKort(boolean sperret) {
		this.sperretKort = sperret;
	}

	public void setForNavn(String forNavn) {
		this.forNavn = forNavn;
	}

	public void setEtterNavn(String etterNavn) {
		this.etterNavn = etterNavn;
	}

	public void setNavn(String fulltNavn) {
		String[] arrNavn = fulltNavn.split(" ");
		this.forNavn = arrNavn[0];
		this.etterNavn = arrNavn[1];
	}

	public String toString() {
		return "Navn: " + this.getNavn() + ", Kortnummer: "
				+ this.getKortNummer() + ", PIN: " + this.getPINCode()
				+ ", Sperret: " + (this.isSperret() ? "Ja" : "Nei");
	}

	public abstract boolean sjekkPIN(int pin);

	public String getForNavn() {
		return this.forNavn;
	}

	public String getEtterNavn() {
		return this.etterNavn;
	}

	public int getPINCode() {
		return this.pINKode;
	}

	public String getKortNummer() {
		return this.kortNummer;
	}

	/*
	 * public int getAksessKode() { return this.aksessKode; }
	 */

}
