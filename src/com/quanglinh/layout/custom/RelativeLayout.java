package com.quanglinh.layout.custom;

import java.awt.Rectangle;

import javax.swing.JComponent;

public  class RelativeLayout  {
	private JComponent component;
	private boolean checkRight,checkBottom,checkLef,checkTop,checkBelow,checkAbove;
	private boolean alignParentRight,alignParentBottom;
	private boolean centerVertical,centerHorizontal;
	private boolean toLeft,toRight;
	private JComponent jComponent2;
	private  int match_parent_with;
	private  int match_parent_height;
	public RelativeLayout(JComponent main,JComponent jComponent2) {
		this.component = main;
		this.jComponent2 = jComponent2;
		main.add(jComponent2);
		Rectangle rectangle = main.getBounds();
		match_parent_with = rectangle.width;
		match_parent_height = main.getBounds().height;
	}
	public int getMatch_parent_with() {
		return match_parent_with;
	}
	public int getMatch_parent_height() {
		return match_parent_height;
	}
	public void layout_width(int with) {
		Rectangle rectangle = jComponent2.getBounds();
		jComponent2.setBounds(rectangle.x, rectangle.y, with, rectangle.height);
	}
	public void layout_height(int height) {
		Rectangle rectangle = jComponent2.getBounds();
		jComponent2.setBounds(rectangle.x, rectangle.y, rectangle.width, height);
	}
	public void layout_below(JComponent componentTop) {
		if(!alignParentBottom) {
			Rectangle rectangleTop = componentTop.getBounds();
			Rectangle rectangleThis = jComponent2.getBounds();
			jComponent2.setBounds(rectangleThis.x, rectangleThis.y+rectangleTop.height+rectangleTop.y, rectangleThis.width, rectangleThis.height);
			checkBelow = true;
		}
	}
	public void layout_above(JComponent componentTop) {
		
			Rectangle rectangleTop = componentTop.getBounds();
			Rectangle rectangleThis = jComponent2.getBounds();
			jComponent2.setBounds(rectangleThis.x,rectangleTop.y - rectangleThis.height-rectangleThis.y, rectangleThis.width, rectangleThis.height);
			checkAbove= true;
	}
	
	public void layout_marginTop(int top) {
		if(!alignParentBottom) {
			Rectangle rectangle = jComponent2.getBounds();
			jComponent2.setBounds(rectangle.x, rectangle.y+top, rectangle.width, rectangle.height);
			checkTop = true;
		}
		
	}
	
	public void layout_marginLeft(int left) {
		if(!alignParentRight && !toLeft) {
			Rectangle rectangle = jComponent2.getBounds();
			jComponent2.setBounds(rectangle.x+left, rectangle.y, rectangle.width, rectangle.height);
			checkLef = true;
		}
		
	}
	public void layout_marginRight(int right) {
		if(alignParentRight || toLeft) {
			Rectangle rectangle = jComponent2.getBounds();
			jComponent2.setBounds(rectangle.x-right, rectangle.y, rectangle.width, rectangle.height);
			checkRight = true;
		}
		
	}
	public void layout_marginBottom(int bottom) {
		if(!checkTop && alignParentBottom ||!checkTop && checkAbove ) {
			Rectangle rectangle = jComponent2.getBounds();
			jComponent2.setBounds(rectangle.x, rectangle.y-bottom, rectangle.width, rectangle.height);
			checkBottom = true;
		}
		
	}
	public void layout_alignParentRight() {
		if(!toRight && !toLeft && !checkLef) {
			Rectangle rectangle = jComponent2.getBounds();
			Rectangle rectangleJcom = component.getBounds();
			//System.out.println(rectangle.x);
			jComponent2.setBounds(rectangle.x+rectangleJcom.width-rectangle.width- rectangle.x, rectangle.y, rectangle.width, rectangle.height);
			alignParentRight = true;
		}
		
	}
	public void layout_alignBottom() {
		if(!checkTop && !checkBelow ) {
			Rectangle rectangle = jComponent2.getBounds();
			Rectangle rectangleJcom = component.getBounds();
			jComponent2.setBounds(rectangle.x, rectangle.y+rectangleJcom.height-rectangle.height, rectangle.width, rectangle.height);
			alignParentBottom = true;
		}
		
	}
	
	public void layout_toLeftOf(JComponent component) {
		if(!alignParentRight && !checkLef) {
			Rectangle rectangle = jComponent2.getBounds();
			Rectangle rectangleJcom = component.getBounds();
			jComponent2.setBounds(rectangleJcom.x - rectangle.width, rectangle.y, rectangle.width, rectangle.height);
			toLeft = true;
		}
		
	}
	
	public void layout_toRightOf(JComponent component) {
			Rectangle rectangle = jComponent2.getBounds();
			Rectangle rectangleJcom = component.getBounds();
			jComponent2.setBounds(rectangleJcom.x +rectangleJcom.width, rectangle.y, rectangle.width, rectangle.height);
			toRight = true;
		
		
	}
	public void layout_centerVertical() {
			Rectangle rectangle = jComponent2.getBounds();
			Rectangle rectangleJcom = component.getBounds();
			int i = (int)(rectangleJcom.height/2) - (int)(rectangle.height/2);
			jComponent2.setBounds(rectangle.x,i, rectangle.width, rectangle.height);
			centerVertical = true;
		
		
	}
	public void layout_centerHorizontal() {
		Rectangle rectangle = jComponent2.getBounds();
		Rectangle rectangleJcom = component.getBounds();
		int i = (int)(rectangleJcom.width/2) - (int)(rectangle.width/2);
		jComponent2.setBounds(i,rectangle.y, rectangle.width, rectangle.height);
		centerHorizontal = true;
	
	
}


}
