package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pain extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Pain() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		textField = new JTextField(" d");
		textField.setBounds(0, 0, 131, 32);
		add(textField);
		textField.setColumns(10);
		//setLayout(null);

	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		Graphics2D fix = (Graphics2D) this.getGraphics();
//		super.paintComponents(fix);
//		fix.setColor(Color.black);
//		fix.drawString("hoang quang linh", 0, 10);
//		System.out.println("ok");
	}
	public void ve(int x,int y) {
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawString("This is JPanel fvsv svs fv fv fsvs dfvfd v", 0, 10);

	}

}
