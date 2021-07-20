package com.quanglinh.layout.custom;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class ViewPager extends JPanel implements IRelativeLayout{
	private RelativeLayout relativeLayout;
	private JComponent jComponent;
	private int currentItem = 0;
	private boolean checkChuyenPhai = false, chekcChuyenTrai = false;
	private boolean checkLeft, checkRight;
	private int x1 = 0, x2 = 0;
	int[] mangViTriFragment;
	private Fragment fragment[];
	OnPageChangeCallback onPageChangeCallback;
	public interface OnPageChangeCallback {
      void onPageSelected(int position);
	}
	public void registerOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
		this.onPageChangeCallback = onPageChangeCallback;
	}

	public ViewPager(JComponent jComponent) {
		this.jComponent = jComponent;
		relativeLayout = new RelativeLayout(jComponent, this);
		this.setFocusable(false);
		setLayout(null);

	}
	public Fragment getFragment() {
		return fragment[currentItem];
	}

	public void setCurrentItem(int item) {
		Rectangle rectangle = this.getBounds();

//		if(item > i) {
//			fragment[item].setBounds(0, 0, rectangle.width, rectangle.height);
//	        mangViTriFragment[item] = 0;
		int x = 0;
		for (int i = item; i >= 0; i--) {
			fragment[i].setBounds(x, 0, rectangle.width, rectangle.height);
			mangViTriFragment[i] = x;
			x -= rectangle.width;
		}
		x = 0;
		for (int i = item; i < fragment.length; i++) {
			fragment[i].setBounds(x, 0, rectangle.width, rectangle.height);
			mangViTriFragment[i] = x;
			x += rectangle.width;
		}

		currentItem = item;

		// System.out.println(Arrays.toString(mangViTriFragment));
	}

	public int getCurrentItem() {
		return currentItem;
	}

	private void sukienChuyenTrang(Fragment fragment[], Rectangle rectangle) {

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				// System.out.println(e.getX());
				x1 = e.getX();
				x2 = e.getX();
				checkChuyenPhai = false;
				chekcChuyenTrai = false;
				checkLeft = false;
				checkRight = false;

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);

				if (!checkChuyenPhai && currentItem < fragment.length && checkRight) {
					for (int i = 0; i < fragment.length; i++) {
						fragment[i].setBounds(mangViTriFragment[i], 0, rectangle.width, rectangle.height);
					}

				}
				if (checkChuyenPhai && currentItem < fragment.length && checkRight) {
					for (int i = 0; i < fragment.length; i++) {
						Rectangle rectangle = fragment[i].getBounds();
						int x = mangViTriFragment[i] - rectangle.width;
						fragment[i].setBounds(x, 0, rectangle.width, rectangle.height);
						mangViTriFragment[i] = x;
					}
					if(onPageChangeCallback != null) {
						onPageChangeCallback.onPageSelected(currentItem);

					}

				}

				if (!chekcChuyenTrai && currentItem > 0 && checkLeft) {
					for (int i = 0; i < fragment.length; i++) {
						fragment[i].setBounds(mangViTriFragment[i], 0, rectangle.width, rectangle.height);
					}

				}
				if (chekcChuyenTrai && currentItem >= 0 && checkLeft) {
					for (int i = 0; i < fragment.length; i++) {
						Rectangle rectangle = fragment[i].getBounds();
						int x = mangViTriFragment[i] + rectangle.width;
						fragment[i].setBounds(x, 0, rectangle.width, rectangle.height);
						mangViTriFragment[i] = x;
					}
					if(onPageChangeCallback != null) {
						onPageChangeCallback.onPageSelected(currentItem);

					}

				}
				// System.out.println(i);

			}
		});
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				if (x2 - e.getX() < rectangle.getWidth() / 2 && currentItem < fragment.length - 1
						&& x2 - e.getX() > 0) {
					for (int i = 0; i < fragment.length; i++) {
						Rectangle rectangle = fragment[i].getBounds();
						fragment[i].setBounds(rectangle.x - (x1 - e.getX()), 0, rectangle.width, rectangle.height);
					}
					checkRight = true;
				}
				if (x2 - e.getX() >= rectangle.getWidth() / 2 && checkChuyenPhai == false
						&& currentItem < fragment.length - 1) {
					checkChuyenPhai = true;
					currentItem++;

				}

				if (e.getX() - x2 < rectangle.getWidth() / 2 && currentItem > 0 && e.getX() - x2 > 0) {
					for (int i = 0; i < fragment.length; i++) {
						Rectangle rectangle = fragment[i].getBounds();
						fragment[i].setBounds(rectangle.x - (x1 - e.getX()), 0, rectangle.width, rectangle.height);
					}
					checkLeft = true;
					// System.out.println("ok");
				}
				if (e.getX() - x2 >= rectangle.getWidth() / 2 && chekcChuyenTrai == false && currentItem > 0) {
					chekcChuyenTrai = true;
					currentItem--;

				}
				x1 = e.getX();
			}
		});
	}

	public void setAdapter(FragmentStateAdapter adapter) {
		fragment = new Fragment[adapter.getItemCount()];
		mangViTriFragment = new int[fragment.length];
		Rectangle rectangle = this.getBounds();
		int x = 0;
		int y = 0;
		for (int i = 0; i < fragment.length; i++) {
			

			fragment[i] = adapter.createFragment(i);
			//fragment[i].setBundle(bundle);
			fragment[i].setSizeFragment(rectangle.width, rectangle.height);
			fragment[i].createView();
			add(fragment[i]);
			fragment[i].setBounds(x, y, rectangle.width, rectangle.height);
			mangViTriFragment[i] = x;
			x += rectangle.width;
		}

		sukienChuyenTrang(fragment, rectangle);

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
}
