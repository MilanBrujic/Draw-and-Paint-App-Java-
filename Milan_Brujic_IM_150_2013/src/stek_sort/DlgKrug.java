package stek_sort;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgKrug extends JDialog {
	public JTextField textX;
	public JTextField textY;
	public JTextField textPoluprecnik;
	public String koordinataX;
	public String koordinataY;
	public String poluprecnik;
	public String bojaOboda;
	public String bojaUnutrasnjosti;
	public JComboBox cmbBojaUnutrasnjosti;
	public JComboBox cmbBojaOboda;
	public JLabel lblPoluprecnik;
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			
			
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
	
	
	public DlgKrug() {
		setModal(true);
		setTitle("Krug");
		setResizable(false);
		setSize(450,350);
		getContentPane().setLayout(null);
		
		JLabel lblX = new JLabel("X koordinata");
		lblX.setBounds(29, 31, 90, 14);
		getContentPane().add(lblX);
		
		textX = new JTextField();
		textX.setBounds(141, 28, 86, 20);
		getContentPane().add(textX);
		textX.setColumns(10);
		
		JLabel lblY = new JLabel("Y koordinata");
		lblY.setBounds(29, 75, 90, 14);
		getContentPane().add(lblY);
		
		textY = new JTextField();
		textY.setBounds(141, 72, 86, 20);
		getContentPane().add(textY);
		textY.setColumns(10);
		
		lblPoluprecnik = new JLabel("Poluprecnik");
		lblPoluprecnik.setBounds(29, 122, 90, 14);
		getContentPane().add(lblPoluprecnik);
		
		textPoluprecnik = new JTextField();
		textPoluprecnik.setBounds(141, 119, 86, 20);
		getContentPane().add(textPoluprecnik);
		textPoluprecnik.setColumns(10);
		
		JLabel lblBojaOboda = new JLabel("Boja oboda");
		lblBojaOboda.setBounds(29, 169, 90, 14);
		getContentPane().add(lblBojaOboda);
		
		cmbBojaOboda = new JComboBox();
		cmbBojaOboda.setBounds(141, 166, 86, 20);
		cmbBojaOboda.setModel(new DefaultComboBoxModel(new String[]{"bela", "crna", "crvena", "plava", "zelena"}));
		getContentPane().add(cmbBojaOboda);
		
		JLabel lblNewLabel = new JLabel("Boja unutrasnjosti");
		lblNewLabel.setBounds(29, 218, 105, 14);
		getContentPane().add(lblNewLabel);
		
		cmbBojaUnutrasnjosti = new JComboBox();
		cmbBojaUnutrasnjosti.setBounds(141, 215, 86, 20);
		cmbBojaUnutrasnjosti.setModel(new DefaultComboBoxModel(new String[]{"bela", "crna", "crvena", "plava", "zelena"}));
		getContentPane().add(cmbBojaUnutrasnjosti);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			
			/**
			Metoda koja omogucava proveru vrednosti X i Y koordinata i poluprecnika
			 */
			public void actionPerformed(ActionEvent e) {
				koordinataX=textX.getText();
				koordinataY=textY.getText();
				poluprecnik=textPoluprecnik.getText();
				bojaOboda=cmbBojaOboda.getSelectedItem().toString();
				bojaUnutrasnjosti=cmbBojaUnutrasnjosti.getSelectedItem().toString();
				
				if(koordinataX.length()>0){
					
					try{
						Double.parseDouble(koordinataX);
						
					}catch(NumberFormatException ee){
						JOptionPane.showMessageDialog(null, "Morate uneti broj za X koordinatu",
								"Upozorenje", JOptionPane.WARNING_MESSAGE);
						
					}
					}else{
						JOptionPane.showMessageDialog(null, "Morate uneti ceo broj za X koordinatu",
								"Greska", JOptionPane.ERROR_MESSAGE );
						
				}
				
				
				 if(koordinataY.length()>0){
					try{
						Double.parseDouble(koordinataY);
					}catch(NumberFormatException ee){
						JOptionPane.showMessageDialog(null, "Morate uneti broj za Y koordinatu",
								"Upozorenje", JOptionPane.WARNING_MESSAGE);
					}
					}else{
						JOptionPane.showMessageDialog(null, "Morate uneli ceo broj za Y koordinatu",
								"Greska", JOptionPane.ERROR_MESSAGE );
						
				}
				
				if(poluprecnik.length()>0){
					try{
						Double.parseDouble(poluprecnik);
					}catch(NumberFormatException ee){
						JOptionPane.showMessageDialog(null, "Morate uneti broj za poluprecnik",
								"Upozorenje", JOptionPane.WARNING_MESSAGE);
					}
					}else{
						JOptionPane.showMessageDialog(null, "Morate  uneli ceo  broj za vrednost poluprecnik",
								"Greska", JOptionPane.ERROR_MESSAGE );
				}
				
				
				
					setVisible(false);
				
			}
		});
		btnOk.setBounds(283, 27, 89, 23);
		getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(283, 71, 89, 23);
		getContentPane().add(btnCancel);
		
		
	}
}
