import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameClass extends JFrame {

	JFrameClass(){
		start();
	}
	
	public void start() {
		setTitle("JFrameClass");
		setLayout(new BorderLayout(10, 5));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		panel.setBackground(Color.gray);
		
		
		Button pasutijums = new Button("Ievadīt pasūtījumu");
		panel.add(pasutijums);
		
		Button pica = new Button("Izveidot picu");
		panel.add(pica);
		
		Button pasutitajs = new Button("Ievadīt pasūtītāja informāciju");
		panel.add(pasutitajs);
		
		Button saglabat = new Button("Saglabāt failā");
		panel.add(saglabat);
		
		Button apskatit = new Button("Apskatīt failu");
		
		
		panel.add(pasutijums);
		panel.add(pica);
		panel.add(pasutitajs);
		panel.add(saglabat);
		panel.add(apskatit);
		
		add(panel, BorderLayout.CENTER);
		
		panel.setPreferredSize(new Dimension(25, 25));
		
		setVisible(true);
	}
}
