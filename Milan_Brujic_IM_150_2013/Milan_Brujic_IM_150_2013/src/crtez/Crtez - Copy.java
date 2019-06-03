package crtez;

import java.awt.Color;
import java.awt.EventQueue;
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

public class Crtez extends JFrame {
	public String bojaOkvira="plava";
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
	public JToggleButton tglbtnBela;
	public JToggleButton tglbtnCrna;
	public JToggleButton tglbtnZelena;
	public JToggleButton tglbtnZuta;
	public JToggleButton tglbtnPlava;
	public JToggleButton tglbtnCrvena;
	public JButton btnObrisi;
	public JButton btnPomeriNa;
	public JButton btnPomeriZa;
	Oblik selektovan=null;
	ButtonGroup dugmad= new ButtonGroup();
	public ArrayList oblici = new ArrayList();




	public Crtez() {
		setSize(1000, 500);
		setTitle("Crtanje");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);



		tglbtnTacka = new JToggleButton("Tacka");
		tglbtnTacka.setBounds(219, 12, 121, 23);
		getContentPane().add(tglbtnTacka);


		tglbtnLinija = new JToggleButton("Linija");
		tglbtnLinija.setBounds(350, 12, 121, 23);
		getContentPane().add(tglbtnLinija);

		tglBtnKvadrat = new JToggleButton("Kvadrat");
		tglBtnKvadrat.setBounds(481, 12, 121, 23);
		getContentPane().add(tglBtnKvadrat);

		tglbtnPravougaonik = new JToggleButton("Pravougaonik");
		tglbtnPravougaonik.setBounds(612, 12, 121, 23);
		getContentPane().add(tglbtnPravougaonik);

		tglbtnKrug = new JToggleButton("Krug");
		tglbtnKrug.setBounds(743, 12, 121, 23);
		getContentPane().add(tglbtnKrug);

		tglbtnPromenaParametara = new JToggleButton("Promena parametara");
		tglbtnPromenaParametara.setBounds(10, 87, 170, 23);
		getContentPane().add(tglbtnPromenaParametara);

		tglbtnPromenaBoje = new JToggleButton("Promena boje");
		tglbtnPromenaBoje.setBounds(10, 121, 170, 23);
		getContentPane().add(tglbtnPromenaBoje);

		tglbtnSelektuj = new JToggleButton("Selektuj");
		tglbtnSelektuj.setBounds(10, 53, 170, 23);
		getContentPane().add(tglbtnSelektuj);

		tglbtnBela = new JToggleButton("");
		tglbtnBela.setBounds(10, 302, 38, 23);
		getContentPane().add(tglbtnBela);

		tglbtnCrna = new JToggleButton("");
		tglbtnCrna.setBounds(10, 346, 38, 23);
		getContentPane().add(tglbtnCrna);

		tglbtnZelena = new JToggleButton("");
		tglbtnZelena.setBounds(82, 302, 38, 23);
		getContentPane().add(tglbtnZelena);

		tglbtnZuta = new JToggleButton("");
		tglbtnZuta.setBounds(82, 346, 38, 23);
		getContentPane().add(tglbtnZuta);

		tglbtnPlava = new JToggleButton("");
		tglbtnPlava.setBounds(10, 391, 38, 23);
		getContentPane().add(tglbtnPlava);

		tglbtnCrvena = new JToggleButton("");
		tglbtnCrvena.setBounds(82, 391, 38, 23);
		getContentPane().add(tglbtnCrvena);

		btnObrisi = new JButton("Obrisi");

		btnObrisi.setBounds(10, 228, 170, 23);
		getContentPane().add(btnObrisi);

		btnPomeriNa = new JButton("Pomeri Na");
		btnPomeriNa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnPomeriNa.setBounds(10, 155, 170, 23);
		getContentPane().add(btnPomeriNa);

		btnPomeriZa = new JButton("Pomeri Za");
		btnPomeriZa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnPomeriZa.setBounds(10, 194, 170, 23);
		getContentPane().add(btnPomeriZa);

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
						mestoKlika = 0;
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
						Kvadrat kv = new Kvadrat(t, Integer.parseInt(stranica), bojaOkvira);
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
						
						Pravougaonik p = new Pravougaonik(t, Integer.parseInt(sirinaP), Integer.parseInt(duzinaP),bojaOkvira);
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
					Krug k= new Krug(t, Integer.parseInt(poluprecnik),bojaOkvira);
					panel.getLista().add(k);
					repaint();
					}
					catch(Exception ee){
						
					}
				}
				else if(tglbtnSelektuj.isSelected()){
					
					Iterator it = oblici.iterator();
					while (it.hasNext()) {
						Oblik o = (Oblik)it.next();
						if (selektovan == null) {
							if (o.sadrzi(e.getX(),e.getY())) {
								o.setSelektovan(true);
								selektovan = o;
								break;

							}
						}
						else {
							selektovan.setSelektovan(false);
							selektovan = null;
						}
						panel.getLista().add(o);
						repaint();
					}

				
				}

			}
		});
		panel.setBackground(Color.WHITE);
		panel.setBounds(229, 53, 635, 361);
		getContentPane().add(panel);
	}
}
