

public class Pica {

	String merce; String piedevas;String dzeriens;double lielums;int daudzums; String piegade;double cena;
	
	public Pica(String merce, String piedevas, String dzeriens, double lielums, int daudzums, String piegade, double cena){
		this.merce = merce;
		this.piedevas = piedevas;
		this.dzeriens = dzeriens;
		this.lielums = lielums;
		this.daudzums = daudzums;
		this.piegade = piegade;
		this.cena = cena;
	}
	
	public String nolasitAtributus() {
		return merce+" pica no novickas";
	}
}
