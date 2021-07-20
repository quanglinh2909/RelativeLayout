package com.quanglinh.layout.custom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Button extends JButton implements IRelativeLayout{
	private RelativeLayout relativeLayout;
	private JComponent jComponent;
	public Button(JComponent jComponent) {
		this.jComponent = jComponent;
		relativeLayout = new RelativeLayout(jComponent, this);
		this.setFocusable(false);
	}
	
	public void textColor(Paint color) {
		this.setForeground((Color)color);
	}
	public void textStyle(int style) {
		this.setFont(new Font("Tahoma", style, this.getFont().getSize()));
	}
	public void textStyle(String titleFont,int style) {
		this.setFont(new Font(titleFont, style, this.getFont().getSize()));
	}
	public void textSize(int size) {
		this.setFont(new Font(this.getFont().getFontName().split(" ")[0].trim(), this.getFont().getStyle(), size));

	}
	public void gravity(int gravity) {
		this.setHorizontalAlignment(gravity);
	}
	public void radius(int radius) {
		CardView cardView = new CardView(null,2,radius,0);
		this.setBorder(cardView);
	}
	public void radius(int radius,int border,Color colorBorder ) {
		CardView cardView = new CardView(colorBorder,border,radius,0);
		this.setBorder(cardView);
	}
	public void radius(int radius,int border,Color colorBorder,int acuteAngle) {
		CardView cardView = new CardView(colorBorder,border,radius,acuteAngle);
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
