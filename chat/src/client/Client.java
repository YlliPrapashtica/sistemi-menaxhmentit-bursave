package client;

import User.User;
import User.UserRenderer;
import video.VideoCall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;

public class Client {

	private JFrame frame;
	private JList<User> listUser = new JList<User>();
	private JTextField txtIPSV;
	private JPanel pnListUser;
	private JPanel pnDisplay;
	private JLabel lbMyAccount;
	private JPanel pnSticker;
	private JButton btnReply;
	private JTextArea txtChat;
	private JScrollPane scrollPaneDisplay;

	private DefaultListModel<User> listModelUser = new DefaultListModel<User>();
	private static DataInputStream din = null;
	private static DataOutputStream dout = null;
	private static Socket socket = null;
	private static String SERVER_IP = "127.0.0.1";
	private boolean activityState = true;

	private User myAccount = null;
	private User yourAccount = null;
	private String[] stickerCode = { "stc01", "stc02", "stc03", "stc04", "stc05", "stc06", "stc07", "stc08" };

	

	
	public Client(User user) {
		myAccount = user;
		SERVER_IP=user.getServerIP();
		initialize();
		txtIPSV.setText(SERVER_IP);
		lbMyAccount.setText(user.getName());
		txtIPSV.setText(user.getServerIP());
		ObjectThead objThread = new ObjectThead();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Client.class.getResource("/image/Chat-PNG.png")));
		frame.setTitle("Chat");
		frame.setBounds(100, 100, 715, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel pnFooter = new JPanel();
		pnFooter.setBackground(new Color(190, 153, 100));
		pnFooter.setBounds(0, 407, 709, 27);
		frame.getContentPane().add(pnFooter);
		pnFooter.setLayout(null);

		
		pnSticker = new JPanel();
		pnSticker.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		pnSticker.setBackground(Color.WHITE);
		pnSticker.setBounds(217, 223, 295, 125);
		pnSticker.setVisible(false);
		frame.getContentPane().add(pnSticker);
		pnSticker.setLayout(new GridLayout(2, 4, 5, 5));

		JButton btnSticker1 = new JButton("");
		btnSticker1.setBorderPainted(false);
		btnSticker1.setBackground(Color.WHITE);
		btnSticker1.setIcon(new ImageIcon(Client.class.getResource("/image/sticker/1.png")));
		pnSticker.add(btnSticker1);
		btnSticker1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// send sticker to your account
				try {
					if (yourAccount != null)
						dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + stickerCode[0]);
					switchVisibleStickerPanel();
				} catch (Exception e1) {
				}
			}
		});

		JButton btnSticker2 = new JButton("");
		btnSticker2.setBorderPainted(false);
		btnSticker2.setIcon(new ImageIcon(Client.class.getResource("/image/sticker/2.png")));
		btnSticker2.setBackground(Color.WHITE);
		pnSticker.add(btnSticker2);
		btnSticker2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (yourAccount != null)
						dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + stickerCode[1]);
					switchVisibleStickerPanel();
				} catch (Exception e1) {
				}
			}
		});

		JButton btnSticker3 = new JButton("");
		btnSticker3.setBorderPainted(false);
		btnSticker3.setIcon(new ImageIcon(Client.class.getResource("/image/sticker/3.png")));
		btnSticker3.setBackground(Color.WHITE);
		pnSticker.add(btnSticker3);
		btnSticker3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (yourAccount != null)
						dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + stickerCode[2]);
					switchVisibleStickerPanel();
				} catch (Exception e1) {
				}
			}
		});

		JButton btnSticker4 = new JButton("");
		btnSticker4.setBorderPainted(false);
		btnSticker4.setIcon(new ImageIcon(Client.class.getResource("/image/sticker/4.png")));
		btnSticker4.setBackground(Color.WHITE);
		pnSticker.add(btnSticker4);
		btnSticker4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (yourAccount != null)
						dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + stickerCode[3]);
					switchVisibleStickerPanel();
				} catch (Exception e1) {
				}
			}
		});

		JButton btnSticker5 = new JButton("");
		btnSticker5.setBorderPainted(false);
		btnSticker5.setIcon(new ImageIcon(Client.class.getResource("/image/sticker/5.png")));
		btnSticker5.setBackground(Color.WHITE);
		pnSticker.add(btnSticker5);
		btnSticker5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (yourAccount != null)
						if (yourAccount != null)
							dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + stickerCode[4]);
					switchVisibleStickerPanel();
				} catch (Exception e1) {
				}
			}
		});

		JButton btnSticker6 = new JButton("");
		btnSticker6.setBorderPainted(false);
		btnSticker6.setIcon(new ImageIcon(Client.class.getResource("/image/sticker/6.png")));
		btnSticker6.setBackground(Color.WHITE);
		pnSticker.add(btnSticker6);
		btnSticker6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (yourAccount != null)
						dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + stickerCode[5]);
					switchVisibleStickerPanel();
				} catch (Exception e1) {
				}
			}
		});

		JButton btnSticker7 = new JButton("");
		btnSticker7.setBorderPainted(false);
		btnSticker7.setIcon(new ImageIcon(Client.class.getResource("/image/sticker/7.png")));
		btnSticker7.setBackground(Color.WHITE);
		pnSticker.add(btnSticker7);
		btnSticker7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + stickerCode[6]);
					switchVisibleStickerPanel();
				} catch (Exception e1) {
				}
			}
		});

		JButton btnSticker8 = new JButton("");
		btnSticker8.setBorderPainted(false);
		btnSticker8.setIcon(new ImageIcon(Client.class.getResource("/image/sticker/8.png")));
		btnSticker8.setBackground(Color.WHITE);
		pnSticker.add(btnSticker8);
		btnSticker8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (yourAccount != null)
						dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + stickerCode[7]);
					switchVisibleStickerPanel();
				} catch (Exception e1) {
				}
			}
		});

		JPanel pnDisplay = new JPanel();
		pnDisplay.setBackground(SystemColor.controlLtHighlight);
		pnDisplay.setBorder(new LineBorder(SystemColor.controlShadow));
		pnDisplay.setBounds(207, 82, 487, 178);
		frame.getContentPane().add(pnDisplay);
		pnDisplay.setLayout(null);

		scrollPaneDisplay = new JScrollPane();
		scrollPaneDisplay.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDisplay.setBounds(10, 10, 467, 158);
		scrollPaneDisplay.setBackground(Color.WHITE);
		pnDisplay.add(scrollPaneDisplay);

		JPanel pnChat = new JPanel();
		pnChat.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		pnChat.setBackground(SystemColor.control);
		pnChat.setBounds(207, 271, 489, 125);
		frame.getContentPane().add(pnChat);
		pnChat.setLayout(null);

		JPanel pnChatChild = new JPanel();
		pnChatChild.setBorder(new LineBorder(SystemColor.controlShadow));
		pnChatChild.setBackground(SystemColor.controlLtHighlight);
		pnChatChild.setBounds(10, 10, 469, 102);
		pnChat.add(pnChatChild);
		pnChatChild.setLayout(null);

		JButton btnAddFile = new JButton("");
		btnAddFile.setBounds(0, 68, 100, 34);
		pnChatChild.add(btnAddFile);
		btnAddFile.setSelectedIcon(null);
		btnAddFile.setIcon(new ImageIcon(Client.class.getResource("/image/iconattach1.png")));
		btnAddFile.setForeground(Color.GRAY);
		btnAddFile.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		btnAddFile.setBackground(SystemColor.text);

		JButton btnSticker = new JButton("");
		btnSticker.setIcon(new ImageIcon(Client.class.getResource("/image/camera1.png")));
		btnSticker.setBounds(99, 68, 100, 34);
		pnChatChild.add(btnSticker);
		btnSticker.setForeground(Color.GRAY);
		btnSticker.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		btnSticker.setBackground(SystemColor.text);
		btnSticker.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				switchVisibleStickerPanel();
			}
		});

		btnReply = new JButton("Reply");
		btnReply.setBounds(385, 73, 74, 23);
		pnChatChild.add(btnReply);
		btnReply.setForeground(SystemColor.text);
		btnReply.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnReply.setBackground(SystemColor.textHighlight);

		btnReply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (yourAccount != null && txtChat.getText().equals("") == false)
						dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + txtChat.getText());
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				txtChat.setText("");
			}
		});

		JLabel lbPressEnter = new JLabel("Press Enter to send");
		lbPressEnter.setBounds(246, 77, 106, 15);
		pnChatChild.add(lbPressEnter);
		lbPressEnter.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lbPressEnter.setForeground(SystemColor.textInactiveText);
		lbPressEnter.setBackground(SystemColor.control);

		JCheckBox cbPressEnter = new JCheckBox("");
		cbPressEnter.setBounds(358, 75, 21, 21);
		pnChatChild.add(cbPressEnter);
		cbPressEnter.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		cbPressEnter.setBackground(SystemColor.text);
		cbPressEnter.setEnabled(false);
		cbPressEnter.setSelected(true);
		cbPressEnter.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel pnChatChildText = new JPanel();
		pnChatChildText.setBackground(SystemColor.controlLtHighlight);
		pnChatChildText.setBounds(0, 0, 469, 69);
		pnChatChild.add(pnChatChildText);
		pnChatChildText.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		pnChatChildText.setLayout(null);

		txtChat = new JTextArea();
		txtChat.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		txtChat.setLineWrap(true);
		txtChat.setBounds(5, 5, 458, 59);
		txtChat.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (e.isShiftDown()) {
						txtChat.setText(txtChat.getText() + "\n");
					} else {
						try {
							if (yourAccount != null && txtChat.getText().equals("") == false)
								dout.writeUTF(
										myAccount.getName() + "-" + yourAccount.getName() + "-" + txtChat.getText());
						} catch (Exception e1) {
							System.out.println(e1.getMessage());
						}
					}
					txtChat.setText("");
				}
			}
		});

		JScrollPane scrollPaneChat = new JScrollPane(txtChat);
		scrollPaneChat.setBounds(5, 5, 458, 59);
		scrollPaneChat.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnChatChildText.add(scrollPaneChat);

		pnListUser = new JPanel();
		pnListUser.setBounds(10, 82, 187, 314);
		pnListUser.setLayout(new BorderLayout(0, 0));
		pnListUser.add(new JScrollPane(listUser = createListUsers(listModelUser)));
		frame.getContentPane().add(pnListUser);

		JPanel pnHeader = new JPanel();
		pnHeader.setBackground(new Color(190, 153, 100));
		pnHeader.setBounds(0, 0, 726, 75);
		frame.getContentPane().add(pnHeader);
		pnHeader.setLayout(null);

		JPanel pnControl = new JPanel();
		pnControl.setBackground(SystemColor.controlLtHighlight);
		pnControl.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		pnControl.setBounds(571, 11, 123, 45);
		pnHeader.add(pnControl);
		pnControl.setLayout(null);

		JPanel pnControlChild = new JPanel();
		pnControlChild.setBounds(5, 5, 112, 35);
		pnControl.add(pnControlChild);
		pnControlChild.setBackground(SystemColor.controlLtHighlight);
		pnControlChild.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		pnControlChild.setLayout(null);

		JButton btnVoiceCall = new JButton("");
		btnVoiceCall.setIcon(new ImageIcon(Client.class.getResource("/image/call.png")));
		btnVoiceCall.setBounds(0, 0, 55, 35);
		btnVoiceCall.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		btnVoiceCall.setBackground(SystemColor.controlLtHighlight);
		pnControlChild.add(btnVoiceCall);
		btnVoiceCall.addActionListener(new ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					if (yourAccount != null) {
						
						dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + Config.Config.tokenVoiceCall);
						voice.Caller caller = new voice.Caller(yourAccount.getName(), yourAccount.getMyIP());
						caller.setVisibleFrameCall(true);
						caller.startRecoderAudio(true);
						caller.startPlayerAudio(true);
					}
				} catch (java.io.IOException e1) {
					// e1.printStackTrace();
				}
			}
		});

		JButton btnVideoCall = new JButton("");
		btnVideoCall.setIcon(new ImageIcon(Client.class.getResource("/image/video1.png")));
		btnVideoCall.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		btnVideoCall.setBackground(Color.WHITE);
		btnVideoCall.setBounds(55, 0, 60, 35);
		pnControlChild.add(btnVideoCall);
		btnVideoCall.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (yourAccount != null) {
					VideoCall videoCall = new VideoCall(yourAccount.getName(), yourAccount.getMyIP());
					videoCall.startRecorderVideo();
					videoCall.startPlayerVideo();
					try {
						dout.writeUTF(myAccount.getName() + "-" + yourAccount.getName() + "-" + Config.Config.tokenVideoCall);
					} catch (IOException e1) {

					}
				}
			}
		});

	

		JLabel lbIPSV = new JLabel("IPSV:");
		lbIPSV.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lbIPSV.setBounds(15, 6, 30, 24);

		txtIPSV = new JTextField();
		txtIPSV.setEditable(false);
		txtIPSV.setHorizontalAlignment(SwingConstants.CENTER);
		txtIPSV.setText("192.168.1.5");
		txtIPSV.setBounds(50, 5, 120, 25);

		JLabel lbLogo = new JLabel("");
		lbLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogo.setForeground(SystemColor.text);
		lbLogo.setIcon(new ImageIcon(Client.class.getResource("/image/user1.png")));
		lbLogo.setBounds(10, 8, 60, 60);
		pnHeader.add(lbLogo);

		lbMyAccount = new JLabel("");
		lbMyAccount.setForeground(SystemColor.controlLtHighlight);
		lbMyAccount.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
		lbMyAccount.setBounds(85, 10, 279, 53);
		pnHeader.add(lbMyAccount);

		this.frame.setLocation(500, 100);
		this.frame.setVisible(true);
	}

	private class MessageThread extends Thread {
		public void run() {
			try {
				socket = new java.net.Socket(SERVER_IP, Config.Config.portTCPMessage);
				din = new java.io.DataInputStream(socket.getInputStream());
				dout = new java.io.DataOutputStream(socket.getOutputStream());

				pnDisplay = new javax.swing.JPanel();
				pnDisplay.setLayout(new javax.swing.BoxLayout(pnDisplay, javax.swing.BoxLayout.Y_AXIS));
				pnDisplay.setBackground(java.awt.Color.white);
				scrollPaneDisplay.setViewportView(pnDisplay);

				while (true) {
					try {
						String dataReceived = din.readUTF();
						String[] arr = dataReceived.split("-");
						String senderName = arr[0];
						String receiverName = arr[1];
						String message = arr[2];

						if (message.equals(Config.Config.tokenVoiceCall)) {
							for (int i = 0; i < listModelUser.size(); i++) {
								User.User user = listModelUser.get(i);
								if (user.getName().equals(senderName)
										&& senderName.equals(myAccount.getName()) == false) {
									voice.Caller caller = new voice.Caller(user.getName(), user.getMyIP());
									caller.setVisibleFrameCall(true);
									caller.startPlayRingtone(true);
								}
							}

						} else if (message.equals(Config.Config.tokenVideoCall)) {
							for (int i = 0; i < listModelUser.size(); i++) {
								User.User user = listModelUser.get(i);
								if (user.getName().equals(senderName)
										&& senderName.equals(myAccount.getName()) == false) {
									video.VideoCall videoCall = new video.VideoCall(user.getName(), user.getMyIP());
									videoCall.playRingtone(true);
								}
							}

						} else {
							if ((yourAccount != null) && (senderName.equals(yourAccount.getName())
									|| senderName.equals(myAccount.getName()))) {
								setMessageInPanel(senderName, message);
							}
						}
					} catch (java.io.IOException io) {
						// throw io;
					}
					if (!activityState) {
						break;
					}
				}
				din.close();
				dout.close();
				socket.close();
			} catch (java.net.UnknownHostException ee) {
				System.out.println("No Host");
			} catch (java.io.IOException e) {
				System.out.println(e.getMessage());
			}
		}

		private void setMessageInPanel(String senderName, String message) {
			String msg =message;
			msg = convertStringToMultiLine(msg);
			JLabel lbName = new JLabel(senderName);
			JLabel lbMsg = new JLabel(msg);
			for (int i = 0; i < 8; i++) {
				if (message.equals(stickerCode[i])) {
					lbMsg.setText("");
					lbMsg.setIcon(new ImageIcon(Client.class.getResource("/image/" + String.valueOf(i + 1) + ".png")));
				}
			}

			if (senderName.equals(myAccount.getName())) {
				lbName.setForeground(new Color(0x29, 0x80, 0xb9));
			} else {
				lbName.setForeground(new Color(0xd3, 0x54, 0x00));
			}
			lbName.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
			lbName.setBorder(new EmptyBorder(0, 10, 0, 0));
			lbMsg.setBorder(new EmptyBorder(0, 10, 15, 2));
			lbMsg.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));

			pnDisplay.add(lbName);
			pnDisplay.add(lbMsg);
			scrollPaneDisplay.getVerticalScrollBar().getModel()
					.setValue(scrollPaneDisplay.getVerticalScrollBar().getMaximum());
			pnDisplay.setVisible(false);
			pnDisplay.setVisible(true);
		}
	}

	
	private class ObjectThead extends Thread {
		Socket socket = null;

		public ObjectThead() {
			try {
				this.socket = new Socket(SERVER_IP, Config.Config.portTCPObject);
			} catch (IOException e) {
				System.out.println("Object doesn't init successfully");
			}
			this.start();
			MessageThread MessageThread = new MessageThread();
			MessageThread.start();
		}

		public void run() {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(this.socket.getOutputStream());
				oos.flush();
				oos.writeObject(myAccount);
				oos.flush();
				ObjectInputStream ois;
				while (true) {
					try {
						
						ois = new ObjectInputStream(this.socket.getInputStream());
						listModelUser = (DefaultListModel<User>) ois.readObject();

						listUser = createListUsers(listModelUser);
						updateListUser(createListUsers(listModelUser));
						if (!activityState)
							break;
					} catch (Exception e) {
						// e.printStackTrace();
					}
				}
				ois.close();
				oos.close();
				socket.close();
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}
	}

	private JList<User> createListUsers(DefaultListModel<User> model) {
		JList<User> list = new JList<User>(model);
		list.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		list.setBackground(SystemColor.controlLtHighlight);
		list.setCellRenderer(new UserRenderer());
		return list;
	}

	private void updateListUser(JList<User> users) {
		listUser = users;
		pnListUser.removeAll();
		listUser.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent evt) {
				if (evt.getValueIsAdjusting()) {
					yourAccount = listUser.getSelectedValue();
					pnDisplay.removeAll();
					pnDisplay.setVisible(false);
					pnDisplay.setVisible(true);
				}
			}
		});
		pnListUser.add(new JScrollPane(listUser));
		pnListUser.setVisible(false);
		pnListUser.setVisible(true);
	}

	private void switchVisibleStickerPanel() {
		pnSticker.setVisible(!pnSticker.isVisible());
	}

	private String convertStringToMultiLine(String s) {
		String msg = "";
		String[] arr = s.split(" ");
		for (int i = 0; i < arr.length; i++) {
			msg += arr[i] + " ";
			if ((i >= 10) && (i % 10 == 0))
				msg += "<br>";
		}
		msg = "<html>" + msg + "</html>";
		return msg;
	}
}
