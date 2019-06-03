package crtez;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Milan
 * @version 1.0
 * */

public class DlgPravougaonik extends JDialog {
	
	/**
	 * Varijable 
	 * */
	public JTextField textDuzina;
	public JTextField textSirina;
	public String duzina;
	public String sirina;
	public Color bojaUnutrasnjosti=(Color.WHITE);
	public Color bojaSpolasnjosti=(Color.BLACK);
	
	/**Pokretanje dijaloga*/
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try{
					DlgPravougaonik dijalog= new DlgPravougaonik();
					dijalog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dijalog.setLocationRelativeTo(null);
					dijalog.setVisible(true);
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
	}
	
	/**Pravljenje dijaloga*/
	public DlgPravougaonik() {
		setModal(true);
		setTitle("Pravougaonik");
		setResizable(false);
		setSize(300,250);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 274, 199);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUnesiteDuzinu = new JLabel("Unesite duzinu:");
		lblUnesiteDuzinu.setBounds(10, 11, 120, 14);
		panel.add(lblUnesiteDuzinu);
		
		JLabel lblUnesiteSirinu = new JLabel("Unesite sirinu:");
		lblUnesiteSirinu.setBounds(10, 49, 120, 14);
		panel.add(lblUnesiteSirinu);
		
		textDuzina = new JTextField();
		textDuzina.setBounds(140, 8, 89, 20);
		panel.add(textDuzina);
		textDuzina.setColumns(10);
		
		textSirina = new JTextField();
		textSirina.setBounds(140, 46, 89, 20);
		panel.add(textSirina);
		textSirina.setColumns(10);
		
		
		JButton btnBojaUnutrasnjosti = new JButton("Boja Unutrasnjosti");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaUnutrasnjosti=JColorChooser.showDialog(null, "Izaberite boju unutrasnjosti", Color.WHITE);
				if(bojaUnutrasnjosti==null){
					bojaUnutrasnjosti=(Color.WHITE);
				}
			}
		});
		btnBojaUnutrasnjosti.setBounds(89, 82, 140, 23);
		panel.add(btnBojaUnutrasnjosti);
		
		
		/**Ova metoda omogucava proveru unesenih parametara. Ukoliko je uneto neko slovo 
		 * ili ukoliko nije uneto nista program ce javiti gresku. 
		 * Dozvoljeno je unositi samo brojeve*/
		JButton btnURedu = new JButton("U redu");
		btnURedu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duzina=textDuzina.getText();
				sirina=textSirina.getText();
				
				if(duzina.length()>0){
					try{
						Integer.parseInt(duzina);
					}catch(NumberFormatException ee){
						JOptionPane.showMessageDialog(null, "Unesite ceo broj za duzinu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Unesite vrednost za duzinu stranice!", "Upozorenje!", 
							JOptionPane.WARNING_MESSAGE);
				}
				if(sirina.length()>0){
					try{
						Integer.parseInt(sirina);
					}catch(NumberFormatException ee){
						JOptionPane.showMessageDialog(null, "Unesite ceo broj za sirinu stranice!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Unesite vrednost za sirinu stranice!", "Upozorenje!", 
							JOptionPane.WARNING_MESSAGE);
				}
				try{
					Integer.parseInt(duzina);
					Integer.parseInt(sirina);
					setVisible(false);
				}catch(Exception ee){
					
				}
			}
		});
		btnURedu.setBounds(10, 130, 89, 23);
		panel.add(btnURedu);
		
		/**Ova metoda omogucava izlazak iz dijaloga za pravougaonik*/
		JButton btnIzadji = new JButton("Izadji");
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzadji.setBounds(10, 165, 89, 23);
		panel.add(btnIzadji);
	}
	
}
