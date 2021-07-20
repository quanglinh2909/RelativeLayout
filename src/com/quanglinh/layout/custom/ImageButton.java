package com.quanglinh.layout.custom;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class ImageButton extends JButton implements IRelativeLayout {
	private RelativeLayout relativeLayout;
	private JComponent jComponent;
	private String url = "";

	public ImageButton(JComponent jComponent) {
		this.jComponent = jComponent;
		relativeLayout = new RelativeLayout(jComponent, this);
		this.setFocusable(false);
	}
	public void srcURL(String url) {
		try {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(recoverImageFromUrl(url)));
			ImageIcon icon = new ImageIcon(img.getScaledInstance(img.getWidth(), img.getHeight(), 1));
			this.setIcon(icon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scaleTypeURL(String url) {
		try {
			int width = this.getBounds().width;
			int height = this.getBounds().height;
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(recoverImageFromUrl(url)));
			ImageIcon icon = new ImageIcon(img.getScaledInstance(width, height, 1));
			this.setIcon(icon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setSizeImageURL(String url,int width,int height) {
		try {
			
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(recoverImageFromUrl(url)));
			ImageIcon icon = new ImageIcon(img.getScaledInstance(width, height, 1));
			this.setIcon(icon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public byte[] recoverImageFromUrl(String urlText) throws Exception {
		URL url = new URL(urlText);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		try (InputStream inputStream = url.openStream()) {
			int n = 0;
			byte[] buffer = new byte[1024];
			while (-1 != (n = inputStream.read(buffer))) {
				output.write(buffer, 0, n);
			}
		}

		return output.toByteArray();
	}


	public void src(String url) {
		try {
			BufferedImage bImage = ImageIO.read(new File(url));
			ImageIcon icon = new ImageIcon(bImage.getScaledInstance(bImage.getWidth(), bImage.getHeight(), 1));
			this.setIcon(icon);
			this.url = url;
		} catch (Exception e1) {
			//System.out.println(e1.getMessage());
		}
	}

	public void scaleType(String url) {
		try {
			BufferedImage bImage = ImageIO.read(new File(url));
			int width = this.getBounds().width;
			int height = this.getBounds().height;
			ImageIcon icon = new ImageIcon(bImage.getScaledInstance(width, height, 1));
			this.setIcon(icon);

		} catch (Exception e1) {
			//System.out.println(e1.getMessage());
		}
	}
	public void scaleType() {
		try {
			BufferedImage bImage = ImageIO.read(new File(url));
			int width = this.getBounds().width;
			int height = this.getBounds().height;
			ImageIcon icon = new ImageIcon(bImage.getScaledInstance(width, height, 1));
			this.setIcon(icon);

		} catch (Exception e1) {
			//System.out.println(e1.getMessage());
		}
	}
	public void setSizeImage(int width,int height) {
		try {
			BufferedImage bImage = ImageIO.read(new File(url));
			ImageIcon icon = new ImageIcon(bImage.getScaledInstance(width, height, 1));
			this.setIcon(icon);

		} catch (Exception e1) {
			//System.out.println(e1.getMessage());
		}
	}
	public void setSizeImage(int width,int height,String url) {
		try {
			BufferedImage bImage = ImageIO.read(new File(url));
			ImageIcon icon = new ImageIcon(bImage.getScaledInstance(width, height, 1));
			this.setIcon(icon);

		} catch (Exception e1) {
			//System.out.println(e1.getMessage());
		}
	}

	public void radius(int radius) {
		CardView cardView = new CardView(null, 2, radius, 0);
		this.setBorder(cardView);
	}

	public void radius(int radius, int border, Color colorBorder) {
		CardView cardView = new CardView(colorBorder, border, radius, 0);
		this.setBorder(cardView);
	}

	public void radius(int radius, int border, Color colorBorder, int acuteAngle) {
		CardView cardView = new CardView(colorBorder, border, radius, acuteAngle);
		this.setBorder(cardView);
	}
	public void radius(int radius, int border, Color colorBorder, int acuteAngle,boolean left) {
		CardView cardView = new CardView(colorBorder, border, radius, acuteAngle,left);
		this.setBorder(cardView);
	}
	@Override
	public int getMatch_parent_with() {
		return jComponent.getBounds().width;
	}

	@Override
	public int getMatch_parent_height() {
		return jComponent.getBounds().height;
	}

	@Override
	public void layout_width(int with) {
		relativeLayout.layout_width(with);

	}

	@Override
	public void layout_height(int height) {
		relativeLayout.layout_height(height);

	}

	@Override
	public void layout_below(JComponent componentTop) {
		relativeLayout.layout_below(componentTop);

	}

	@Override
	public void layout_above(JComponent componentTop) {
		relativeLayout.layout_above(componentTop);

	}

	@Override
	public void layout_marginTop(int top) {
		relativeLayout.layout_marginTop(top);

	}

	@Override
	public void layout_marginLeft(int left) {
		relativeLayout.layout_marginLeft(left);

	}

	@Override
	public void layout_marginRight(int right) {
		relativeLayout.layout_marginRight(right);

	}

	@Override
	public void layout_marginBottom(int bottom) {
		relativeLayout.layout_marginBottom(bottom);

	}

	@Override
	public void layout_alignParentRight() {
		relativeLayout.layout_alignParentRight();

	}

	@Override
	public void layout_alignBottom() {
		relativeLayout.layout_alignBottom();

	}

	@Override
	public void layout_toLeftOf(JComponent component) {
		relativeLayout.layout_toLeftOf(component);

	}

	@Override
	public void layout_toRightOf(JComponent component) {
		relativeLayout.layout_toRightOf(component);

	}

	@Override
	public void layout_centerVertical() {
		relativeLayout.layout_centerVertical();

	}

	@Override
	public void layout_centerHorizontal() {
		relativeLayout.layout_centerHorizontal();

	}
}
