package com.quanglinh.layout.custom;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class BottomNavigationItem extends JPanel {
	private String urlClick;
	private String title;
	private ImageView imageButton;
	private TextView textView;
	private String urlUnClick;
	private Size size;

	public BottomNavigationItem(String urlClick, String urlUnClick, String title) {
		this.urlClick = urlClick;
		this.title = title;
		this.urlUnClick = urlUnClick;
		setLayout(null);
		imageButton = new ImageView(this);
		imageButton.setBorder(BorderFactory.createEmptyBorder());
		imageButton.setFocusable(false);

		if (urlClick != null) {
			imageButton.src(urlUnClick);
		}
		textView = new TextView(this);
		textView.setText(title);

	}

	public void setMauTitle(Color color) {
		textView.textColor(color);
	}

	public void setsizeBottom(int with, int height, Size sizeIcon, int sizeTitle) {
		this.size = sizeIcon;
		imageButton.layout_width(with);
		imageButton.layout_height(height - (sizeTitle * 2));
		imageButton.layout_centerHorizontal();
		imageButton.gravity(Gravity.CENTER);
		imageButton.setSizeImage(sizeIcon.getWith(), sizeIcon.getHeight());
		textView.layout_width(with);
		textView.layout_height(sizeTitle * 2);
		textView.layout_below(imageButton);
		textView.textSize(sizeTitle);
		textView.gravity(Gravity.CENTER);
	}

	public void setImageButtonUnclick() {
		imageButton.setSizeImage(size.getWith(), size.getHeight(),urlUnClick);

	}
	public void setImageButtonClick() {
		imageButton.setSizeImage(size.getWith(), size.getHeight(),urlClick);

	}

	public void setBackgroundBottom(Color color) {
		imageButton.setBackgroundRelative(color);
		textView.setBackGroundRelative(color);
	}

}
