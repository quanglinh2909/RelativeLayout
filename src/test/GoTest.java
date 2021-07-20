package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GoTest {
	private static final int JB_WIDTH = 400;
	private static final int JB_HEIGHT = JB_WIDTH;

	private static void initGui() {
      JFrame frame = new JFrame("GoBoard");
      GoBoard jboard = new GoBoard();
      jboard.setLayout(new BorderLayout(10, 10));

      JPanel holdingPanel = new JPanel(new BorderLayout());
      int eb = 20;
      holdingPanel.setBorder(BorderFactory.createEmptyBorder(0, eb, eb, eb));
      holdingPanel.add(jboard, BorderLayout.CENTER);
      frame.add(holdingPanel, BorderLayout.CENTER);
      jboard.setPreferredSize(new Dimension(JB_WIDTH, JB_HEIGHT));
      jboard.setBackground(Color.white);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //!! frame.setSize(400, 400);
      frame.pack();
      frame.setVisible(true);
   }
	public static void main(String[] args) {
		initGui();
	}
}
