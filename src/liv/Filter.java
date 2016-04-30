/**
 * 
 */
package liv;

/**
 * class filter
 * 
 * Project: Liv - Lebensmittelinhaltverifizierer
 * 
 * @author team equal-IT
 * mail: team@equal-it.de
 * @version  00.00.01 2016/04/29 - 10:47
 *
 */

public class Filter {

	int[] filter = new int[4]; // default value need

	public void  setFilter(int a, int b, int c, int d, int e) {
		filter[0] = a;
		filter[1] = b;
		filter[2] = c;
		filter[3] = d;
		filter[4] = e;
	}
	
	public int[] getFilter(){
		return  filter;
	}

}
