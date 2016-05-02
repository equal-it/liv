/**
 * 
 */
package liv;

/**
 * class Filter
 * 
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT
 * mail: team@equal-it.de
 * @version  00.00.01 2016/04/29 - 10:47
 *
 */

public class Filter {

	boolean[] filter = new boolean[4]; // default value need

	public void  setFilter(boolean a, boolean b, boolean c, boolean d, boolean e) {
		filter[0] = a; //Laktose
		filter[1] = b;
		filter[2] = c;
		filter[3] = d;
		filter[4] = e;
	}
	
	public boolean[] getFilter(){
		return  filter;
	}

	/**
	 * Setzt Filter auf Laktose = true als Standard
	 */
	public void setFilterDefault(){
		filter[0] = true; //Laktose
		filter[1] = false;
		filter[2] = false;
		filter[3] = false;
		filter[4] = false;
	}
}