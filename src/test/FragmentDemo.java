package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.quanglinh.layout.custom.ViewPager;
import com.quanglinh.layout.custom.ViewPager.OnPageChangeCallback;

public class FragmentDemo extends JFrame {

	private JPanel contentPane;
	public static FragmentDemo fragmentDemo ;
	JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FragmentDemo frame = new FragmentDemo();
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
	public FragmentDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		fragmentDemo = FragmentDemo.this;
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(30, 29, 372, 200);
		contentPane.add(panel);
		panel.setLayout(null);

		ViewPager viewPager = new ViewPager(panel);

		viewPager.layout_width(372);
		viewPager.layout_height(200);
		viewPager.setBackground(Color.white);
		viewPager.layout_centerHorizontal();

//		FagmentAdapter fagmentAdapter = new FagmentAdapter();
//		viewPager.setAdapter(fagmentAdapter);
		ArrayList<Fragment1> fragment1s = new ArrayList<Fragment1>();
		for (int i = 0; i < 6; i++) {
			Fragment1 fragment1 = Fragment1.createFragment("Item " + i);
			if (i % 2 == 0) {
				fragment1.setBackground(Color.YELLOW);
			} else {
				fragment1.setBackground(Color.BLUE);

			}
			fragment1s.add(fragment1);
		}
		FragmentAdapterDemo adapterDemo = new FragmentAdapterDemo(fragment1s);
		viewPager.setAdapter(adapterDemo);

		 btnNewButton = new JButton("New button");
		
		btnNewButton.setBounds(75, 240, 89, 23);
		contentPane.add(btnNewButton);
		viewPager.registerOnPageChangeCallback(new OnPageChangeCallback() {

			@Override
			public void onPageSelected(int position) {
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fragment1s.get(position).button.setText("ok "+position);
					}
				});
			}
		});
	}
	public void setText(String t) {
		btnNewButton.setText(t);
	}
	
}
