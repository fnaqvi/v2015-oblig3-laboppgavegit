import java.util.ArrayList;
import java.util.Collections;

public class KortTest {

	public static void main(String[] args) {

		ArrayList<Kort> reg = new ArrayList<Kort>();

		Kort a1 = new Ansatt("Ole Olsen", 1234);
		Kort a2 = new Ansatt("Ola Nordmann", 4578);
		Kort a3 = new Ansatt("Kari Nordmann", 9584);
		Kort g1 = new Gjest("Marit Olsen" /* , 9999 */);
		Kort g2 = new Gjest("Maria Sharapova" /* , 9999 */);
		Kort g3 = new Gjest("Martin Wawne" /* , 9999 */);
		reg.add(a1);
		reg.add(a2);
		reg.add(a3);
		reg.add(g1);
		reg.add(g2);
		reg.add(g3);

		for (int i = 0; i < reg.size(); i++) {
			Kort kort = (Kort) reg.get(i);
			System.out.println(kort);
			System.out.println("\nTest av kort: med kode 1234 er"
					+ (kort.sjekkPIN(1234) ? " gyldig" : " ugyldig"));
			System.out.println("\nTest av kort: med kode 9999 er"
					+ (kort.sjekkPIN(9999) ? " gyldig" : " ugyldig"));
			System.out.println("\n");
		}
		
		Collections.sort(reg);
		for(Kort kort : reg){
			System.out.println(kort);
		}	
		
	}
}