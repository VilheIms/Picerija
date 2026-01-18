import java.util.regex.Pattern;

import javax.swing.JOptionPane;
public class Picerija {
	
	public static String ievade;
	
	public static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null) return null;
			
			virkne = virkne.trim();
		}while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		return virkne;
	}

	public static int skaitlaParbaude(String zinojums, int min, int max) {
		
		int skaitlis;
		
		while(true) {
			ievade = JOptionPane.showInputDialog(null, zinojums, "Datu ievade", JOptionPane.INFORMATION_MESSAGE);
			
			if(ievade == null) return -1;
			
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis<min || skaitlis>max) {
					JOptionPane.showMessageDialog(null, "Norādīs nederīgs intervāls", "Nepareizi dati", JOptionPane.WARNING_MESSAGE);
					continue;
				}
				
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Netika ievadīts vesels skaitlis", "Nepareizi dati", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		
		String izvele, darbizvele, infoizvele = null;
		Pica pica = null;
		PasutitajaInfo klients = null;
		String[] darbibas = {"Sākt darbu", "Beigt programmu"};
		String[] darbstacija = {"Pieņemt pasūtījumu", "Apskatīt pasūtījumu vēsturi", "Beigt programmu"};
		String[] informacija = {"Ievadīt picas", "Ievadīt pasūtītāju informāciju", "Saglabāt failā", "Doties atpakaļ"};
		String[] dzerieni = {"Coca-Cola", "Sprite", "Dr. Pepper", "Fanta", "Pepsi", "Nav"};
		String[] merces = {"BBQ", "Tomātu", "Čillī", "Sinepes"};
		String[] piedevasPicai = {"Šampinjoni", "Dārzeņi", "Gaļa", "Pepperoni","Siers"};
		
		
		
		do {
			izvele = (String)JOptionPane.showInputDialog(null,"Izvēlies darbību", "Darbību izvēle",JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele == null) 
				izvele = "Beigt programmu";
			
			switch(izvele) {
			
			case "Sākt darbu":
				do {
				darbizvele = (String)JOptionPane.showInputDialog(null,"Izvēlies picērijas opciju", "Darbstacija",JOptionPane.QUESTION_MESSAGE, null, darbstacija, darbstacija[0]);
				if(darbizvele == null) 
					darbizvele = "Beigt programmu";
				
					switch(darbizvele) {
						case "Pieņemt pasūtījumu":
					do {
							infoizvele = (String)JOptionPane.showInputDialog(null, "Izvēlies informācijas ievadi!", "Informācijas ievade", JOptionPane.QUESTION_MESSAGE, null, informacija, informacija[0]);
							if(infoizvele == null) 
								infoizvele = "Beigt programmu";
							
							switch(infoizvele) {
							
							case "Ievadīt picas":
								
								String merce = (String)JOptionPane.showInputDialog(null,"Izvēlies mērci", "Darbstacija",JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);
								if(merce == null)
									break;
								String piedevas = (String)JOptionPane.showInputDialog(null,"Izvēlies piedevas", "Darbstacija",JOptionPane.QUESTION_MESSAGE, null, piedevasPicai, piedevasPicai[0]);
								if(piedevas == null)
									break;
								String dzeriens = (String)JOptionPane.showInputDialog(null,"Izvēlies dzērienu", "Darbstacija",JOptionPane.QUESTION_MESSAGE, null, dzerieni, dzerieni[0]);
								if(dzeriens == null)
									break;
								double lielums = skaitlaParbaude("Cik liela būs pica (15 - 60 CM) ?", 15, 60);
								if(lielums == -1)
									break;
								int daudzums = skaitlaParbaude("Cik daudz picas?", 1, 20);
								if(daudzums == -1)
									break;
								int piegade = JOptionPane.showConfirmDialog(null,"Vai būs piegāde?", "Darbstacija",JOptionPane.YES_NO_OPTION);
								
								if(piegade == 0)
									piegade = 8;
								else
									piegade = 0;
								
								double cena = (merce.length()+piedevas.length()+dzeriens.length())/3+(lielums/3)*daudzums+piegade;
								pica = new Pica(merce, piedevas, dzeriens, lielums, daudzums, piegade, cena);
								
								break;
								
							case "Ievadīt pasūtītāju informāciju":
								if(pica == null) {
								JOptionPane.showMessageDialog(null, "Ievadi klienta pasūtījumu, pirms tu prasi privātu informāciju!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
								break;
								}
								String vards = virknesParbaude("Ievadi klienta vārdu", "Gustavs");
								if(vards == null)
									break;
								String telNr = "";
								
										do {
											telNr = JOptionPane.showInputDialog("Ievadi telefona numuru", "+371");
										}while(telNr == null || !Pattern.matches("^[+371]+[2-9]{1}[0-9]{7}$", telNr));
										
								String adrese = "";
								if(pica.piegade == 0) {
									adrese = "";
								}else {
									adrese = JOptionPane.showInputDialog(null, "Ievadi klienta adresi:", "Adreses ievade", JOptionPane.PLAIN_MESSAGE);
								}
								
								klients = new PasutitajaInfo(vards, telNr, adrese);
								
								break;
					
							case "Saglabāt failā":
								if(pica == null || klients == null){
									JOptionPane.showMessageDialog(null, "Vajag gan picu, gan klientu!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
									break;
								}else{
									PasutijumaInfo.saglabatPicu(pica);
									PasutijumaInfo.saglabatKlientu(klients);
									break;
								}
								
							}
							break;
				}while(!(infoizvele == "Beigt programmu"));
							
				break;
				
				case "Apskatīt pasūtījumu vēsturi":
				
					PasutijumaInfo.nolasit();
					
					break;
					}
					}while(!(darbizvele == "Beigt programmu"));
					
			case "Beigt programmu":
				
				JOptionPane.showMessageDialog(null, "Programma beigusies!");
				
				break;
				
			}
			break;
		
		}while(!(izvele == "Beigt programmu"));	
	}
}

