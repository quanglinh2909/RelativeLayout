package test;

import java.awt.Color;

import javax.swing.JPanel;

import com.quanglinh.layout.custom.Button;

public class ItemLayout extends JPanel {
   Button button;
	public ItemLayout() {
		setLayout(null);
		setBounds(0, 0, 0, 50);
		
		setBackground(Color.blue);
        button = new Button(this);
        button.layout_width(100);
        button.layout_height(40);
	}
public Button getButton() {
	return button;
}
}
