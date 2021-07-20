package com.quanglinh.layout.custom;

import javax.swing.JPanel;

public abstract class Fragment extends JPanel {
	private Bundle bundle = new Bundle();
	public Fragment() {
		setLayout(null);
	}
	public void setSizeFragment(int width, int height ) {
		setBounds(0, 0, width, height);
	}
	protected  abstract void createView();
	public void setArguments(Bundle bundle) {
		this.bundle.getMap().putAll(bundle.getMap());
		//System.out.println(bundle.getMap());
	}//
	
	public Object getArguments(String key) {

		return this.bundle.getValue(key);

	}
	
}
