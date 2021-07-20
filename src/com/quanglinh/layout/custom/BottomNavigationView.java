package com.quanglinh.layout.custom;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class BottomNavigationView extends JPanel implements IRelativeLayout, MouseListener {
	private RelativeLayout relativeLayout;
	private JComponent jComponent;
	private ArrayList<BottomNavigationItem> arrayList;
	private int count, sizeTitle;
	private Size sizeIcon;
	private Color colorBackgroundIclick = Color.yellow;
	private Color colorBackgroundUnClick = Color.WHITE;
	private Color colorTxtClick = Color.black;
	private Color colorTxtUnClick = Color.black;
	private int currentItem = 0;
    private OnTabSelectedListener onTabSelectedListener;
	public interface OnTabSelectedListener{
		void onTabSelected(int position);
	}
	
	public BottomNavigationView(JComponent jComponent, int count, Size sizeIcon, int sizeTitle) {
		this.jComponent = jComponent;
		this.count = count;
		this.sizeIcon = sizeIcon;
		this.sizeTitle = sizeTitle;
		relativeLayout = new RelativeLayout(jComponent, this);
		this.setFocusable(false);
		setLayout(null);
		arrayList = new ArrayList<BottomNavigationItem>();

		// setBackground(Color.white);
	}
	public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
		this.onTabSelectedListener = onTabSelectedListener;
	}
    public void setCurrentItem(int positon) {
    	currentItem = positon;
    	setBackGroundColorUnclick(colorBackgroundUnClick);
		setBackGroundColorClick(colorBackgroundIclick);
		setTexColorClick(colorTxtClick);
		setTexColorUnClick(colorTxtUnClick);
    }
    public int getCurrentItem() {
		return currentItem;
	}
    
	public void setAllTexColor(Color colorTitle) {
		for (int i = 0; i < arrayList.size(); i++) {
			arrayList.get(i).setMauTitle(colorTitle);

		}
		colorTxtClick = colorTitle;
		colorTxtUnClick = colorTitle;
	}

	public void setTexColorClick(Color colorTitle) {
		for (int i = 0; i < arrayList.size(); i++) {
			if(currentItem != i) {
				arrayList.get(i).setMauTitle(colorTxtUnClick);
			}else {
				arrayList.get(i).setMauTitle(colorTitle);

			}

		}
		colorTxtClick = colorTitle;
	}
	public void setTexColorUnClick(Color colorTitle) {
		for (int i = 0; i < arrayList.size(); i++) {
			if(currentItem != i) {
				arrayList.get(i).setMauTitle(colorTitle);
			}else {
				arrayList.get(i).setMauTitle(colorTxtClick);

			}

		}
		colorTxtUnClick = colorTitle;
	}

	public void setBackGroundColorClick(Color color) {
		for (int i = 0; i < arrayList.size(); i++) {
			if (i != currentItem) {
				arrayList.get(i).setBackgroundBottom(colorBackgroundUnClick);
			} else {
				arrayList.get(i).setBackgroundBottom(color);
			}

		}
		this.colorBackgroundIclick = color;
		
	}

	public void setBackGroundColorUnclick(Color colorBackGround) {
		for (int i = 0; i < arrayList.size(); i++) {
			if (i != currentItem) {
				arrayList.get(i).setBackgroundBottom(colorBackGround);
				arrayList.get(i).setImageButtonUnclick();
			} else {
				arrayList.get(i).setBackgroundBottom(colorBackgroundIclick);
				arrayList.get(i).setImageButtonClick();
			}

		}
		colorBackgroundUnClick = colorBackGround;
		
	}

	public void addItem(BottomNavigationItem bottomNavigationItem) {
		Rectangle rectangle = getBounds();
		int width = rectangle.width / count;
		bottomNavigationItem.setBounds(width * arrayList.size(), 0, width, rectangle.height);
		arrayList.add(bottomNavigationItem);
		bottomNavigationItem.setsizeBottom(width, rectangle.height, sizeIcon, sizeTitle);
//		bottomNavigationItem.setBackGroundBottom(Color.white);
		add(bottomNavigationItem);
		bottomNavigationItem.addMouseListener(this);

		if (arrayList.size() - 1 == currentItem) {
			// bottomNavigationItem.setMauTitle(colorBackgroundIclick);
			bottomNavigationItem.setBackgroundBottom(colorBackgroundIclick);
			bottomNavigationItem.setImageButtonClick();
			setBackGroundColorUnclick(colorBackgroundUnClick);
			setBackGroundColorClick(colorBackgroundIclick);
			setTexColorClick(colorTxtClick);
			setTexColorUnClick(colorTxtUnClick);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < arrayList.size(); i++) {
			if (e.getSource() == arrayList.get(i)) {
				currentItem = i;
				setBackGroundColorUnclick(colorBackgroundUnClick);
				setBackGroundColorClick(colorBackgroundIclick);
				setTexColorClick(colorTxtClick);
				setTexColorUnClick(colorTxtUnClick);
				arrayList.get(i).setImageButtonClick();
				if(onTabSelectedListener != null) {
					onTabSelectedListener.onTabSelected(i);
                   
				}
				
			}else {
				arrayList.get(i).setImageButtonUnclick();

			}

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
