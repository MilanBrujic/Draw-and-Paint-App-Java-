package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik{
	protected Tacka goreLevo;
	private int sirina;
	
	public Kvadrat(){
	}
	
	public Kvadrat(Tacka novoGoreLevo, int novaSirina){
		goreLevo = novoGoreLevo;
		sirina = novaSirina;
	}
	
	public Kvadrat(Tacka novoGoreLevo, int novaSirina, String novaBoja){
		setBoja(novaBoja);
		goreLevo = novoGoreLevo;
		sirina = novaSirina;
	}
	
	public Kvadrat(Tacka novoGoreLevo, int novaSirina, Color novaBoja){
		setBoja1(novaBoja);
		goreLevo = novoGoreLevo;
		sirina = novaSirina;
	}
	
	public Kvadrat(Tacka novoGoreLevo, int novaSirina, 
			String novaBoja, String novaBojaUnutrasnjosti){
		setBoja(novaBoja);
		setBojaUnutrasnjosti(novaBojaUnutrasnjosti);
		goreLevo = novoGoreLevo;
		sirina = novaSirina;
	}
	
	public Kvadrat(Tacka novoGoreLevo, int novaSirina, 
			Color novaBoja, Color novaBojaUnutrasnjosti){
		setBoja1(novaBoja);
		setBojaU(novaBojaUnutrasnjosti);
		goreLevo = novoGoreLevo;
		sirina = novaSirina;
	}
	
	
	public void setGoreLevo(Tacka novoGoreLevo){
		goreLevo = novoGoreLevo;
	}
	
	public void setSirina(int novaSirina){
		sirina = novaSirina;
	}
	
	public Tacka getGoreLevo(){
		return goreLevo;
	}
	
	public int getSirina(){
		return sirina;
	}
	

	public void pomeriNa(int pomeriNaX, int pomeriNaY){
		goreLevo.pomeriNa(pomeriNaX, pomeriNaY);
	}

	public void pomeriZa(int pomeriZaX, int pomeriZaY){
		goreLevo.pomeriZa(pomeriZaX, pomeriZaY);
	}
	
	public double povrsina(){
		double rezultat = sirina*sirina;
		return rezultat;
	}
	
	public double obim(){
		double rezultat = sirina*4;
		return rezultat;
	}
	
	public Linija dijagonala(){
		Tacka krajnja = new Tacka();
		krajnja.setX(goreLevo.getX()+sirina);
		krajnja.setY(goreLevo.getY()+sirina);
		
		Linija dijagonala = new Linija();
		dijagonala.setPocetna(goreLevo);
		dijagonala.setKrajnja(krajnja);
		return dijagonala;
	}
	
	public Tacka centralnaTacka(){
		Tacka centar = new Tacka();
		centar.setX(goreLevo.getX()+(sirina/2));
		centar.setY(goreLevo.getY()+(sirina/2));
		return centar;
	}
	
	public String toString(){
		String s = "gornji levi ugao=" + goreLevo.toString() + ", stranica=" + sirina;
		return s;
	}
	
	public boolean equals(Object obj){
		if (obj instanceof Kvadrat){
			Kvadrat druga = (Kvadrat)obj;
			if (goreLevo.equals(druga.getGoreLevo()) 
			    && sirina == druga.getSirina()
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
		popuni(g);
		g.setColor(getBoja1());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), sirina, sirina);
		if(isSelektovan()){
			Tacka goreDesno = new Tacka(goreLevo.getX()+sirina, goreLevo.getY());
			Tacka doleLevo = new Tacka(goreLevo.getX(), goreLevo.getY()+sirina);
			Tacka doleDesno = new Tacka(goreLevo.getX()+sirina, goreLevo.getY()+sirina);
			Tacka goreSredina = new Tacka(goreLevo.getX()+sirina/2, goreLevo.getY());
			Tacka doleSredina = new Tacka(goreLevo.getX()+ sirina/2, goreLevo.getY()+sirina);
			Tacka levoSredina = new Tacka(goreLevo.getX(), goreLevo.getY()+sirina/2);
			Tacka desnoSredina = new Tacka(goreLevo.getX()+sirina,goreLevo.getY()+sirina/2);
			goreLevo.crtajKvadratic(g);
			goreDesno.crtajKvadratic(g);
			doleLevo.crtajKvadratic(g);
			doleDesno.crtajKvadratic(g);
			goreSredina.crtajKvadratic(g);
			doleSredina.crtajKvadratic(g);
			levoSredina.crtajKvadratic(g);
			desnoSredina.crtajKvadratic(g);
		}
	}

	public void popuni(Graphics g) {
		g.setColor(getBojaU());
		g.fillRect(goreLevo.getX(), goreLevo.getY(), sirina, sirina);
	}

	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + sirina)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + sirina)){
			return true;
		} else {
			return false;
		}
	}

	public int compareTo(Object o) {
		Kvadrat prosledjen = (Kvadrat)o;
		int result = this.sirina - prosledjen.sirina;
		return result;
	}
}
