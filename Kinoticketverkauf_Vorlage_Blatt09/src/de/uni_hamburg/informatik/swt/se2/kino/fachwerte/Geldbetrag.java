package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public final class Geldbetrag {

	final Integer _euro;
	final Integer _cent;
	
	
	/**
	 * erstellt einen GEldbetrag aus zwei Integer Werten eine für Euro und einen für Cent
	 * 
	 */
	public Geldbetrag(int euro, int cent){
		_euro = euro;
		_cent=cent;
	}
	
	/**
	 * erstellt einen Geldbetrag aus einem Integer Eurocent
	 */
	
	public Geldbetrag(int eurocent){
		_euro = eurocent/100;
		_cent = eurocent%100;
	}
	
	/**
	 * erstellt eine Geldbetrag aus einem float
	 */
	
	public Geldbetrag (double geldbetrag){
		_euro = (int)geldbetrag;
		double zwischen = (geldbetrag *100);
		_cent = (int)zwischen%100;
	}
	/**
	 * erstellt einen Geldbetrag aus einem String, es muss ein Komma vorhanden sein
	 * müsste hier eine Exception werfen
	 */
	
	public Geldbetrag (String geld) throws NumberFormatException{
		//muss zuerst die Anzahl der Kommas in der Eingabe kontrollieren, wenn diese 
		//größer als eins ist muss sofort eine Exception geworfen werden
		String[] splitted = geld.split(",");
		if(countKomma(geld) >1){
			int i = Integer.parseInt("hallo");
		}
			_euro = extractEuro(splitted);
			_cent = extractCent(splitted);
	}
	/**
	 * darf die Exception eigentlich nicht abfangen sondern muss eine werfen, falls keine Zahl eingeben wurde
	 * @param S
	 * @return
	 */
	private Integer extractEuro(String[] splitted) throws NumberFormatException{
		if(splitted.length >0){
		return Integer.parseInt(splitted[0]);
		}else{
			int i = Integer.parseInt("hallo");
			return 0;
		}
	}
	/**
	 * Darf die Exception eigentlich nicht abfangen sondern muss eine werfen, falls keine Zahl eigegeben wurde
	 * 
	 * @param S
	 * @return
	 */
	private Integer extractCent(String[] splitted) throws NumberFormatException{
		
			if(splitted.length>1){
				if(splitted[1].length()  == 1){
					splitted[1] = splitted[1]+"0";
				}
				return Integer.parseInt(splitted[1]);
			}else{
				return 0;
			}
	}
	
	
	/**
	 * addiert einen weiteren GEldbetrag zum Geldbetrag4
	 */
	
	
	public Geldbetrag addGeldbetrag(Geldbetrag g){
		int euro = _euro + g.get_euro();
		int cent = _cent + g.get_cent();
		Geldbetrag gg = new Geldbetrag(euro,cent);
		return gg;
	}
	
	/**
	 * subtrahiert einen GEldbetrag vom Geldbetrag und gibt diesen zurück
	 */
	
	public Geldbetrag subGeldbetrag(Geldbetrag g){
	
		int thiseurocent = get_eurocent();
		int lokaleurocent = g.get_eurocent();
		int eurocent = thiseurocent - lokaleurocent;
		int euro = eurocent/100;
		int cent = eurocent%100;
		if(cent <0){
			cent = cent * -1;
		}
		Geldbetrag gg = new Geldbetrag(euro,cent);
		return gg;
	}
	
	
	/**
	 * multipliziert den Geldbetrag mit der angegebenen Zahl
	 * @param zahl
	 */
	
	public Geldbetrag mulGeldbetrag(int zahl){
		Integer zwischenErgebnis = _cent * zahl;
		int cent = zwischenErgebnis%100;
		int euro = _euro * zahl + zwischenErgebnis/100;
		Geldbetrag g = new Geldbetrag(euro,cent);
		return g;
		
	}
	
	public Integer get_euro(){
		return _euro;
	}
	
	public Integer get_cent(){
		return _cent;
	}
	
	public String toString(){
		if(_cent<10){
			return _euro +",0"+_cent;
		}else{
			return _euro +","+_cent;
		}
	}
	
	/**
	 * TODO Methode die die Kommas zählt damit bei zuvielen bei ERstellung eine Exception 
	 * ausgelöst werden kann
	 */
	private int countKomma(String S){
		char[] charArray = S.toCharArray();
		int Anzahl =0;
		for(char c : charArray){
			if(c==','){
				Anzahl++;
			}
		}
		return Anzahl;
	}
	
	/**
	 * gibt den GEldbetrag in Eurocent zurück;
	 */
	private int get_eurocent(){
		System.out.println(_euro +"€");
		if(_euro <0){
			return _euro*100 + _cent*-1;
		}else{
			return _euro*100 + _cent;
		}
	}
	
	public boolean equals(Geldbetrag G){
		if(G.get_cent() == _cent && G.get_euro() ==_euro){
			return true;
		}else{
			return false;
		}
	}
	
	public int hashCode(){
		return _euro + _cent;
	}
	
}
