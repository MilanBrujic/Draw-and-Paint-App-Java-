package crtez;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;

/**@author Milan
 * @version 1.0*/

public class DlgBoja extends JDialog {
	/**Varijable*/
	public boolean za;
	public boolean na;
	public Color bojaIvice;
	public Color bojaUnutrasnjosti;
	public JButton btnBojaSpoljasnjosti;
	public JButton btnBojaUnutrasnjosti;
	public JLabel lblBojaUnutrasnjosti;
	public JLabel lblBojaIvice;
	public Color bojaIvice2 = Color.BLACK;
	public Color bojaUnutrasnjosti2 = Color.WHITE;
	public JCheckBox chckbxIzaberi;
	public JCheckBox chckbxIzaberi_1;
	public ButtonGroup buton =new ButtonGroup();
	
	
	/**Pokretanje dijaloga*/
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try{
					DlgBoja dijalog= new DlgBoja();
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
	public DlgBoja() {
		setModal(true);
		setTitle("Boja");
		setResizable(false);
		setSize(370,250);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 344, 199);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblBojaIvice = new JLabel("Boja ivice:");
		lblBojaIvice.setBounds(10, 21, 78, 14);
		panel.add(lblBojaIvice);

		lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti: ");
		lblBojaUnutrasnjosti.setBounds(10, 65, 115, 14);
		panel.add(lblBojaUnutrasnjosti);
		
		
		/**Metoda koja omogucava odabir boje okvira selektovanog objekta.
		 * Ukoliko nije selektovan ni jedan objekat boja ce biti crna*/
		btnBojaSpoljasnjosti = new JButton("Boja");
		btnBojaSpoljasnjosti.setEnabled(false);
		btnBojaSpoljasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaIvice=JColorChooser.showDialog(null, "Izaberite boju ivice", Color.BLACK);
				if(bojaIvice==null){
					bojaIvice=(Color.BLACK);
				}
			}
		});
		btnBojaSpoljasnjosti.setBounds(158, 17, 89, 23);
		panel.add(btnBojaSpoljasnjosti);

		
		/**Metoda koja omogucava odabir boje unutrasnjosti.
		 * Ukoliko nije odabrana ni jedna boja, unutrasnjost ce biti bela*/
		btnBojaUnutrasnjosti = new JButton("Boja");
		btnBojaUnutrasnjosti.setEnabled(false);
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaUnutrasnjosti=JColorChooser.showDialog(null, "Izaberite boju unutrasnjosti", Color.WHITE);
				if(bojaUnutrasnjosti==null){
					bojaUnutrasnjosti=(Color.WHITE);
				}
			}
		});
		btnBojaUnutrasnjosti.setBounds(158, 61, 89, 23);
		panel.add(btnBojaUnutrasnjosti);

		JButton btnURedu = new JButton("U redu");
		btnURedu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					bojaIvice2=bojaIvice;
					bojaUnutrasnjosti2=bojaUnutrasnjosti;
					setVisible(false);
				}catch(Exception ee){

				}
			}
		});
		btnURedu.setBounds(10, 111, 89, 23);
		panel.add(btnURedu);

		JButton btnIzadji = new JButton("Izadji");
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnIzadji.setBounds(10, 154, 89, 23);
		panel.add(btnIzadji);
		
		chckbxIzaberi = new JCheckBox("Izaberi");
		chckbxIzaberi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxIzaberi.isSelected()){
					if(za){
						btnBojaSpoljasnjosti.setEnabled(false);
						btnBojaUnutrasnjosti.setEnabled(false);
						buton.clearSelection();
						za=false;
					}else{
						btnBojaSpoljasnjosti.setEnabled(true);
						btnBojaUnutrasnjosti.setEnabled(false);
						za=true;
						na=false;
					}
				}
				
			}
		});
		chckbxIzaberi.setBounds(264, 17, 97, 23);
		buton.add(chckbxIzaberi);
		panel.add(chckbxIzaberi);
		
		chckbxIzaberi_1 = new JCheckBox("Izaberi");
		chckbxIzaberi_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxIzaberi_1.isSelected()){
					if(na){
						btnBojaSpoljasnjosti.setEnabled(false);
						btnBojaUnutrasnjosti.setEnabled(false);
						buton.clearSelection();
						na=false;
					}else{
						btnBojaSpoljasnjosti.setEnabled(false);
						btnBojaUnutrasnjosti.setEnabled(true);
						na=true;
						za=false;
					}
				}
				
			}
		});
		chckbxIzaberi_1.setBounds(264, 61, 97, 23);
		buton.add(chckbxIzaberi_1);
		panel.add(chckbxIzaberi_1);
	}
}
