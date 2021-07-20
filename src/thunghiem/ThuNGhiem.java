package thunghiem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class ThuNGhiem extends JFrame {

	private JPanel contentPane;
	int y = 0;
	Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThuNGhiem frame = new ThuNGhiem();
//				//	frame.careate();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	//	ThuNGhiem frame = new ThuNGhiem();
		System.out.println("start");
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					 synchronized (this) {
							System.out.println("t1 -> "+i);
							notifyAll();
                            try {
                            	this.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					 try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			    
               
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				for (int i = 0; i < 10; i++) {
					synchronized (this) {
						this.notifyAll();

						try {
							System.out.println("wait");
							this.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("t2 -> "+i);
						this.notifyAll();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        
					}
				}

			}
		});
		thread2.start();

		thread1.start();



		
		System.out.println("stop");

		
	}
	/**
	 * Create the frame.
	 */
	public ThuNGhiem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					JPanel jPanel = new JPanel();
					if (i % 2 == 0)
						jPanel.setBackground(Color.blue);
					else
						jPanel.setBackground(Color.black);

					jPanel.setBounds(10, y, 200, 20);
					y += 20 + 2;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					contentPane.add(jPanel);
					contentPane.repaint();
					contentPane.validate();
					contentPane.revalidate();
					repaint();
					revalidate();
				}
			}
		});
		thread.start();

	}

	public void careate() {
		for (int i = 0; i < 10; i++) {
			JPanel jPanel = new JPanel();
			if (i % 2 == 0)
				jPanel.setBackground(Color.blue);
			else
				jPanel.setBackground(Color.black);

			jPanel.setBounds(10, y, 200, 20);
			y += 20 + 2;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contentPane.add(jPanel);
			contentPane.repaint();
			contentPane.validate();
			contentPane.revalidate();
			repaint();
			revalidate();

		}
	}

}
