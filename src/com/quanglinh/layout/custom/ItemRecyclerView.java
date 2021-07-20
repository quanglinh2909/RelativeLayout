package com.quanglinh.layout.custom;

import javax.swing.JPanel;

public abstract class ItemRecyclerView extends JPanel {
	private int height;
	public ItemRecyclerView(int height) {
		setLayout(null);
        setBounds(0, 0, 0, height);
	}
}
