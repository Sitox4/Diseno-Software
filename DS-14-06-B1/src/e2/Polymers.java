package e2;

/**
 * Class for handling polymers represented by Strings
 */
public class Polymers {

        /**
         * Given a polymer represented with the letters of the alphabet ( uppercase
         * and lowercase excluding ~N), it processes the chain reactions of said
         * polymer ( due to adjoint units of the same type but different polarity ,
         * for example : aA ).
         * It returns the polymer without the reactive pairs (it can be an empty
         * string ) and it throws an IllegalArgumentException if the String passed
         * as parameter is null .
         */
	public static String processPolymer(String polymer) {
		StringBuilder poly = new StringBuilder();
		poly.append(polymer);
		if (polymer == null) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 1; i < poly.length(); i++) {
				if (poly.charAt(i) + 32 == poly.charAt(i - 1) || poly.charAt(i) - 32 == poly.charAt(i - 1)) {
					poly.deleteCharAt(i);
					poly.deleteCharAt(i - 1);
					i = 0;
				}
			}
		}
		return poly.toString();
	}

        /**
         * Given a polymer returns the monomer ( existing in the polymer ) whose
         * elimination ( both in its positive and negative form ) results , after the
         * consequent chain reactions , in the smallest polymer .
         * It returns the positive form ( lowercase ) of the monomer . In case of a
         * tie , the one with the lowest alphabetical order is returned .
         * An IllegalArgumentException is thrown if the original polymer is null or
         * if it is a empty string .
         */
	public static char minProcessedPolymer(String polymer) {
		char minmono = 'a';
		String cpoly = polymer;
		String minpoly = polymer;
		if (polymer == null || polymer == "") {
			throw new IllegalArgumentException();
		} else {
			char[] mono = {	'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
			for (int i = 0; i < 26; i++) {
				cpoly = polymer;
				cpoly = cpoly.replace(mono[i], ' ');
				cpoly = cpoly.replace(mono[i + 26], ' ');
				StringBuilder poly = new StringBuilder();
				poly.append(cpoly);
				for (int j = 0; j < poly.length(); j++) {
					if (poly.charAt(j) == ' ') {
						poly.deleteCharAt(j);
						j = j - 1;
					}
				}
				cpoly = poly.toString();
				cpoly = processPolymer(cpoly);
				if (cpoly.length() < minpoly.length()) {
					minpoly = cpoly;
					minmono = mono[i];
				}
				if (cpoly.length() == minpoly.length()) {
					if (mono[i] < minmono) {
						minmono = mono[i];
					}
				}
			}
		}
		return minmono;
	}
}