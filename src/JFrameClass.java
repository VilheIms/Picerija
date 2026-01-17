import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameClass extends JFrame {

	private static final long serialVersionUID = -7754388046793851758L;
	private JButton button;
	JFrameClass(){
		start();
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
		
		
		return button;
	}
}
