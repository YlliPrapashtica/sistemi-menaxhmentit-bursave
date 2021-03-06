package Voice;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Caller extends JFrame {

	private JButton btnCall, btnDeny;
	private JLabel lbTime, lbUser;
	private boolean agreedState = false;
	private String yourIP;
	private PlayRingtone playRingtone;

	private RecorderAudio r;
	private PlayerAudio p;
	private RunTimeCall rtc = new RunTimeCall();
	
	public Caller(String yourname, String yourIP) {
		this.yourIP = yourIP;
		initialize();
		this.lbUser.setText(yourname);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setType(Type.POPUP);
		this.setTitle("Calling");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Caller.class.getResource("/image/callphone.png")));
		this.setResizable(false);
		this.getContentPane().setBackground(SystemColor.controlDkShadow);
		this.setBounds(100, 100, 482, 336);
		this.getContentPane().setLayout(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				releaseMemory();
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(180, 180, 180)));
		panel.setBackground(SystemColor.controlLtHighlight);
		panel.setBounds(123, 193, 234, 86);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setFocusable(true);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlLtHighlight);
		panel_1.setBorder(new LineBorder(new Color(180, 180, 180)));
		panel_1.setBounds(8, 8, 216, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnDeny = new JButton("");
		btnDeny.setBounds(140, 5, 60, 60);
		panel_1.add(btnDeny);
		btnDeny.setBackground(SystemColor.controlLtHighlight);
		btnDeny.setBorderPainted(false);
		btnDeny.setOpaque(false);
		btnDeny.setContentAreaFilled(false);
		btnDeny.setIcon(new ImageIcon(Caller.class.getResource("/image/calldeny.png")));
		btnDeny.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				releaseMemory();
			}
		});

		btnCall = new JButton("");
		btnCall.setBounds(20, 5, 60, 60);
		panel_1.add(btnCall);
		btnCall.setBackground(SystemColor.controlLtHighlight);
		btnCall.setBorderPainted(false);
		btnCall.setOpaque(false);
		btnCall.setContentAreaFilled(false);
		btnCall.setIcon(new ImageIcon(Caller.class.getResource("/image/callphone.png")));
		btnCall.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (!agreedState) {
					//playRingtone.stop();
					agreedState = true;
					startRecoderAudio(true);
					startPlayerAudio(true);
					btnCall.setVisible(false);
					btnDeny.setLocation(75, 5);
				}
			}
		});

		JLabel lbAvatar = new JLabel();
		lbAvatar.setIcon(new ImageIcon(Caller.class.getResource("/image/person.png")));
		lbAvatar.setBounds(160, 23, 160, 160);
		this.getContentPane().add(lbAvatar);

		lbUser = new JLabel("");
		lbUser.setForeground(SystemColor.controlHighlight);
		lbUser.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbUser.setBounds(22, 23, 295, 25);
		this.getContentPane().add(lbUser);

		lbTime = new JLabel("00:00:00");
		lbTime.setForeground(SystemColor.controlHighlight);
		lbTime.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbTime.setBounds(22, 59, 97, 25);
		this.getContentPane().add(lbTime);
	}

	public void setVisibleFrameCall(boolean b) {
		this.setVisible(b);
		if (!b)
			this.dispose();
	}

	private class RunTimeCall extends Thread {
		public RunTimeCall() {
		}

		public void run() {
			for (int i = 0; i < 24; i++)
				for (int j = 0; j < 60; j++)
					for (int k = 0; k < 60; k++) {
						String h = parseOneToTwo(i);
						String m = parseOneToTwo(j);
						String s = parseOneToTwo(k);
						lbTime.setText(h + ":" + m + ":" + s);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}
					}
		}

		private String parseOneToTwo(int i) {
			String s = String.valueOf(i);
			if (s.length() == 1)
				s = "0" + s;
			return s;
		}
	}

	public void startPlayRingtone(boolean state) {
		if (state) {
			playRingtone = new PlayRingtone();
			playRingtone.start();
		} else {
			playRingtone.interrupt();
			//playRingtone.stop();
		}
	}

	public void startRecoderAudio(boolean state) {
		btnCall.setVisible(false);
		btnDeny.setLocation(75, 5);
		r = new RecorderAudio(yourIP, Config.Config.portUDPAudio);
		r.start();
	}

	public void startPlayerAudio(boolean state) {
		p = new PlayerAudio(Config.Config.portUDPAudio);
		p.start();
		rtc.start();
	}

	public void releaseMemory() {
		try {
			r.closeSocket();			
			p.closeSocket();
		} catch (Exception e) {
		}finally {
			//r.stop();
			//p.stop();
		}
		dispose();
	}
}
