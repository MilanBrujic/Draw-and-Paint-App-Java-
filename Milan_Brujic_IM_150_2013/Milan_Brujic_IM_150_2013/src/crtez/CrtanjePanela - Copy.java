package crtez;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import oblici.Krug;
import oblici.Kvadrat;
import oblici.Linija;
import oblici.Oblik;
import oblici.Tacka;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class CrtanjePanela extends JPanel {
	
	ArrayList<Oblik> lista = new ArrayList<Oblik>();

	public ArrayList<Oblik> getLista() {
		return lista;
	}
	
	public static void main(String[] args){
		Crtez c= new Crtez();
		c.setLocationRelativeTo(null);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		if(!lista.isEmpty()){
			Iterator it = lista.iterator();
			while(it.hasNext()){
				Oblik sledeca = (Oblik)it.next();
				sledeca.crtajSe(g);
			}
		}
		
		
	}
	
	
	
}