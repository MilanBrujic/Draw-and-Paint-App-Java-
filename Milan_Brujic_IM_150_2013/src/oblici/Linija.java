package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik{
	private Tacka pocetna;
	private Tacka krajnja;
	
	public Linija(){
	}
	
	public Linija(Tacka novaPocetna, Tacka novaKrajnja){
		pocetna = novaPocetna;
		krajnja = novaKrajnja;
	}
	
	public Linija(Tacka novaPocetna, Tacka novaKrajnja, String novaBoja){
		super(novaBoja);
		pocetna = novaPocetna;
		krajnja = novaKrajnja;
	}
	
	public Linija(Tacka novaPocetna, Tacka novaKrajnja, Color novaBoja){
		super(novaBoja);
		pocetna = novaPocetna;
		krajnja = novaKrajnja;
	}

	
	public void setPocetna(Tacka novaPocetna){
		pocetna = novaPocetna;
	}
	
	public void setKrajnja(Tacka novaKrajnja){
		krajnja = novaKrajnja;
	}
	
	public Tacka getPocetna(){
		return pocetna;
	}
	
	public Tacka getKrajnja(){
		return krajnja;
	}
	
	public void pomeriZa(int pomeriZaX, int pomeriZaY){
		pocetna.pomeriZa(pomeriZaX, pomeriZaY);
		krajnja.pomeriZa(pomeriZaX, pomeriZaY);
	}
	
	public void pomeriNa(int pomeriNaX, int pomeriNaY){
		int razlikaX = pomeriNaX - pocetna.getX();
		int razlikaY = pomeriNaY - pocetna.getY();
		krajnja.pomeriZa(razlikaX, razlikaY);
		pocetna.pomeriNa(pomeriNaX, pomeriNaY);
	}
	
	public double duzina(){
		double duzina = pocetna.udaljenost(krajnja);
		return duzina;
	}
	
	public Tacka sredinaLinije(){
		
		int sredinaX = (pocetna.getX()+krajnja.getX())/2;
		int sredinaY = (pocetna.getY()+krajnja.getY())/2;
		
		Tacka sredina=new Tacka();
		sredina.setX(sredinaX);
		sredina.setY(sredinaY);
		return sredina;
	}
	
	public String toString(){
		String s = pocetna.toString() + "->" + krajnja.toString();
		return s;
	}
	
	public boolean equals(Object obj){
		if (obj instanceof Linija){
			Linija druga = (Linija)obj;
			if (pocetna.equals(druga.getPocetna()) 
			    && krajnja.equals(druga.getKrajnja())
			    && getBoja().equals(druga.getBoja())){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void crtajSe(Graphics g){
		g.setColor(getBoja1());
		g.drawLine(pocetna.getX(), pocetna.getY(), krajnja.getX(), krajnja.getY());
		if(isSelektovan()){
			pocetna.crtajKvadratic(g);
			krajnja.crtajKvadratic(g);
			sredinaLinije().crtajKvadratic(g);
		}
	}

	public boolean sadrzi(int x, int y) {
		Tacka prosledjena = new Tacka(x, y);
		if(prosledjena.udaljenost(pocetna) 
				+ prosledjena.udaljenost(krajnja)
				- this.duzina()<=0.05){
			return true;
		} else {
			return false;
		}
	}

	public int compareTo(Object o) {
		Linija prosledjena = (Linija)o;
		double result = this.duzina() - prosledjena.duzina();
		return (int)result;
	}

}
