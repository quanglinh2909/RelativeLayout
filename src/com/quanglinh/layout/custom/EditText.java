package com.quanglinh.layout.custom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditText extends JPanel implements IRelativeLayout {
	private RelativeLayout relativeLayout, editText;
	private JComponent jComponent;
	private JTextField jTextField;
	private TextView hint;
	private OnDataChange onDataChange;
	private String txtHint = "";
    private ImageView imageView = new ImageView(this);

	public EditText(JComponent jComponent) {
		this.jComponent = jComponent;
		setLayout(null);
		relativeLayout = new RelativeLayout(jComponent, this);
		hint = new TextView(this);
		hint.layout_marginLeft(10);
		hint.textStyle(Font.PLAIN);
		hint.textColor(Color.gray);

		jTextField = new JTextField();
		jTextField.setText(" ");
		editText = new RelativeLayout(this, jTextField);
		jTextField.setBorder(BorderFactory.createEmptyBorder());
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.black));
		editText.layout_marginLeft(5);
		jTextField.setText("");

		jTextField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				String t = jTextField.getText();
				if (onDataChange != null) {
					onDataChange.onDataChange(t);
				}
				if (t.isEmpty()) {
					hint.setText(txtHint);
					repaint();
				}else {
					hint.setText("");
				}
			}
		});

	}

	public interface OnDataChange {
		void onDataChange(String s);
	}

	public void onDataChange(OnDataChange onDataChange) {
		this.onDataChange = onDataChange;
	}

	public void setBackGroundRelative(Color color) {
		setBackground(color);
		jTextField.setBackground(color);
	}

	public void setICon(int width,String src,int widthICon,int heightIcon) {
		imageView.layout_width(width);
		imageView.layout_height(getBounds().height);
        imageView.layout_centerVertical();
		Rectangle rectangleEDT = jTextField.getBounds();
		editText.layout_width(rectangleEDT.width - width);

		editText.layout_toRightOf(imageView);
		hint.layout_toRightOf(imageView);
		editText.layout_marginLeft(5);
		hint.layout_marginLeft(10);
		imageView.setBackgroundRelative(getBackground());
		imageView.setBorder(BorderFactory.createLineBorder(Color.black));
		imageView.setSizeImage( widthICon, heightIcon,src);
		imageView.gravity(Gravity.CENTER);
	}
	
    public void setBackGroundIcon(Color color) {
    	imageView.setBackgroundRelative(color);
    }
	public String getText() {
		return jTextField.getText();
	}

	public void setText(String s) {
		jTextField.setText(s);
		hint.setText("");
	}

	public void setTextHint(String txtHint) {
		hint.setText(txtHint);
		this.txtHint = txtHint;
	}

	public void textColor(Color color) {
		jTextField.setForeground(color);
	}

	public void textHintColor(Color color) {
		hint.textColor(color);
	}

	public void textStyle(int font) {
		jTextField.setFont(new Font("Tahoma", font, this.getFont().getSize()));
		hint.textStyle(font);
	}

	public void texHinttStyle(int font) {
		hint.textStyle(font);
	}

	public void textStyle(String titleFont, int font) {
		jTextField.setFont(new Font(titleFont, font, this.getFont().getSize()));
		hint.textStyle(titleFont, font);

	}

	public void textHintStyle(String titleFont, int font) {
		hint.textStyle(titleFont, font);

	}

	public void textSize(int size) {
		jTextField
				.setFont(new Font(this.getFont().getFontName().split(" ")[0].trim(), this.getFont().getStyle(), size));
		hint.textSize(size);

	}

	public void textHintSize(int size) {

		hint.textSize(size);

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

	public void radius(int radius, int border, Color colorBorder, int acuteAngle, boolean left) {
		CardView cardView = new CardView(colorBorder, border, radius, acuteAngle, left);
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
		editText.layout_width(with - 7);
		editText.layout_centerVertical();
		hint.layout_width(with - 7);
		hint.layout_centerVertical();

	}

	@Override
	public void layout_height(int height) {
		relativeLayout.layout_height(height);
		editText.layout_height(height - 7);
		editText.layout_centerVertical();
		hint.layout_height(height - 7);
		hint.layout_centerVertical();

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
