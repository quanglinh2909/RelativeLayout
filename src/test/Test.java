package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.quanglinh.layout.custom.BottomNavigationItem;
import com.quanglinh.layout.custom.BottomNavigationView;
import com.quanglinh.layout.custom.Size;
import com.quanglinh.layout.custom.ViewPager;
import com.quanglinh.layout.custom.BottomNavigationView.OnTabSelectedListener;
import com.quanglinh.layout.custom.ViewPager.OnPageChangeCallback;

public class Test extends JFrame implements MouseListener, MouseMotionListener,MouseWheelListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBounds(0, 0, 700, 700);

		contentPane.setLayout(null);

		ViewPager viewPager = new ViewPager(contentPane);

		viewPager.layout_width(500);
		viewPager.layout_height(500);
		viewPager.setBackground(Color.white);
		viewPager.layout_centerHorizontal();
		viewPager.layout_marginTop(30);

		FagmentAdapter fagmentAdapter = new FagmentAdapter();
		viewPager.setAdapter(fagmentAdapter);

		BottomNavigationView bottomNavigationView = new BottomNavigationView(contentPane, 5, new Size(40, 40), 12);
		bottomNavigationView.layout_width(viewPager.getBounds().width);
		bottomNavigationView.layout_height(70);
		bottomNavigationView.layout_below(viewPager);
		bottomNavigationView.layout_centerHorizontal();
		bottomNavigationView.setBackground(Color.white);

		BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem("src/linh.png","src/outline_home_black_24dp.png",
				"Home");
		BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem("src/linh.png","src/outline_call_black_24dp.png",
				"Call");
		BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem("src/linh.png","src/outline_photo_camera_black_24dp.png",
				"Camera");
		BottomNavigationItem bottomNavigationItem4 = new BottomNavigationItem("src/linh.png","src/outline_home_black_24dp.png", "Bon");
		BottomNavigationItem bottomNavigationItem5 = new BottomNavigationItem("src/linh.png","src/outline_call_black_24dp.png", "Nam");

		bottomNavigationView.addItem(bottomNavigationItem1);
		bottomNavigationView.addItem(bottomNavigationItem2);
		bottomNavigationView.addItem(bottomNavigationItem3);
		bottomNavigationView.addItem(bottomNavigationItem4);
		bottomNavigationView.addItem(bottomNavigationItem5);

		bottomNavigationView.setAllTexColor(Color.black);
		bottomNavigationView.setBackGroundColorUnclick(Color.white);
		bottomNavigationView.setBackGroundColorClick(Color.red);
		bottomNavigationView.setTexColorClick(Color.yellow);

		viewPager.registerOnPageChangeCallback(new OnPageChangeCallback() {

			@Override
			public void onPageSelected(int position) {
				bottomNavigationView.setCurrentItem(position);
				bottomNavigationView.setBackGroundColorClick(viewPager.getFragment().getBackground());

				

			}
		});
		
		bottomNavigationView.setOnTabSelectedListener(new OnTabSelectedListener() {
			
			@Override
			public void onTabSelected(int position) {
				viewPager.setCurrentItem(position);
				
			}
		});
		
		

//		addMouseListener(this);
//		addMouseMotionListener(this);
		addMouseWheelListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("mouseDragged");

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// System.out.println("mouseMoved");

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		//System.out.println(e.getX());

		
	}
}
