import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JFrameClass extends JFrame {

	private static final long serialVersionUID = -7754388046793851758L;
	private JButton button, button2;
	Pica pica = null;
	JFrameClass(){
		start();
	}
	
	public static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null) return null;
			
			virkne = virkne.trim();
		}while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		return virkne;
	}
	
	public void start() {
		
		
		setTitle("JFrameClass");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		panel.setBackground(Color.darkGray);
		
		button = createButton();
		panel.add(button);
		
		button2 = createButton2();
		panel.add(button2);
		
		add(panel, BorderLayout.CENTER);
		
		panel.setPreferredSize(new Dimension(25, 25));
		
		setVisible(true);
	}

	private JButton createButton() {
		
		JButton button = new JButton("Sākt darbu");
		button.setFocusable(false);
		ImageIcon pizza = new ImageIcon("images.jpg");
		button.setIcon(pizza);
		button.setToolTipText("Sākt ņemt pasūtījumus no klientiem.");
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Pizza party");
				String merce = virknesParbaude("Ievadi mērci", "Tomātu");
				pica = new Pica(merce);
			}
			
		});
		
		
		return button;
	}
	
private JButton createButton2() {
		
		JButton button = new JButton("Iziet");
		button.setFocusable(false);
		button.setToolTipText("Beigt programmu pirms tā vispār sākās.");
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saglabāts failā");
				PasutijumaInfo.saglabat(pica);
			}
			
		});
		
		
		return button;
	}
}
