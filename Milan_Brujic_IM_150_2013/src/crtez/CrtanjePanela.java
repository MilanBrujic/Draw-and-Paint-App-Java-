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

/**
 * @author Milan
 * @version 1.0*/

public class CrtanjePanela extends JPanel {
	public CrtanjePanela() {
	}
	
	
	ArrayList<Oblik> lista = new ArrayList<Oblik>();

	public ArrayList<Oblik> getLista() {
		return lista;
	}
	
	/**Pokretanje programa za crtanje*/
	public static void main(String[] args){
		Crtez c= new Crtez();
		c.setLocationRelativeTo(null);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
	}
	
	
	/**Metoda koja omogucava crtanje objekata koji se nalaze u listi*/
	public void paint(Graphics g){
		super.paint(g);
		if(!lista.isEmpty()){
			Iterator it = lista.iterator();
			while(it.hasNext()){
				Oblik sledeca = (Oblik)it.next();
				sledeca.crtajSe(g);
			}
			repaint();
		}
		
		
	}
	
	
	
}