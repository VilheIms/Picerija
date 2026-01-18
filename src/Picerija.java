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
		
		String izvele;
		Pica pica = null;
		String[] darbibas = {"Sākt darbu", "Beigt programmu"};
		String[] darbstacija = {"Pieņemt pasūtījumu", "Apskatīt pasūtījumu vēsturi", "Beigt programmu"};
		String[] informacija = {"Ievadīt picas", "Ievadīt pasūtītāju informāciju", "Saglabāt failā", "Beigt programmu"};
		
		
		
		
		do {
			izvele = (String)JOptionPane.showInputDialog(null,"Izvēlies darbību", "Darbību izvēle",JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele == null) 
				izvele = "Apturet";
			
			switch(izvele) {
			
			case "Sākt darbu":
				
				izvele = (String)JOptionPane.showInputDialog(null,"Izvēlies picērijas opciju", "Darbstacija",JOptionPane.QUESTION_MESSAGE, null, darbstacija, darbstacija[0]);
				
				switch(izvele) {
				case "Pieņemt pasūtījumu":
					
					izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies informācijas ievadi!", "Informācijas ievade", JOptionPane.QUESTION_MESSAGE, null, informacija, informacija[0]);
				
				case "Ievadīt picas":
					
					break;
					
				case "Ievadīt pasūtītāju informāciju":
					
					break;
					
				case "Saglabāt failā":
					
					break;
				}
				
				break;
			case "Apskatīt pasūtījumu vēsturi":
				
				PasutijumaInfo.nolasit();
				
				break;
				
			case "Beigt programmu":
				
				JOptionPane.showMessageDialog(null, "Programma beigusies!");
				
				break;
			}
		}while(!(izvele == "Beigt programmu"));
		
		
		
    }
			
}

