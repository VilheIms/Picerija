
public class PasutitajaInfo {
	private String merce;
	private String piedevas;
	private String dzeriens;
	private double lielums;
	private int daudzums;
	private double cena;
	private int piegade;

	PasutitajaInfo(String merce, String piedevas, String dzeriens, double lielums, int daudzums, int piegade, double cena){
		this.merce = merce;
		this.piedevas = piedevas;
		this.dzeriens = dzeriens;
		this.lielums = lielums;
		this.daudzums = daudzums;
		this.piegade = piegade;
		this.cena = cena;
	}
	public String nolasitAtributus() {
		return "Mērce: "+merce+"\nPiedevas: "+piedevas+"\nDzēriens: "+dzeriens+"\nLielums: "+lielums+" CM"+"\nDaudzums: "+daudzums+"\nPiegāde: "+piegade+" EUR"+"\nCena: "+cena+" EUR";
	}
}
