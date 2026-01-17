import javax.swing.JFrame;

public class Pica {

	private JFrame frame;
	
	Pica(){
		start();
	}
	
	public void start() {
		frame = new JFrame();
		this.frame.setTitle("Pica");
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setSize(500, 400);
		this.frame.setLocationRelativeTo(null);
		this.frame.setResizable(false);
		this.frame.setVisible(true);
	}
}
