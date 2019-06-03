package crtez;

import java.awt.EventQueue;

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

public class DlgParametri extends JDialog {
	/**Varijable*/
	public JTextField textStranica;
	public String stranica;
	public JLabel lblStranica;
	public JLabel lblPoluprecnik;

	
	
	/**Pokretanje dijaloga*/
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try{
					DlgParametri dijalog= new DlgParametri();
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
	public DlgParametri() {
		setModal(true);
		setTitle("Promena parametara");
		setResizable(false);
		setSize(210,200);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 184, 149);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblStranica = new JLabel("Stranica:");
		lblStranica.setBounds(10, 27, 57, 14);
		panel.add(lblStranica);
		
		textStranica = new JTextField();
		textStranica.setBounds(77, 24, 86, 20);
		panel.add(textStranica);
		textStranica.setColumns(10);
		
		lblPoluprecnik = new JLabel("Poluprecnik");
		lblPoluprecnik.setBounds(10, 27, 68, 14);
		panel.add(lblPoluprecnik);
		
		
		/**Ova metoda omogucava proveru unesenih parametara. Ukoliko je uneto neko slovo 
		 * ili ukoliko nije uneto nista program ce javiti gresku. 
		 * Dozvoljeno je unositi samo brojeve*/
		JButton btnUredu = new JButton("Uredu");
		btnUredu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stranica=textStranica.getText();
				
				if(stranica.length()>0){
					try{
						Integer.parseInt(stranica);
						
					}catch(NumberFormatException ee){
						JOptionPane.showMessageDialog(null, "Unesite ceo broj za promenu parametara!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "Unesite vrednost za promenu parametara!", "Upozorenje!", 
							JOptionPane.WARNING_MESSAGE);
				}
			
				try{
					Integer.parseInt(stranica);
					
					setVisible(false);
				}catch(Exception ee){
					
				}
			}
		});
		btnUredu.setBounds(10, 85, 89, 23);
		panel.add(btnUredu);
		
		JButton btnIzadji = new JButton("Izadji");
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzadji.setBounds(10, 115, 89, 23);
		panel.add(btnIzadji);
		
		
	}
}
