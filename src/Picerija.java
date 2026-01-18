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
		String[] informacija = {"Ievadīt picas", "Ievadīt pasūtītāju informāciju", "Saglabāt failā", "Beigt programmu"};
		String[] dzerieni = {"Coca-Cola", "Sprite", "Dr. Pepper", "Fanta", "Pepsi", "Nav"};
		String[] merces = {"BBQ", "Tomātu", "Čillī", "Sinepes"};
		String[] piedevasPicai = {"Šampinjoni", "Dārzeņi", "Gaļa", "Pepperoni","Siers"};
		String[] piegadePircejam = {"Ir", "Nav"};
		
		
		
		do {
			izvele = (String)JOptionPane.showInputDialog(null,"Izvēlies darbību", "Darbību izvēle",JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele == null) 
				izvele = "Beigt programmu";
			
			switch(izvele) {
			
			case "Sākt darbu":
				
				darbizvele = (String)JOptionPane.showInputDialog(null,"Izvēlies picērijas opciju", "Darbstacija",JOptionPane.QUESTION_MESSAGE, null, darbstacija, darbstacija[0]);
				
					switch(darbizvele) {
						case "Pieņemt pasūtījumu":
					
							infoizvele = (String)JOptionPane.showInputDialog(null, "Izvēlies informācijas ievadi!", "Informācijas ievade", JOptionPane.QUESTION_MESSAGE, null, informacija, informacija[0]);
				do {
							switch(infoizvele) {
				
							case "Ievadīt picas":
					
								String merce = (String)JOptionPane.showInputDialog(null,"Izvēlies mērci", "Darbstacija",JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);
								String piedevas = (String)JOptionPane.showInputDialog(null,"Izvēlies piedevas", "Darbstacija",JOptionPane.QUESTION_MESSAGE, null, piedevasPicai, piedevasPicai[0]);
								String dzeriens = (String)JOptionPane.showInputDialog(null,"Izvēlies dzērienu", "Darbstacija",JOptionPane.QUESTION_MESSAGE, null, dzerieni, dzerieni[0]);
								double lielums = skaitlaParbaude("Cik liela būs pica (CM) ?", 15, 60);
								int daudzums = skaitlaParbaude("Cik daudz picas?", 1, 20);
								String piegade = (String)JOptionPane.showInputDialog(null,"Vai būs piegāde?", "Darbstacija",JOptionPane.QUESTION_MESSAGE, null, piegadePircejam, piegadePircejam[0]);
								double cena = 12;
								pica = new Pica(merce, piedevas, dzeriens, lielums, daudzums, piegade, cena);
								break;
					
							case "Ievadīt pasūtītāju informāciju":
					
								break;
					
							case "Saglabāt failā":
								PasutijumaInfo.saglabat(pica);
								break;
							}
				}while(!(infoizvele == "Beigt programmu"));
					break;
				case "Apskatīt pasūtījumu vēsturi":
				
					PasutijumaInfo.nolasit();
					
					break;
					
					}
			case "Beigt programmu":
				
				JOptionPane.showMessageDialog(null, "Programma beigusies!");
				
				break;
			}
		}while(!(izvele == "Beigt programmu"));
    }	
}

