
public class PasutitajaInfo {
	String adrese; String telNr; String vards;
	
	public PasutitajaInfo(String vards, String telNr, String adrese){
		this.vards = vards;
		this.telNr = telNr;
		this.adrese = adrese;
		
	}
	
	public String nolasitAtributus() {
		return "Klienta vārds: "+vards+"\nKlienta telefona nr. : "+telNr+"\nKlienta adrese: "+adrese;
	}
}
