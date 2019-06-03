package crtez;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * 
 * 
 * @author Dragan 
 * @version 1.0*/


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PomeranjeObjekata extends JDialog {
	
	/**
	 * Varijable 
	 * */
	public JTextField textX;
	public JTextField textY;
	public String x;
	public String y;
	
	/**
	 * Pokretanje dijaloga 
	 * */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try{
					PomeranjeObjekata pomeri= new PomeranjeObjekata();
					pomeri.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					pomeri.setLocationRelativeTo(null);
					pomeri.setVisible(true);
					
				}catch(Exception e){
					
				}
				
			}
		});
	}
	
	/**Pravljenje dijaloga*/
	public PomeranjeObjekata() {
		setModal(true);
		setTitle("Pomeranje Objekata");
		setResizable(false);
		setSize(300,250);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 274, 199);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblXKoordinata = new JLabel("X koordinata:");
		lblXKoordinata.setBounds(10, 34, 85, 14);
		panel.add(lblXKoordinata);
		
		JLabel lblYKoordinata = new JLabel("Y koordinata:");
		lblYKoordinata.setBounds(10, 69, 85, 14);
		panel.add(lblYKoordinata);
		
		textX = new JTextField();
		textX.setBounds(151, 31, 86, 20);
		panel.add(textX);
		textX.setColumns(10);
		
		textY = new JTextField();
		textY.setBounds(151, 66, 86, 20);
		panel.add(textY);
		textY.setColumns(10);
		
		/**Ova metoda omogucava proveru unesenih parametara. Ukoliko je uneto neko slovo 
		 * ili ukoliko nije uneto nista program ce javiti gresku. 
		 * Dozvoljeno je unositi samo brojeve*/
		JButton btnURedu = new JButton("U redu");
		btnURedu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x=textX.getText();
				y=textY.getText();
				
				if(x.length()>0){
					try{
						Integer.parseInt(x);
					}catch(NumberFormatException ee){
						JOptionPane.showMessageDialog(null, "Unesite ceo broj za X koordinatu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Unesite cvrednost za X koordinatu!", "Upozorenje!", 
							JOptionPane.WARNING_MESSAGE);
				}
				
				if(y.length()>0){
					try{
						Integer.parseInt(y);
					}catch(NumberFormatException ee){
						JOptionPane.showMessageDialog(null, "Unesite ceo broj za Y koordinatu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Unesite cvrednost za Y koordinatu!", "Upozorenje!", 
							JOptionPane.WARNING_MESSAGE);
				}
				try{
					Integer.parseInt(x);
					Integer.parseInt(y);
					setVisible(false);
				}catch(Exception ee){
					
				}
			}
		});
		btnURedu.setBounds(10, 119, 89, 23);
		panel.add(btnURedu);
		
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
