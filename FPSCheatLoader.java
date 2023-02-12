// @author conspiracy | https://conspiracy.moe/

package CheatLoader;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class FPSCheatLoader extends AudioPlayer {

	private JFrame frmCN;
	private String fovvalue = "103";
	private int logcount = -1;
	private Border border = new LineBorder(Color.white, 2);

	private Random randomnumber = new Random();
	private int randomvalue;
	private boolean injectionrunning = false;
	private boolean panelslocked = false;

	private int Rc = 255;
	private int Gc = 0;
	private int Bc = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FPSCheatLoader window = new FPSCheatLoader();
					window.frmCN.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FPSCheatLoader() {
		initialize();

	}

	private void initialize() {
		frmCN = new JFrame();
		frmCN.setIconImage(Toolkit.getDefaultToolkit().getImage(FPSCheatLoader.class.getResource("/CheatLoader/icon.png")));
		frmCN.setResizable(false);
		frmCN.setTitle(				"- c n s w a r e -                                                     version 7.27alpha by conspiracy");
		frmCN.getContentPane().setBackground(new Color(0, 0, 0));
		frmCN.setBounds(100, 100, 727, 727);
		frmCN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCN.getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 132));
		separator.setBounds(10, 103, 691, 2);
		frmCN.getContentPane().add(separator);

		JTextPane log = new JTextPane();
		log.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		log.setForeground(new Color(0, 255, 255));
		log.setBackground(new Color(15, 15, 15));
		log.setEditable(false);
		log.setBounds(440, 120, 240, 500);
		log.setBorder(border);
		log.setText(log.getText() + "\n");
		frmCN.getContentPane().add(log);

		JLabel headline = new JLabel("c n s w a r e");
		headline.setHorizontalAlignment(SwingConstants.CENTER);
		headline.setForeground(new Color(255, 255, 255));
		// headline.setForeground(new Color(255, 255, 255));
		headline.setFont(new Font("Malgun Gothic", Font.PLAIN, 67));
		headline.setBounds(10, 0, 691, 60);
		frmCN.getContentPane().add(headline);

		JLabel versionname = new JLabel("ver. 7.27alpha by conspiracy");
		versionname.setHorizontalAlignment(SwingConstants.CENTER);
		versionname.setForeground(new Color(255, 255, 255));
		versionname.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		versionname.setBounds(10, 65, 691, 30);
		frmCN.getContentPane().add(versionname);

		JLabel aimbot = new JLabel("AimBot");
		aimbot.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		aimbot.setForeground(new Color(255, 255, 255));
		aimbot.setBounds(20, 120, 150, 30);
		frmCN.getContentPane().add(aimbot);

		JButton aimbotbtn = new JButton("OFF");
		JButton aimassistbtn = new JButton("OFF");
		aimbotbtn.setToolTipText("Perfectly locks onto enemies");
		aimbotbtn.setForeground(new Color(255, 255, 255));
		aimbotbtn.setBackground(new Color(255, 85, 85));
		aimbotbtn.setFocusable(false);
		aimbotbtn.setFont(new Font("Serif", Font.BOLD, 15));
		aimbotbtn.setBounds(200, 125, 80, 25);
		aimbotbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (injectionrunning == false) {
					try {
						AudioPlayer.playButton();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (panelslocked == true) {
						log.setText("\n");
						panelslocked = false;
					}
					if (aimbotbtn.getText() == "OFF") {
						aimbotbtn.setText("ON");
						if (aimassistbtn.getText() == "ON") {
							aimassistbtn.setText("OFF");
							aimassistbtn.setBackground(new Color(255, 85, 85));
							log.setText(log.getText() + "    AimAssist has been DEACTIVATED\n");
						}
						aimbotbtn.setBackground(new Color(51, 153, 102));
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    AimBot has been ACTIVATED\n");
						return;
					}
					if (aimbotbtn.getText() == "ON") {
						aimbotbtn.setText("OFF");
						aimbotbtn.setBackground(new Color(255, 85, 85));
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    AimBot has been DEACTIVATED\n");
						return;
					}
				}
			}
		});
		frmCN.getContentPane().add(aimbotbtn);

		JLabel aimassist = new JLabel("AimAssist");
		aimassist.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		aimassist.setForeground(new Color(255, 255, 255));
		aimassist.setBounds(20, 180, 150, 30);
		frmCN.getContentPane().add(aimassist);

		aimassistbtn.setToolTipText("Corrects your aim slightly to still look legit");
		aimassistbtn.setForeground(new Color(255, 255, 255));
		aimassistbtn.setBackground(new Color(255, 85, 85));
		aimassistbtn.setFocusable(false);
		aimassistbtn.setFont(new Font("Serif", Font.BOLD, 15));
		aimassistbtn.setBounds(200, 185, 80, 25);
		aimassistbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (injectionrunning == false) {
					try {
						AudioPlayer.playButton();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (panelslocked == true) {
						log.setText("\n");
						panelslocked = false;
					}
					if (aimassistbtn.getText() == "OFF") {
						aimassistbtn.setText("ON");
						if (aimbotbtn.getText() == "ON") {
							aimbotbtn.setText("OFF");
							aimbotbtn.setBackground(new Color(255, 85, 85));
							log.setText(log.getText() + "    AimBot has been DEACTIVATED\n");
						}
						aimassistbtn.setBackground(new Color(51, 153, 102));
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    AimAssist has been ACTIVATED\n");
						return;
					}
					if (aimassistbtn.getText() == "ON") {
						aimassistbtn.setText("OFF");
						aimassistbtn.setBackground(new Color(255, 85, 85));
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    AimAssist has been DEACTIVATED\n");
						return;
					}
				}
			}
		});
		frmCN.getContentPane().add(aimassistbtn);

		JLabel fovhack = new JLabel("Field of View");
		fovhack.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		fovhack.setForeground(new Color(255, 255, 255));
		fovhack.setBounds(20, 240, 150, 30);
		frmCN.getContentPane().add(fovhack);

		JButton fovhackbtn = new JButton(fovvalue);
		fovhackbtn.setToolTipText("Changes the FOV in game");
		fovhackbtn.setFont(new Font("Serif", Font.BOLD, 15));
		fovhackbtn.setForeground(new Color(255, 255, 255));
		fovhackbtn.setBounds(200, 245, 80, 25);
		fovhackbtn.setBackground(new Color(255, 85, 85));
		fovhackbtn.setFocusable(false);
		frmCN.getContentPane().add(fovhackbtn);

		JSlider fovslider = new JSlider();
		fovslider.setBackground(new Color(15, 15, 15));
		fovslider.setBounds(20, 290, 260, 30);
		fovslider.setBorder(border);
		fovslider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (injectionrunning == false) {
					try {
						AudioPlayer.playButton();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (panelslocked == true) {
						log.setText("\n");
						panelslocked = false;
					}
					if (fovslider.getValue() == 103) {
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    FOV has been set to DEFAULT\n");
						return;
					}
					if (fovslider.getValue() != 103) {
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    FOV has been set to " + fovvalue + "\n");
						return;
					}
				}
			}
		});

		fovslider.setPaintTicks(true);
		fovslider.setMajorTickSpacing(15);
		fovslider.setMinimum(30);
		fovslider.setMaximum(135);
		fovslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (injectionrunning == false) {
					fovvalue = String.valueOf(fovslider.getValue());
					fovhackbtn.setText(fovvalue);
					if (fovslider.getValue() == 103) {
						fovhackbtn.setBackground(new Color(255, 85, 85));
						return;
					}
					if (fovslider.getValue() != 103) {
						fovhackbtn.setBackground(new Color(51, 153, 102));
						return;
					}
				}
			}
		});

		fovhackbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (injectionrunning == false) {
					try {
						AudioPlayer.playButton();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (panelslocked == true) {
						log.setText("\n");
						panelslocked = false;
					}
					fovhackbtn.setBackground(new Color(255, 85, 85));
					if (fovslider.getValue() != 103) {
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    FOV has been set to DEFAULT\n");
						fovslider.setValue(103);
					}
					return;
				}
			}
		});
		fovslider.setValue(103);
		frmCN.getContentPane().add(fovslider);

		JLabel wallhack = new JLabel("WallHack");
		wallhack.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		wallhack.setForeground(new Color(255, 255, 255));
		wallhack.setBounds(20, 355, 150, 30);
		frmCN.getContentPane().add(wallhack);

		JButton wallhackbtn = new JButton("OFF");
		wallhackbtn.setToolTipText("Shows enemies through walls");
		wallhackbtn.setForeground(new Color(255, 255, 255));
		wallhackbtn.setBackground(new Color(255, 85, 85));
		wallhackbtn.setFocusable(false);
		wallhackbtn.setFont(new Font("Serif", Font.BOLD, 15));
		wallhackbtn.setBounds(200, 360, 80, 25);
		wallhackbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (injectionrunning == false) {
					try {
						AudioPlayer.playButton();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (panelslocked == true) {
						log.setText("\n");
						panelslocked = false;
					}
					if (wallhackbtn.getText() == "OFF") {
						wallhackbtn.setText("ON");
						wallhackbtn.setBackground(new Color(51, 153, 102));
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    WallHack has been ACTIVATED\n");
						return;
					}
					if (wallhackbtn.getText() == "ON") {
						wallhackbtn.setText("OFF");
						wallhackbtn.setBackground(new Color(255, 85, 85));
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    WallHack has been DEACTIVATED\n");
						return;
					}
				}
			}
		});
		frmCN.getContentPane().add(wallhackbtn);

		JLabel bunnyhop = new JLabel("BunnyHop");
		bunnyhop.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		bunnyhop.setForeground(new Color(255, 255, 255));
		bunnyhop.setBounds(20, 415, 150, 30);
		frmCN.getContentPane().add(bunnyhop);

		JButton bunnyhopbtn = new JButton("OFF");
		bunnyhopbtn.setToolTipText("Hits perfect bhops automatically");
		bunnyhopbtn.setForeground(new Color(255, 255, 255));
		bunnyhopbtn.setBackground(new Color(255, 85, 85));
		bunnyhopbtn.setFocusable(false);
		bunnyhopbtn.setFont(new Font("Serif", Font.BOLD, 15));
		bunnyhopbtn.setBounds(200, 420, 80, 25);
		bunnyhopbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (injectionrunning == false) {
					try {
						AudioPlayer.playButton();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (panelslocked == true) {
						log.setText("\n");
						panelslocked = false;
					}
					if (bunnyhopbtn.getText() == "OFF") {
						bunnyhopbtn.setText("ON");
						bunnyhopbtn.setBackground(new Color(51, 153, 102));
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    BunnyHop has been ACTIVATED\n");
						return;
					}
					if (bunnyhopbtn.getText() == "ON") {
						bunnyhopbtn.setText("OFF");
						bunnyhopbtn.setBackground(new Color(255, 85, 85));
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    BunnyHop has been DEACTIVATED\n");
						return;
					}
				}
			}
		});
		frmCN.getContentPane().add(bunnyhopbtn);

		JLabel skins = new JLabel("SkinUnlocker");
		skins.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		skins.setForeground(new Color(255, 255, 255));
		skins.setBounds(20, 475, 150, 30);
		frmCN.getContentPane().add(skins);

		JButton skinsbtn = new JButton("OFF");
		skinsbtn.setToolTipText("Unlocks every skin in the game (temporarily)");
		skinsbtn.setForeground(new Color(255, 255, 255));
		skinsbtn.setBackground(new Color(255, 85, 85));
		skinsbtn.setFocusable(false);
		skinsbtn.setFont(new Font("Serif", Font.BOLD, 15));
		skinsbtn.setBounds(200, 480, 80, 25);
		skinsbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (injectionrunning == false) {
					try {
						AudioPlayer.playButton();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (panelslocked == true) {
						log.setText("\n");
						panelslocked = false;
					}
					if (skinsbtn.getText() == "OFF") {
						skinsbtn.setText("ON");
						skinsbtn.setBackground(new Color(51, 153, 102));
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    All Skins have been UNLOCKED\n");
						return;
					}
					if (skinsbtn.getText() == "ON") {
						skinsbtn.setText("OFF");
						skinsbtn.setBackground(new Color(255, 85, 85));
						logcount++;
						if (logcount == 27) {
							log.setText("\n");
							logcount = 0;
						}
						log.setForeground(new Color(0, 255, 255));
						log.setText(log.getText() + "    All Skins have been LOCKED\n");
						return;
					}
				}
			}
		});
		frmCN.getContentPane().add(skinsbtn);

		JProgressBar injectbar = new JProgressBar();
		injectbar.setValue(0);
		injectbar.setBackground(new Color(15, 15, 15));
		injectbar.setForeground(new Color(128, 0, 0));
		injectbar.setBounds(20, 600, 260, 15);
		injectbar.setBorder(border);
		frmCN.getContentPane().add(injectbar);

		randomvalue = (randomnumber.nextInt(3 - 1 + 1) + 1);
		Timer injecttimer = new Timer(randomvalue * 200, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomvalue = (randomnumber.nextInt(10 - 1 + 1) + 1) * 2;
				injectbar.setValue(injectbar.getValue() + randomvalue / 2);
				log.setText(log.getText() + "\n    Cheat is injecting... " + injectbar.getValue() + "% done");
				if (injectbar.getValue() >= 25 && injectbar.getValue() < 50) {
					injectbar.setForeground(new Color(255, 153, 0));
				}
				if (injectbar.getValue() >= 50 && injectbar.getValue() < 75) {
					injectbar.setForeground(new Color(255, 255, 0));
				}
				if (injectbar.getValue() >= 75 && injectbar.getValue() < 100) {
					injectbar.setForeground(new Color(0, 255, 0));
				}
			}
		});

		JButton injectbtn = new JButton("INJECT");
		injectbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (injectbar.getValue() == 0) {
					try {
						AudioPlayer.playInject();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					log.setText("\n    - CHEAT INJECTION STARTED -");
					log.setForeground(new Color(255, 0, 0));
					injecttimer.start();
					injectionrunning = true;
				}
			}
		});
		injectbtn.setForeground(new Color(255, 255, 255));
		injectbtn.setFont(new Font("DengXian", Font.BOLD, 35));
		injectbtn.setBounds(20, 540, 260, 50);
		injectbtn.setFocusable(false);
		injectbtn.setBorder(border);
		frmCN.getContentPane().add(injectbtn);

		Timer rgbtimer = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Rc == 255 && Gc <= 255 && Gc >= 0 && Bc == 0) {
					Gc = Gc + 5;

				}

				if (Rc <= 255 && Rc >= 0 && Gc == 255 && Bc == 0) {
					Rc = Rc - 5;

				}

				if (Rc == 0 && Gc == 255 && Bc <= 255 && Bc >= 0) {
					Bc = Bc + 5;

				}

				if (Rc == 0 && Gc <= 255 && Gc >= 0 && Bc == 255) {
					Gc = Gc - 5;

				}

				if (Rc <= 255 && Rc >= 0 && Gc == 0 && Bc == 255) {
					Rc = Rc + 5;

				}

				if (Rc == 255 && Gc == 0 && Bc <= 255 && Bc >= 0) {
					Bc = Bc - 5;

				}

				if (Rc == 255 && Gc == 0 && Bc == 0) {
					Rc = 255;

				}

				if (Rc == 255 && Gc == 255 && Bc == 255) {
					Rc = 255;

				}

				headline.setForeground(new Color(Rc, Gc, Bc));
				injectbtn.setBackground(new Color(Rc, Gc, Bc));
				log.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == 8) {
							System.exit(0);
						}
					}
				});

				if (injectbar.getValue() >= 100) {
					injectbtn.setText("INJECTED");
					injectbar.setForeground(new Color(Rc, Gc, Bc));
				}
				if (injectionrunning == true) {
					if (injectbar.getValue() >= 100) {
						injecttimer.stop();
						fovhackbtn.setText(fovvalue);
						injectbar.setValue(100);
						panelslocked = true;
						try {
							AudioPlayer.playInjected();
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						log.setText("\n    - CHEAT INJECTED SUCCESSFULLY -");
						if (aimbotbtn.getText() == "ON") {
							log.setText(log.getText() + "\n    AimBot has been LOADED");
						}
						if (aimassistbtn.getText() == "ON") {
							log.setText(log.getText() + "\n    AimAssist has been LOADED");
						}
						if (fovslider.getValue() != 103) {
							log.setText(log.getText() + "\n    FOV has been CHANGED to " + fovvalue);
						}
						if (wallhackbtn.getText() == "ON") {
							log.setText(log.getText() + "\n    WallHack has been LOADED");
						}
						if (bunnyhopbtn.getText() == "ON") {
							log.setText(log.getText() + "\n    BunnyHop has been LOADED");
						}
						if (skinsbtn.getText() == "ON") {
							log.setText(log.getText() + "\n    All Skins have been UNLOCKED");
						}
						log.setForeground(new Color(0, 255, 0));
						injectionrunning = false;
					}
				}
			}
		});

		rgbtimer.start();

	}

}