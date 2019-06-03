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
 * @version 1.0*/

public class DlgKrug extends JDialog {
	/**
	 *Varijable*/
	public JTextField textPoluprecnik;
	public String poluprecnik;
	public Color bojaUnutrasnjosti=(Color.WHITE);
	public Color bojaSpoljasnjosti=(Color.BLACK);
	
	
	/**Pokretanje dijaloga*/
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try{
					DlgKrug dijalog= new DlgKrug();
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
	public DlgKrug() {
		setModal(true);
		setTitle("Krug");
		setResizable(false);
		setSize(300,250);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 274, 199);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUnesitePoluprecnik = new JLabel("Unesite poluprecnik:");
		lblUnesitePoluprecnik.setBounds(10, 11, 129, 14);
		panel.add(lblUnesitePoluprecnik);
		
		textPoluprecnik = new JTextField();
		textPoluprecnik.setBounds(149, 8, 89, 20);
		panel.add(textPoluprecnik);
		textPoluprecnik.setColumns(10);
		
		JButton btnBojaUnutrasnjosti = new JButton("Boja Unutrasnjosti");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaUnutrasnjosti=JColorChooser.showDialog(null, "Izaberite boju unutrasnjosti", Color.WHITE);
			}
		});
		btnBojaUnutrasnjosti.setBounds(94, 49, 144, 23);
		panel.add(btnBojaUnutrasnjosti);
		
		
		/**Ova metoda omogucava proveru unesenih parametara. Ukoliko je uneto neko slovo 
		 * ili ukoliko nije uneto nista program ce javiti gresku. 
		 * Dozvoljeno je unositi samo brojeve*/
		JButton btnURedu = new JButton("U redu");
		btnURedu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poluprecnik=textPoluprecnik.getText();
				if(poluprecnik.length()>0){
					try{
						Integer.parseInt(poluprecnik);
					}catch(NumberFormatException ee){
						JOptionPane.showMessageDialog(null, "Unesite ceo broj za poluprecnik!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Unesite vrednost poluprecnika!", "Upozorenje!", 
							JOptionPane.WARNING_MESSAGE);
				}
				try{
					Integer.parseInt(poluprecnik);
					setVisible(false);
				}catch(NumberFormatException ee){
					
				}
			}
		});
		btnURedu.setBounds(10, 109, 89, 23);
		panel.add(btnURedu);
		
		JButton btnIzadji = new JButton("Izadji");
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzadji.setBounds(10, 146, 89, 23);
		panel.add(btnIzadji);
	}
	

}
