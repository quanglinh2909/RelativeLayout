package com.quanglinh.layout.custom;

import javax.swing.JComponent;

public interface IRelativeLayout {
	public int getMatch_parent_with();
	public int getMatch_parent_height() ;
	public void layout_width(int with);
	public void layout_height(int height);
	public void layout_below(JComponent componentTop);
	public void layout_above(JComponent componentTop);
	
	public void layout_marginTop(int top);
	public void layout_marginLeft(int left) ;
	public void layout_marginRight(int right) ;
	public void layout_marginBottom(int bottom);
	public void layout_alignParentRight() ;
	public void layout_alignBottom() ;
	
	public void layout_toLeftOf(JComponent component) ;
	
	public void layout_toRightOf(JComponent component);
	public void layout_centerVertical() ;
	public void layout_centerHorizontal();
}
