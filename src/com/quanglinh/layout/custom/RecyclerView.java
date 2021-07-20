package com.quanglinh.layout.custom;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class RecyclerView extends JPanel implements IRelativeLayout, MouseListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RelativeLayout relativeLayout;
	private JComponent jComponent;
	private List<ItemRecyclerView> liViewHolders = new ArrayList<ItemRecyclerView>();
	@SuppressWarnings("unused")
	private Adapter<ItemRecyclerView> adapterMain;
	private OnclickRecylerView onclickRecylerView;
	private AnimationDelete animationDeleteIn;
	private int xMoiCham = 0, vitriCham = 0;
	private boolean animationDelete = false;
	private Color colorBackground;
	private boolean animationScale = false;
	private int motso = 0;
	private Timer timer;
	private boolean checkCreate;
	public RecyclerView(JComponent jComponent) {
		this.jComponent = jComponent;
		relativeLayout = new RelativeLayout(jComponent, this);
		setLayout(null);
		 timer = new Timer(200, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < liViewHolders.size(); i++) {
						Rectangle rectangle = liViewHolders.get(i).getBounds();

						if (rectangle.x == 0) {
							if (i % 2 == 0) {
								liViewHolders.get(i).setBounds(rectangle.x - 30, rectangle.y, rectangle.width,
										rectangle.height);

							} else {
								liViewHolders.get(i).setBounds(rectangle.x + 30, rectangle.y, rectangle.width,
										rectangle.height);

							}
						} else {
							if (rectangle.x == -30) {
								liViewHolders.get(i).setBounds(rectangle.x + 60, rectangle.y, rectangle.width,
										rectangle.height);

							} else {
								liViewHolders.get(i).setBounds(rectangle.x - 60, rectangle.y, rectangle.width,
										rectangle.height);

							}
						}

					}
					motso++;

					if(motso == 3) {
						timer.stop();

						for (int i = 0; i < liViewHolders.size(); i++) {
							Rectangle rectangle = liViewHolders.get(i).getBounds();

							liViewHolders.get(i).setBounds(0, rectangle.y, rectangle.width,
									rectangle.height);
						}
						motso = 0;

					}
				}
			});
		addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				Rectangle rectangle1 = getBounds();
				Rectangle rectangle2 = liViewHolders.get(liViewHolders.size() - 1).getBounds();

				if(checkCreate) {
					animationDefaul(e, rectangle1, rectangle2);
					if(animationScale) {
	                 if(!timer.isRunning()) {
	                	 timer.start();
	                 }
					}
				}

			}

		});
	}

	

	private void animationDefaul(MouseWheelEvent e, Rectangle rectangle1, Rectangle rectangle2) {
		int y1 = rectangle1.height;
		int y2 = rectangle2.height;
		if (e.getWheelRotation() == 1 && rectangle2.y > y1 - y2) {
			for (int i = 0; i < liViewHolders.size(); i++) {
				Rectangle rectangle = liViewHolders.get(i).getBounds();
				liViewHolders.get(i).setBounds(rectangle.x, rectangle.y - 10, rectangle.width, rectangle.height);
			}
		}
		if (e.getWheelRotation() == -1 && liViewHolders.get(0).getBounds().y < 0) {
			for (int i = 0; i < liViewHolders.size(); i++) {
				Rectangle rectangle = liViewHolders.get(i).getBounds();

				liViewHolders.get(i).setBounds(rectangle.x, rectangle.y + 10, rectangle.width, rectangle.height);
			}
		}

	}

	public interface Observer {
		void update(int count);
	}

	public interface OnclickRecylerView {
		void onclicklistener(int position);
	}

	public interface AnimationDelete {
		void animationDelete(int position);
	}

	public static abstract class Adapter<VH extends ItemRecyclerView> {
		Observer observer;

		public abstract VH onCreateViewHolder(int viewType);

		public abstract void onBindViewHolder(VH holder, int position);

		public abstract int getItemCount();

		public void notifyDataSetChanged() {
//			System.out.println(getItemCount());
			observer.update(getItemCount());
		}

		public void getObsever(Observer observer) {
			this.observer = observer;
		}

		public int getItemViewType(int position) {
			return 0;
		}
	}

	public void setAdapterLiner(Adapter<ItemRecyclerView> adapter,int range) {
		setDataRecylerViewLiner(adapter, range);
		this.adapterMain = adapter;

		adapter.getObsever(new Observer() {

			@Override
			public void update(int count) {

				setDataRecylerViewLiner(adapter,range);

			}
		});


	}
	public void setAdapterLiner(Adapter<ItemRecyclerView> adapter) {
		setDataRecylerViewLiner(adapter, 0);
		this.adapterMain = adapter;

		adapter.getObsever(new Observer() {

			@Override
			public void update(int count) {

				setDataRecylerViewLiner(adapter,0);

			}
		});


	}
	
	public void setAdapterGrid(Adapter<ItemRecyclerView> adapter,int colum,int rangeRow,int rangeColum) {
		setDataRecylerViewGrid(adapter, colum,rangeRow,rangeColum);
		this.adapterMain = adapter;

		adapter.getObsever(new Observer() {

			@Override
			public void update(int count) {

				setDataRecylerViewGrid(adapter, colum,rangeRow,rangeColum);

			}
		});

	}
	
	public void setAdapterGrid(Adapter<ItemRecyclerView> adapter,int colum) {
		setDataRecylerViewGrid(adapter, colum,0,0);
		this.adapterMain = adapter;

		adapter.getObsever(new Observer() {

			@Override
			public void update(int count) {

				setDataRecylerViewGrid(adapter, colum,0,0);

			}
		});

	}
    
    
	private void setDataRecylerViewGrid(Adapter<ItemRecyclerView> adapter, int colum, int rangeRow, int rangeColum) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				checkCreate = false;
				removeAll();
				liViewHolders.clear();
				
				int itemCount = adapter.getItemCount();
				Rectangle rectangleMain = getBounds();
				int height = 0;
				int wit = 0;
				int with = Math.round((rectangleMain.width/colum)- ((colum-1)*rangeColum));
				int count = 0;
				for (int i = 0; i < itemCount; i++) {
					int viewType = adapter.getItemViewType(i);
					
					ItemRecyclerView viewHolder = adapter.onCreateViewHolder(viewType);
					liViewHolders.add(viewHolder);
					add(viewHolder);
					adapter.onBindViewHolder(viewHolder, i);

					int chieuCao = viewHolder.getHeight();
					viewHolder.setBounds(wit, height , with, chieuCao);
				

					

					wit+= with+rangeColum;
					count++;

					if(count >=colum) {
						height += chieuCao+rangeRow;
						wit = 0;
		               count=0;
					}
		           
					
					
					viewHolder.addMouseListener(RecyclerView.this);
					viewHolder.addMouseMotionListener(RecyclerView.this);
					if(i == (itemCount-1)) {
						checkCreate = true;
					}
				}

				// revalidate();
				repaint();
				
			}
		}).start();
	}



	private void setDataRecylerViewLiner(Adapter<ItemRecyclerView> adapter,int range) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				removeAll();
				checkCreate = false;
				liViewHolders.clear();
				int itemCount = adapter.getItemCount();
				Rectangle rectangleMain = getBounds();
				int height = 0;
				for (int i = 0; i < itemCount; i++) {
					int viewType = adapter.getItemViewType(i);
					
					ItemRecyclerView viewHolder = adapter.onCreateViewHolder(viewType);
					liViewHolders.add(viewHolder);
					add(viewHolder);
					adapter.onBindViewHolder(viewHolder, i);

					int chieuCao = viewHolder.getHeight();
					viewHolder.setBounds(0, height , rectangleMain.width, chieuCao);
					height += chieuCao+ range;
					
					viewHolder.addMouseListener(RecyclerView.this);
					viewHolder.addMouseMotionListener(RecyclerView.this);
					
					if(i == (itemCount - 1)) {
						checkCreate = true;
					}
				}

				// revalidate();
				repaint();
				
			}
		}).start();
		


	}

	public void setonclicklistener(OnclickRecylerView onclickRecylerView) {
		this.onclickRecylerView = onclickRecylerView;
	}

	public void setAnimationDelete(AnimationDelete animationDeleteIn) {
		animationDelete = true;
		this.animationDeleteIn = animationDeleteIn;
	}

	public void unAnimationDelete() {
		animationDelete = false;
	}

	public void setAnimationScale() {
		animationScale = true;
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

	}

	@Override
	public void mousePressed(MouseEvent e) {
		xMoiCham = e.getX();
		colorBackground = getBackground();
		for (int i = 0; i < liViewHolders.size(); i++) {
			if (e.getSource() == liViewHolders.get(i)) {
				vitriCham = i;
				if (onclickRecylerView != null) {
					onclickRecylerView.onclicklistener(i);
				}
				break;
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (animationDelete) {
			Rectangle rectangle = liViewHolders.get(vitriCham).getBounds();
			int haiPhan3 = rectangle.width / 3 * 2;
			if (rectangle.x < -haiPhan3) {
				remove(liViewHolders.get(vitriCham));
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				animationDeleteIn.animationDelete(vitriCham);
				repaint();
			} else {
				liViewHolders.get(vitriCham).setBounds(0, rectangle.y, rectangle.width, rectangle.height);

			}

			setBackground(colorBackground);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (animationDelete) {
			for (int i = 0; i < liViewHolders.size(); i++) {
				if (e.getSource() == liViewHolders.get(i) && xMoiCham - e.getX() > 0) {
					setBackground(Color.red);
					Rectangle rectangle = liViewHolders.get(i).getBounds();
					liViewHolders.get(i).setBounds(rectangle.x - 5, rectangle.y, rectangle.width, rectangle.height);
					break;
				}
			}
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		

	}
}
