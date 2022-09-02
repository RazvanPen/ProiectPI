package flyscan;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.Graphics2D;
import java.awt.Cursor;
import java.awt.GridLayout;
public class HomeFrame extends JFrame implements ActionListener, MouseListener{
	
	private ImageIcon Picon = new ImageIcon("poza2.png"); 
	private ImageIcon background = new ImageIcon("poza1.png");
	private JLabel back = new JLabel();
	private JPanel zboruriP = new JPanel();
	private JMenuBar mb = new JMenuBar();
	private JMenu logout = new JMenu("Logout");
	private JMenu utilizator  = new JMenu("Utilizator");
	private DefaultTableModel model = new DefaultTableModel();
	private JTable t = new JTable(model);
	private JScrollPane zboruri = new JScrollPane(t);
	private int i = 0;
	private JButton butonDetalii = new JButton("Detalii");
	private JFrame x;
	private JFrame det;
	private JLabel temp = new JLabel();
	private JButton but = new JButton("ID");
	private JTextField txt = new JTextField();
	private JTextField id1 = new JTextField("ID");
	private JButton cumpara = new JButton("Cumpara");
	private JButton butonCumpara = new JButton("Cumpara");
	private int flag;
	private JOptionPane mess = new JOptionPane();
	private String nickname;
	private JTextField bagaj = new JTextField("Bagaj");
	private JButton inainte = new JButton("Inainte");
	private JButton inapoi = new JButton("Inapoi");
	private JButton da = new JButton();
	private JButton nu = new JButton();
	private JLabel userIcon = new JLabel();
	private JLabel disBut = new JLabel();
	private JLabel settingsI = new JLabel();
	private JLabel temp2 = new JLabel();
	
	private Connection ConnectingToDB () throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyscan", "root", "pacotheparrot22@@@");
		return con;
	}
	public HomeFrame(int flag, String nume) throws ClassNotFoundException, SQLException{
		/** Aici se va realiza tabelul cu zborurile.
		*/
		
		nickname = nume;
		this.flag = flag;
		
		setVisible(true);
		setSize(1280, 800);
		setTitle("FlyScanRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(Picon.getImage());
		getContentPane().setBackground(new Color(0x123454));
		setLocationRelativeTo(null);
		setLayout(null);
		add(back);
		
		back.setIcon(background);
		back.setBounds(0, 0, 1280, 800);
		zboruriP.setBounds(40, 40, 1020, 600);
		zboruriP.setLayout(null);
		
		Connection conn = ConnectingToDB();
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery("select id_zbor, plecare, destinatie,companie,durata,pret,ora,sosire,data from zbor order by rand()");
		int x = 0, y = 1, z = 1;
		for(int i = 1; i <= 6; i++) {	
			
			JLabel temp2 = new JLabel();
			temp2.setBounds(0, 0 + x, 1020, 100);
			temp2.setBackground(Color.LIGHT_GRAY);
			temp2.setOpaque(true);
			JLabel idzbor = new JLabel("ID Zbor: " + String.valueOf(y));
			temp2.add(idzbor);
			idzbor.setBounds(10, 40, 75, 25);
			JLabel plecare = new JLabel("Plecare: Bucuresti");
			temp2.add(plecare);
			plecare.setBounds(100, 40, 110, 25);
			JLabel sosire = new JLabel("Sosire: Viena");
			temp2.add(sosire);
			sosire.setBounds(210, 40, 110, 25);
			JLabel companie = new JLabel("Companie: Tarom");
			temp2.add(companie);
			companie.setBounds(320, 40, 110, 25);
			JLabel pret = new JLabel("Pret: 180 lei");
			temp2.add(pret);
			pret.setBounds(450, 40, 110, 25);
			JLabel ora = new JLabel("Ora plecare: 19:00");
			temp2.add(ora);
			ora.setBounds(540, 40, 110, 25);
			JLabel data = new JLabel("Data: 25/09/2022");
			temp2.add(data);
			data.setBounds(670, 40, 110, 25);
			JLabel logo = new JLabel();
			if(z == 1) {
				logo.setIcon(new ImageIcon (new ImageIcon("logo-tarom.png").getImage().getScaledInstance(150, 85, Image.SCALE_SMOOTH)));
			}
			else if(z == 2) {
				logo.setIcon(new ImageIcon (new ImageIcon("logo-blue-air.png").getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
			}
			else if(z == 3) {
				logo.setIcon(new ImageIcon (new ImageIcon("wizz_logo.png").getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
			}
			else if(z == 4) {
				logo.setIcon(new ImageIcon(new ImageIcon("Ryanair-Logo.png").getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
			}
			logo.setBounds(800, 0, 150, 100);
			temp2.add(logo);
			temp2.addMouseListener(new MouseAdapter() {
				 @Override
	                public void mousePressed(MouseEvent e) {
					 	
	                } 
			});
			zboruriP.add(temp2);
			x = x + 100;
			y++;
			z++;
			if(z > 4 )
				z = 1;	
			
		}
		back.add(zboruriP);
		back.add(inainte);
		back.add(inapoi);
		inainte.setBounds(760, 670, 300, 60);
		inapoi.setBounds(40, 670, 300, 60);
		inainte.setBackground(Color.LIGHT_GRAY);
		inapoi.setBackground(Color.LIGHT_GRAY);
		userIcon.setBounds(1070, 30, 200, 200);
		userIcon.setIcon(new ImageIcon(new ImageIcon("profile-icon.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		back.add(userIcon);
		disBut.setBounds(1090, 465, 200, 200);
		disBut.setIcon(new ImageIcon(new ImageIcon("disconect-icon.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		back.add(disBut);
		settingsI.setBounds(1090, 245, 200, 200);
		settingsI.setIcon(new ImageIcon(new ImageIcon("settings-icon.png").getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH)));
		back.add(settingsI);
		disBut.addMouseListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/**Aici vedem detaliile despre fiecare zbor.
		*/
		
		if(e.getSource() == butonDetalii) {
			x = new JFrame();
			JLabel xbackg = new JLabel();
			x.setVisible(true);
			x.setSize(200, 100);
			x.setTitle("FlyScanRo");
			x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			x.setResizable(false);
			x.setIconImage(Picon.getImage());
			x.getContentPane().setBackground(new Color(0x123456));
			x.setLocationRelativeTo(null);
			x.setLayout(null);
			xbackg.setIcon(background);
			xbackg.setBounds(0, 0, 200, 100);
			x.add(xbackg);
			but.setBounds(130, 15, 50, 35);
			txt.setBounds(5, 15, 100, 32);
			x.add(txt);
			x.add(but);
			but.addActionListener(this);	
			
		}
		if(e.getSource() == but) {	
			String id = txt.getText();
			try {
				txt.setText("");
				Connection conn = ConnectingToDB();
				Statement stmt = conn.createStatement();
				ResultSet res = stmt.executeQuery("select * from zbor where id_zbor = '"  + id + "' ");
				if(res.next()) {
					x.dispose();
					det = new JFrame();
					JLabel backg = new JLabel();
					JLabel plecare = new JLabel("Oras plecare: " + res.getString("plecare"));
					JLabel destinatie = new JLabel("Oras destinatie: " + res.getString("destinatie"));
					JLabel companie = new JLabel("Companie de zbor (Aeronava BOEING 737-700): " + res.getString("companie"));
					JLabel durata = new JLabel("Durata zborului: " + res.getString("durata"));
					JLabel pret = new JLabel("Pret: " + res.getInt("pret"));
					JLabel ora = new JLabel("Ora plecare: " + res.getString("ora"));
					JLabel sosire = new JLabel("Ora de sosire: " + res.getString("sosire"));
					JLabel data = new JLabel("Data zborului: " +res.getString("data"));

					det.setVisible(true);
					det.setSize(800, 650);
					det.setTitle("FlyScanRo");
					det.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					det.setResizable(false);
					det.setIconImage(Picon.getImage());
					det.getContentPane().setBackground(new Color(0x123456));
					det.setLocationRelativeTo(null);
					det.setLayout(null);
					backg.setIcon(background);
					backg.setBounds(0, 0, 800, 650);
					plecare.setBounds(20, 10, 400, 25);
					plecare.setFont(new Font("Courier", Font.BOLD, 21));
					plecare.setForeground(Color.black);
					destinatie.setBounds(20, 45, 400, 25);
					destinatie.setFont(new Font("Courier", Font.BOLD, 21));
					destinatie.setForeground(Color.black);
					companie.setBounds(20, 90, 800, 25);
					companie.setFont(new Font("Courier", Font.BOLD, 21));
					companie.setForeground(Color.black);
					durata.setBounds(20, 155, 400, 25);
					durata.setFont(new Font("Courier", Font.BOLD, 21));
					durata.setForeground(Color.white);
					pret.setBounds(20, 195, 400, 25);
					pret.setFont(new Font("Courier", Font.BOLD, 21));
					pret.setForeground(Color.green);
					ora.setBounds(20, 235, 400, 25);
					ora.setFont(new Font("Courier", Font.BOLD, 21));
					ora.setForeground(Color.white);
					sosire.setBounds(20, 300, 400, 25);
					sosire.setFont(new Font("Courier", Font.BOLD, 21));
					sosire.setForeground(Color.orange);
					data.setBounds(20, 360, 400, 25);
					data.setFont(new Font("Courier", Font.BOLD, 21));
					data.setForeground(Color.orange);
					det.add(backg);	
					backg.add(plecare);
					backg.add(destinatie);
					backg.add(companie);
					backg.add(durata);
					backg.add(pret);
					backg.add(ora);
					
					backg.add(sosire);
					backg.add(data);
				}
				conn.close();
				stmt.close();
				res.close();

			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		if(e.getSource() == butonCumpara) {
			if(flag == 1) {
				mess.showMessageDialog(null, "Aceasta optiune poate fi accesata doar de catre un utilizator conectat", "Eroare", JOptionPane.PLAIN_MESSAGE);
			}
			else if (flag == 0) {
				x = new JFrame();
				JLabel xbackg = new JLabel();
				x.setVisible(true);
				x.setSize(400, 100);
				x.setTitle("FlyScanRO");
				x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				x.setResizable(false);
				x.setIconImage(Picon.getImage());
				x.getContentPane().setBackground(new Color(0x123456));
				x.setLocationRelativeTo(null);
				x.setLayout(null);
				xbackg.setIcon(background);
				xbackg.setBounds(0, 0, 400, 100);
				x.add(xbackg);
				xbackg.add(id1);
				xbackg.add(cumpara);
				xbackg.add(bagaj);
				id1.setBounds(10, 20, 100, 25);
				bagaj.setBounds(130, 20, 120, 25);
				cumpara.setBounds(270, 20, 100, 25);
				cumpara.addActionListener(this);
				cumpara.setBackground(Color.GRAY);
			}	
		}
		if(e.getSource() == cumpara) {
			try {
				x.dispose();
				Connection conn = ConnectingToDB();
				Statement stmt = conn.createStatement();
				ResultSet res = stmt.executeQuery("select * from zbor where id_zbor like '%" + id1.getText() + "%'");
				if(res.next()) {
					String x = id1.getText();
					String x1 = bagaj.getText();
					int id2 = res.getInt("pret");
					res = stmt.executeQuery("select * from users where user_nickname like '%" + nickname + "%'");
					res.next();
					int numeR = res.getInt("id_user");
					
					stmt.execute("insert into bilet values(default, '" + numeR + "', '" + Integer.parseInt(x) + "', '" + x1 + "', '" + id2 + "')");
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == disBut) {
			x = new JFrame();
			JLabel xbackg = new JLabel();
			JLabel text = new JLabel("Sunteti sigur ca doriti sa va deconectati ?");
			text.setBounds(60, 25, 300, 30);
			text.setForeground(Color.WHITE);
			text.setFont(new Font("Serif", Font.BOLD, 17));
			da = new JButton("Da");
			nu = new JButton("Nu");
			da.setBounds(5, 70, 80, 40);
			nu.setBounds(350, 70, 80, 40);
			da.setBackground(Color.LIGHT_GRAY);
			nu.setBackground(Color.LIGHT_GRAY);
			x.setVisible(true);
			x.setSize(450, 150);
			x.setTitle("FlyScanRO");
			x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			x.setResizable(false);
			x.setIconImage(Picon.getImage());
			x.getContentPane().setBackground(new Color(0x123456));
			x.setLocationRelativeTo(null);
			x.setLayout(null);
			xbackg.setIcon(background);
			xbackg.setBounds(0, 0, 450, 150);
			x.add(xbackg);
			xbackg.add(da);
			xbackg.add(nu);
			xbackg.add(text);
			da.addMouseListener(this);
			nu.addMouseListener(this);
		}
		if(e.getSource() == da) {
			x.dispose();
			new LogInFrame();
		}
		if(e.getSource() == nu) {
			x.dispose();
		}
		if(e.getSource() == zboruriP) {
			System.out.println("test mouse");
		}
		if(e.getSource() == utilizator) {
			/** Aici se vor vedea zborurile fiecarui user.
			*/
			x = new JFrame();
			JLabel xbackg = new JLabel();
			x.setVisible(true);
			x.setSize(1000, 700);
			x.setTitle("FlyScanRo");
			x.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			x.setResizable(false);
			x.setIconImage(Picon.getImage());
			x.getContentPane().setBackground(new Color(0x123456));
			x.setLocationRelativeTo(null);
			x.setLayout(null);
			xbackg.setIcon(background);
			xbackg.setBounds(0, 0, 1000, 700);
			x.add(xbackg);
			Connection conn;
			try {
				conn = ConnectingToDB();
				Statement stmt = conn.createStatement();
				ResultSet res = stmt.executeQuery("select * from users where user_nickname like '%" + nickname + "%'");
				res.next();
				int h = res.getInt("id_user");
				JLabel nume = new JLabel("Numele utilizatorului: " + res.getString("user_prenume"));
				JLabel prenume = new JLabel("Prenumele utilizatorului: " + res.getString("user_nume"));
				JLabel email = new JLabel("E-mailul utilizatorului: " + res.getString("user_email"));
				JLabel mbnr = new JLabel("Numarul de telefon al utilizatorului: " + res.getString("user_nrtelefon") );
				JLabel nickname = new JLabel("Nickname-ul utilizatorului: " + res.getString("user_nickname"));
				
				xbackg.add(nume);
				xbackg.add(prenume);
				xbackg.add(email);
				xbackg.add(mbnr);
				xbackg.add(nickname);
				
				nume.setBounds(15, 5, 500, 30);
				nume.setFont(new Font("Courier", Font.BOLD, 20));
				nume.setForeground(Color.black);
				prenume.setBounds(15, 75, 500, 30);
				prenume.setFont(new Font("Courier", Font.BOLD, 20));
				prenume.setForeground(Color.black);
				email.setBounds(15, 145, 500, 30);
				email.setFont(new Font("Courier", Font.BOLD, 20));
				email.setForeground(Color.black);
				mbnr.setBounds(15, 215, 600, 30);
				mbnr.setFont(new Font("Courier", Font.BOLD, 20));
				mbnr.setForeground(Color.black);
				nickname.setBounds(15, 285, 500, 30);
				nickname.setFont(new Font("Courier", Font.BOLD, 20));
				nickname.setForeground(Color.green);
				
				DefaultTableModel model5 = new DefaultTableModel();
				JTable t5 = new JTable(model5);
				JScrollPane y5 = new JScrollPane(t5);
				model5.addColumn("ID");
				model5.addColumn("ID_User");
				model5.addColumn("ID_Zbor");
				model5.addColumn("Bagaj");
				model5.addColumn("Pret");
				res = stmt.executeQuery("select * from bilet where id_user like '%" + h + "%' order by id_bilet DESC");
				i=0;
				while(res.next()) {
					model5.insertRow(i, new Object[] {res.getInt("id_bilet"), res.getInt("id_user"), res.getInt("id_zbor"), res.getString("bagaj"), res.getInt("pret")});
					i++;
				}
				
				y5.setBounds(120, 400, 750, 150);
				xbackg.add(y5);
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == disBut) {
			disBut.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
