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
 * @author Dragan
 * @version 1.0*/

public class DlgKvadrat extends JDialog {
	/**
	 * Varijable
	 * */
	public JTextField textDuzinaStranice;
	public String duzinaStranice;
	public Color bojaUnutrasnjosti=(Color.WHITE);
	public Color bojaSpoljasnjosti=(Color.BLACK);
	
	
	/**
	 * Pokretanje dijaloga
	 * */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try{
					DlgKvadrat dijalog= new DlgKvadrat();
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
	public DlgKvadrat() {
		setModal(true);
		setTitle("Kvadrat");
		setResizable(false);
		setSize(300,250);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 274, 210);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUnesiteDuzinuStranice = new JLabel("Unesite duzinu stranice:");
		lblUnesiteDuzinuStranice.setBounds(10, 29, 158, 14);
		panel.add(lblUnesiteDuzinuStranice);
		
		textDuzinaStranice = new JTextField();
		textDuzinaStranice.setBounds(175, 26, 89, 20);
		panel.add(textDuzinaStranice);
		textDuzinaStranice.setColumns(10);
		
		
		/**Ova metoda omogucava proveru unesenih parametara. Ukoliko je uneto neko slovo 
		 * ili ukoliko nije uneto nista program ce javiti gresku. 
		 * Dozvoljeno je unositi samo brojeve*/
		JButton btnURedu = new JButton("U redu");
		btnURedu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duzinaStranice=textDuzinaStranice.getText();
				if(duzinaStranice.length()>0){
					try{
						Integer.parseInt(duzinaStranice);
					}catch(NumberFormatException ee){
						JOptionPane.showMessageDialog(null, "Unesite ceo broj za stranicu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "Unesite vrednost za stranice!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
				}
				try{
					Integer.parseInt(duzinaStranice);
					setVisible(false);
				}catch(Exception ee){
					
				}
				
			}
		});
		btnURedu.setBounds(10, 124, 89, 23);
		panel.add(btnURedu);
		
		JButton btnBojaUnutrasnjosti = new JButton("Boja Unutrasnjosti");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaUnutrasnjosti=JColorChooser.showDialog(null, "Izaberite boju", Color.WHITE);
				if(bojaUnutrasnjosti==null){
					bojaUnutrasnjosti=(Color.WHITE);
				}
			}
		});
		btnBojaUnutrasnjosti.setBounds(114, 65, 150, 23);
		panel.add(btnBojaUnutrasnjosti);
		
		JButton btnIzadji = new JButton("Izadji");
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzadji.setBounds(10, 162, 89, 23);
		panel.add(btnIzadji);
	}
}
