package stek_sort;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import oblici.Krug;
import oblici.Tacka;

public class Sortiranje extends JFrame {
	DefaultListModel<Krug> dlm = new DefaultListModel();
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			
			
			public void run() {
				try{
					Sortiranje sort= new Sortiranje();
					sort.setLocationRelativeTo(null);
					sort.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public Sortiranje() {
		setSize(600	,500);
		setTitle("Dragan Milovac II16_2012");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DlgKrug dlg= new DlgKrug();
				dlg.setLocationRelativeTo(null);
				dlg.setVisible(true);
				
				try{
					Krug k= new Krug(new Tacka(Integer.parseInt(dlg.koordinataX), Integer.parseInt(dlg.koordinataY)),
							Integer.parseInt(dlg.poluprecnik), dlg.bojaOboda, dlg.bojaUnutrasnjosti);
					dlm.addElement(k);
				}catch(NumberFormatException ee){
					
				}
			}
		});
		btnDodaj.setBounds(24, 42, 89, 23);
		getContentPane().add(btnDodaj);
		
		JButton btnSortiranje = new JButton("Sortiraj");
		/**Metoda koja omogucava sortiranje objekata koji
		 * su dodati na stek*/
		btnSortiranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgKrug dlg= new DlgKrug();
				dlg.setLocationRelativeTo(null);
				if(dlm.isEmpty()){
					JOptionPane.showMessageDialog(null, "Lista je prazna, nema sta da se sortira",
							"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
			}else{
				try{
					dlg.textX.setText(String.valueOf(dlm.getElementAt(0).getCentarKruga().getX()));
					dlg.textY.setText(String.valueOf(dlm.getElementAt(0).getCentarKruga().getY()));
					dlg.textPoluprecnik.setText(String.valueOf(dlm.getElementAt(0).getPoluprecnik()));
					dlg.setVisible(true);

					Object[] krug = new Object[dlm.getSize()];
					dlm.copyInto(krug);
					
					Arrays.sort(krug);
					dlm.removeAllElements();
					
					for(int i = 0; i < krug.length; i++) {
						dlm.addElement((Krug) krug[i]);
					}
				}catch(Exception ee){
					
				}
			}
		}});
		btnSortiranje.setBounds(24, 94, 89, 23);
		getContentPane().add(btnSortiranje);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(24, 153, 89, 23);
		getContentPane().add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 44, 327, 134);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
	}
}

