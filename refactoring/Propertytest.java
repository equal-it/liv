package liv;

import java.util.HashSet;
import java.util.Set;

public class Propertytest {

	enum Wochentag {
		MONTAG, DIENSTAG, MITTWOCH;
	}
	
	public static void main(String[] args) {
	
		Wochentag tag = Wochentag.MITTWOCH;
		
		System.out.println(tag);
		
		Set<Wochentag> wTage = new HashSet<>();
		wTage.add(Wochentag.MONTAG);
		wTage.add(Wochentag.DIENSTAG);
		
		wTage.contains(Wochentag.MITTWOCH);
		wTage.remove(Wochentag.DIENSTAG);
		
	}
}
