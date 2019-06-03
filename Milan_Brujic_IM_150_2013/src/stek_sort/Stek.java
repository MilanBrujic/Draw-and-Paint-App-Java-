package stek_sort;

import oblici.Tacka;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;

import oblici.Krug;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stek extends JFrame {
	DefaultListModel<Krug> dlm = new DefaultListModel();
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			
			
			public void run() {
				try{
					Stek stek= new Stek();
					stek.setLocationRelativeTo(null);
					stek.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public Stek() {
		setSize(800	,500);
		setTitle("Milan Brujic IM150/13");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		JButton btnDodaj = new JButton("Dodaj");
		/**Metoda koja omogucava dodavanje objekata na stek*/
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DlgKrug dlg= new DlgKrug();
				dlg.setLocationRelativeTo(null);
				dlg.setVisible(true);
				
				try{
					Krug k= new Krug(new Tacka(Integer.parseInt(dlg.koordinataX), Integer.parseInt(dlg.koordinataY)),
							Integer.parseInt(dlg.poluprecnik), dlg.bojaOboda, dlg.bojaUnutrasnjosti);
					dlm.add(0, k);
				}catch(NumberFormatException ee){
					
				}
			}
		});
		btnDodaj.setBounds(24, 42, 89, 23);
		getContentPane().add(btnDodaj);
		
		JButton btnUzmi = new JButton("Uzmi");
		
		/**Metoda koja omogucava uzimanje objekata sa steka*/
		btnUzmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgKrug dlg= new DlgKrug();
				dlg.setLocationRelativeTo(null);
				
				if(dlm.isEmpty()){
					JOptionPane.showMessageDialog(null, "Lista je prazna, nema sta da se uzme",
							"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
				}else{
					try{
						dlg.textX.setText(String.valueOf(dlm.getElementAt(0).getCentarKruga().getX()));
						dlg.textY.setText(String.valueOf(dlm.getElementAt(0).getCentarKruga().getY()));
						dlg.textPoluprecnik.setText(String.valueOf(dlm.getElementAt(0).getPoluprecnik()));
						dlg.setVisible(true);
						dlm.remove(0);
						
					}catch(Exception ee){
						
						
					}
				}
			}
		});
		btnUzmi.setBounds(24, 94, 89, 23);
		getContentPane().add(btnUzmi);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(24, 153, 89, 23);
		getContentPane().add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(143, 42, 431, 151);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
	}
}

