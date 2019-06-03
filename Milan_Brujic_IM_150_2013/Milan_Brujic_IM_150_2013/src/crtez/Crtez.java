package crtez;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.JobAttributes;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JButton;

import oblici.Krug;
import oblici.Kvadrat;
import oblici.Linija;
import oblici.Oblik;
import oblici.Pravougaonik;
import oblici.Tacka;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Dragan
 * @version 1.0*/

public class Crtez extends JFrame {
	
	/**Varijable*/
	public String bojaOkvira="crna";
	public Tacka pocetna=null;
	int mestoKlika;
	public String bojaUnutrasnjosti="crna";
	public JToggleButton tglbtnTacka;
	public JToggleButton tglbtnLinija;
	public JToggleButton tglBtnKvadrat;
	public JToggleButton tglbtnPravougaonik;
	public JToggleButton tglbtnKrug;
	public JToggleButton tglbtnPromenaParametara;
	public JToggleButton tglbtnPromenaBoje;
	public JToggleButton tglbtnSelektuj;
	public JButton btnObrisi;
	public JButton btnPomeriNa;
	public JButton btnPomeriZa;
	private JButton btnIzadji;
	Oblik selektovan=null;
	public ButtonGroup dugmad= new ButtonGroup();
	public ArrayList oblici = new ArrayList();




	/**Pravljenje prozora klase Crtez*/
	public Crtez() {
		setSize(1000, 500);
		setTitle("Crtez");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.GRAY);



		tglbtnTacka = new JToggleButton("Tacka");
		tglbtnTacka.setBounds(219, 12, 121, 30);
		getContentPane().add(tglbtnTacka);
		dugmad.add(tglbtnTacka);


		tglbtnLinija = new JToggleButton("Linija");
		tglbtnLinija.setBounds(350, 12, 121, 30);
		getContentPane().add(tglbtnLinija);
		dugmad.add(tglbtnLinija);

		tglBtnKvadrat = new JToggleButton("Kvadrat");
		tglBtnKvadrat.setBounds(481, 12, 121, 30);
		getContentPane().add(tglBtnKvadrat);
		dugmad.add(tglBtnKvadrat);

		tglbtnPravougaonik = new JToggleButton("Pravougaonik");
		tglbtnPravougaonik.setBounds(612, 12, 121, 30);
		getContentPane().add(tglbtnPravougaonik);
		dugmad.add(tglbtnPravougaonik);

		tglbtnKrug = new JToggleButton("Krug");
		tglbtnKrug.setBounds(743, 12, 121, 30);
		getContentPane().add(tglbtnKrug);
		dugmad.add(tglbtnKrug);

		
		
		/**Ovom metodom se menjaju parametri selektovanog kvadrata, pravougaonika ili kruga. 
		 * Metoda prolazi kroz listu proverava da li je neki objekat selektovan
		 * i ukoliko jeste korisniku iskace dijalog u kom moze da promeni parametre. 
		 *  Ukoliko je selektovana tacka ili linija program ce javiti gresku da njihovi parametri
		 * ne mogu da se menjaju.*/
		tglbtnPromenaParametara = new JToggleButton("Promena parametara");
		tglbtnPromenaParametara.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				DlgParametri promena= new DlgParametri();

				Oblik obl=null;
				ListIterator it=oblici.listIterator();
				while(it.hasNext()){
					Oblik o=(Oblik)it.next();
					if(o.isSelektovan())
					obl=o;
				}
					
					if(obl !=null){
						if(obl instanceof Tacka){
							
							JOptionPane.showMessageDialog(null, "Ne mozete promeniti parametre tacke!",
									"Greska", JOptionPane.ERROR_MESSAGE);
							
						}
						else if(obl instanceof Linija){
							
							JOptionPane.showMessageDialog(null, "Ne mozete promeniti parametre linije!",
									"Greska", JOptionPane.ERROR_MESSAGE);
							
						}
						else if(obl instanceof Kvadrat){
							promena.lblStranica.setVisible(true);
							promena.lblPoluprecnik.setVisible(false);
							promena.setLocationRelativeTo(null);
							promena.setVisible(true);
							try{
								Kvadrat k=(Kvadrat)obl;
								k.setSirina(Integer.parseInt(promena.textStranica.getText()));
							}catch(Exception ee){
								

							}
						}
						else if(obl instanceof Pravougaonik){
							promena.lblStranica.setVisible(true);
							promena.lblPoluprecnik.setVisible(false);
							promena.setLocationRelativeTo(null);
							promena.setVisible(true);
							try{
								Pravougaonik p=(Pravougaonik)obl;
								p.setSirina(Integer.parseInt(promena.textStranica.getText()));
								p.setVisina(Integer.parseInt(promena.textStranica.getText()));
							}catch(Exception ee){
								
							}
						}
						else if(obl instanceof Krug){

							promena.lblPoluprecnik.setVisible(true);
							promena.lblStranica.setVisible(false);
							promena.setLocationRelativeTo(null);
							promena.setVisible(true);
							
							try{
								Krug kr=(Krug)obl;
								kr.setPoluprecnik(Integer.parseInt(promena.textStranica.getText()));
							}catch(Exception ee){
								
							}
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Morate selektovati neki oblik da bi mu menjali parametre", "Informacija", JOptionPane.INFORMATION_MESSAGE);
					}
				
				}

			
		});
		tglbtnPromenaParametara.setBounds(10, 87, 159, 23);
		getContentPane().add(tglbtnPromenaParametara);
		dugmad.add(tglbtnPromenaParametara);



		tglbtnSelektuj = new JToggleButton("Selektuj");
		tglbtnSelektuj.setBounds(10, 53, 159, 23);
		getContentPane().add(tglbtnSelektuj);
		dugmad.add(tglbtnSelektuj);


		
		/**Ova metoda omogucava pomeranje selektovanih objekata na odredjene koordinate. To se desava
		 *  tako sto metoda prolazi kroz listu, ispituje da li je objekat selektovan i ako jeste
		 *  korisniku iskace dijalog u kome treba da popuni na koje koordinate zeli da pomeri objekat*/
		btnPomeriNa = new JButton("Pomeri Na");
		btnPomeriNa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PomeranjeObjekata pomeriNa= new PomeranjeObjekata();
				

				ListIterator it=oblici.listIterator();
				while(it.hasNext()){
					Oblik o=(Oblik)it.next();
					if(o.isSelektovan()){
						if(o instanceof Tacka){
							pomeriNa.setLocationRelativeTo(null);
							
							try{
								Tacka t=(Tacka)o;
								t.pomeriNa(Integer.parseInt(pomeriNa.x), Integer.parseInt(pomeriNa.y));
							}catch(Exception ee){
								pomeriNa.setVisible(true);
							}
						}
						else if(o instanceof Linija){
							pomeriNa.setLocationRelativeTo(null);
							
							try{
								Linija l=(Linija)o;
								l.pomeriNa(Integer.parseInt(pomeriNa.x), Integer.parseInt(pomeriNa.y));
							}catch(Exception ee){
								pomeriNa.setVisible(true);
							}
						}
						else if(o instanceof Kvadrat){
							pomeriNa.setLocationRelativeTo(null);
							

							try{
								Kvadrat k=(Kvadrat)o;
								k.pomeriNa(Integer.parseInt(pomeriNa.x), Integer.parseInt(pomeriNa.y));

							}catch(Exception ee){
								pomeriNa.setVisible(true);
							}
						}
						else if(o instanceof Pravougaonik){
							pomeriNa.setLocationRelativeTo(null);
							

							try{
								Pravougaonik p=(Pravougaonik)o;
								p.pomeriNa(Integer.parseInt(pomeriNa.x), Integer.parseInt(pomeriNa.y));

							}catch(Exception ee){
								pomeriNa.setVisible(true);
							}
						}
						else if(o instanceof Krug){
							pomeriNa.setLocationRelativeTo(null);
							

							try{
								Krug kr=(Krug)o;
								kr.pomeriNa(Integer.parseInt(pomeriNa.x), Integer.parseInt(pomeriNa.y));

							}catch(Exception ee){
								pomeriNa.setVisible(true);
							}

						}
						


					}
					



				}
				
				
			}
		});

		btnPomeriNa.setBounds(10, 155, 159, 23);
		getContentPane().add(btnPomeriNa);
		dugmad.add(btnPomeriNa);

		
		
		/**Ova metoda omogucava pomeranje selektovanih objekata za odredjenu vrednost. To se vrsi tako
		 * sto metoda prolazi kroz listu, ispituje da li je selektovan odredjeni objekat i ako jeste 
		 * korisniku iskace dijalog u kome unosi vrednosti za koje zeli da pomeri objekat*/
		btnPomeriZa = new JButton("Pomeri Za");
		btnPomeriZa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PomeranjeObjekata pomeriZa = new PomeranjeObjekata();

				ListIterator it= oblici.listIterator();
				while(it.hasNext()){
					Oblik o=(Oblik)it.next();
					if(o.isSelektovan()){
						if(o instanceof Tacka){
							pomeriZa.setLocationRelativeTo(null);
							
							try{
								Tacka t=(Tacka)o;
								t.pomeriZa(Integer.parseInt(pomeriZa.x), Integer.parseInt(pomeriZa.y));
							}catch(Exception ee){
								pomeriZa.setVisible(true);
							}
						}else if(o instanceof Linija){
							pomeriZa.setLocationRelativeTo(null);
							
							try{
								Linija l=(Linija)o;
								l.pomeriZa(Integer.parseInt(pomeriZa.x), Integer.parseInt(pomeriZa.y));
							}catch(Exception ee){
								pomeriZa.setVisible(true);
							}
						}
						else if(o instanceof Kvadrat){
							pomeriZa.setLocationRelativeTo(null);
							
							try{
								Kvadrat k=(Kvadrat)o;
								k.pomeriZa(Integer.parseInt(pomeriZa.x), Integer.parseInt(pomeriZa.y));
							}catch(Exception ee){
								pomeriZa.setVisible(true);
							}
						}
						else if(o instanceof Pravougaonik){
							pomeriZa.setLocationRelativeTo(null);
							
							try{
								Pravougaonik p=(Pravougaonik)o;
								p.pomeriZa(Integer.parseInt(pomeriZa.x), Integer.parseInt(pomeriZa.y));
							}catch(Exception ee){
								pomeriZa.setVisible(true);
							}
						}
						else if(o instanceof Krug){
							pomeriZa.setLocationRelativeTo(null);
							
							try{
								Krug kr=(Krug)o;
								kr.pomeriZa(Integer.parseInt(pomeriZa.x), Integer.parseInt(pomeriZa.y));
							}catch(Exception ee){
								pomeriZa.setVisible(true);
							}
						}
					}
					
				}
			}
		});

		btnPomeriZa.setBounds(10, 194, 159, 23);
		getContentPane().add(btnPomeriZa);
		dugmad.add(btnPomeriZa);


		 final CrtanjePanela panel = new CrtanjePanela();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				Oblik obl= null;
				Tacka t = new Tacka(x, y);
				if(tglbtnTacka.isSelected()){
					t = new Tacka(x, y, bojaOkvira );
					panel.getLista().add(t);
					repaint();
				}

				else if(tglbtnLinija.isSelected()){
					if(pocetna==null){
						pocetna= new Tacka(x,y);
					}else{
						Tacka krajnja = new Tacka(x,y);
						obl = new Linija(pocetna, krajnja,bojaOkvira);
						pocetna = null;
						oblici.add(obl);
						panel.getLista().add(obl);
						repaint();
					}
				}

				else if(tglBtnKvadrat.isSelected()){
					try{
						DlgKvadrat kvadrat = new DlgKvadrat();
						kvadrat.setLocationRelativeTo(null);
						kvadrat.setVisible(true);


						String stranica = kvadrat.textDuzinaStranice.getText();
						Kvadrat kv = new Kvadrat(t, Integer.parseInt(stranica), kvadrat.bojaSpoljasnjosti,kvadrat.bojaUnutrasnjosti);
						panel.getLista().add(kv);

						repaint();
					}catch(Exception ee){

					}
				}
				else if(tglbtnPravougaonik.isSelected()){
					try{
						DlgPravougaonik pravougaonik= new DlgPravougaonik();
						pravougaonik.setLocationRelativeTo(null);
						pravougaonik.setVisible(true);

						String sirinaP = pravougaonik.textSirina.getText();
						String duzinaP = pravougaonik.textDuzina.getText();

						Pravougaonik p = new Pravougaonik(t, Integer.parseInt(sirinaP), Integer.parseInt(duzinaP),pravougaonik.bojaSpolasnjosti,pravougaonik.bojaUnutrasnjosti);
						panel.getLista().add(p);

						repaint();
					}catch(Exception ee){

					}

				}
				else if(tglbtnKrug.isSelected()){
					try{
						DlgKrug krug= new DlgKrug();
						krug.setLocationRelativeTo(null);
						krug.setVisible(true);

						String poluprecnik= krug.textPoluprecnik.getText();
						Krug k= new Krug(t, Integer.parseInt(poluprecnik),krug.bojaSpoljasnjosti,krug.bojaUnutrasnjosti);
						panel.getLista().add(k);
						repaint();
					}
					catch(Exception ee){

					}
				}
				else if(tglbtnSelektuj.isSelected()){
					if(!panel.getLista().isEmpty()){
						Iterator it= panel.getLista().iterator();
						while(it.hasNext()){
							Oblik o = (Oblik)it.next();
							o.setSelektovan(false);
							if(o.sadrzi(e.getX(), e.getY())){
								oblici.add(o);
								obl=o;
							}}
						if(obl!=null){
							obl.setSelektovan(true);
							oblici.add(obl);
						}




					}


				}

			}
		});
		panel.setBackground(Color.WHITE);
		panel.setBounds(219, 53, 645, 361);
		getContentPane().add(panel);

		
		
		/**Ova metoda omogucuje promenu boje selektovanih oblika. To se vrsi tako sto metoda prolazi
		 * kroz listu, ispituje da li je odredjeni objekat selektovan i ako jeste korisniku
		 * iskace dijalog u kome moze da promeni boju okvira i boju unutrasnjosti objekta
		 * koristeci JCoolorChooser*/
		tglbtnPromenaBoje = new JToggleButton("Promena boje");
		tglbtnPromenaBoje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DlgBoja promena=new DlgBoja();

				Oblik obl = null;
				ListIterator it = oblici.listIterator();
				while(it.hasNext()){
					Oblik o = (Oblik)it.next();
					if (o.isSelektovan())
						obl = o;
				}
				if(obl!=null){
					if(obl instanceof Tacka){
						promena.btnBojaUnutrasnjosti.setEnabled(false);
						promena.chckbxIzaberi_1.setEnabled(false);

						promena.setLocationRelativeTo(null);
						promena.setVisible(true);
						
						try{
							Tacka t= (Tacka)obl;
							t.setBoja1(promena.bojaIvice2);
						}catch(Exception ee){
							
						}
					}
					else if(obl instanceof Linija){
						promena.btnBojaUnutrasnjosti.setEnabled(false);
						promena.chckbxIzaberi_1.setEnabled(false);
						promena.setLocationRelativeTo(null);
						promena.setVisible(true);
						if(promena.btnBojaSpoljasnjosti.isEnabled()){
							Linija l = (Linija)obl;
							l.setBoja1(promena.bojaIvice2);
						}
					}
					else if(obl instanceof Kvadrat){
						promena.setLocationRelativeTo(null);
						promena.setVisible(true);
						
						if(promena.bojaIvice!=null){
							obl.setBoja1(promena.bojaIvice2);
						} 
						
						if(promena.bojaUnutrasnjosti!=null){
							((Kvadrat)obl).setBojaU(promena.bojaUnutrasnjosti2);
						}
						
					}else if(obl instanceof Pravougaonik){
						promena.setLocationRelativeTo(null);
						promena.setVisible(true);
						
						if(promena.bojaIvice!=null){
							obl.setBoja1(promena.bojaIvice2);
						}
						if(promena.bojaUnutrasnjosti!=null){
							((Pravougaonik)obl).setBojaU(promena.bojaUnutrasnjosti2);
						}
					}else if(obl instanceof Krug){
						promena.setLocationRelativeTo(null);
						promena.setVisible(true);
						if(promena.bojaIvice!=null){
							obl.setBoja1(promena.bojaIvice2);
							
						}
						if(promena.bojaUnutrasnjosti!=null){
							((Krug)obl).setBojaU(promena.bojaUnutrasnjosti2);
						}
					}
				}


			}
		});
		tglbtnPromenaBoje.setBounds(10, 121, 159, 23);
		getContentPane().add(tglbtnPromenaBoje);
		dugmad.add(tglbtnPromenaBoje);

		
		/**Ova metota omogucuje brisanje objekata sa liste. To je omoguceno tako sto metoda prolazi 
		 * kroz listu oblika, ispituje da li je oblik selektovan i ako je selektovan moze da se obrise,
		 * ali pre samog brisanja se postavlja pitanje da li je korisnik 
		 * siguran da zeli da obrise selektovani objekat*/
		btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(panel.getLista().size()>0){
					int brisanje= JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete?",
							"Upozorenje", JOptionPane.OK_CANCEL_OPTION);
					if(brisanje==0){
						for(int i=0; i<panel.getLista().size(); i++){
							if(panel.getLista().get(i).isSelektovan()){
								panel.getLista().remove(i);

							}
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Morate selektovati objekat koji zelite da brisete",
							"Upozorenje", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnObrisi.setBounds(10, 228, 159, 23);
		getContentPane().add(btnObrisi);
		dugmad.add(btnObrisi);

		btnIzadji = new JButton("Izadji");
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzadji.setBounds(10, 262, 159, 23);
		getContentPane().add(btnIzadji);
		dugmad.add(btnIzadji);
	}
}
