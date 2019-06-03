package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Krug extends PovrsinskiOblik{
	private Tacka centarKruga;
	private int poluprecnik;
	
	public Krug(){
	}
	
	public Krug(Tacka noviCentarKruga, int noviPoluprecnik){
		centarKruga = noviCentarKruga;
		poluprecnik = noviPoluprecnik;
	}
	
	public Krug(Tacka noviCentarKruga, int noviPoluprecnik, String novaBoja){
		setBoja(novaBoja);
		centarKruga = noviCentarKruga;
		poluprecnik = noviPoluprecnik;
	}
	
	public Krug(Tacka noviCentarKruga, int noviPoluprecnik, 
			String novaBoja, String novaBojaUnutrasnjosti){
		setBoja(novaBoja);
		setBojaUnutrasnjosti(novaBojaUnutrasnjosti);
		centarKruga = noviCentarKruga;
		poluprecnik = noviPoluprecnik;
	}
	
	public Krug(Tacka noviCentarKruga, int noviPoluprecnik, 
			Color novaBoja, Color novaBojaUnutrasnjosti){
		setBoja1(novaBoja);
		setBojaU(novaBojaUnutrasnjosti);
		centarKruga = noviCentarKruga;
		poluprecnik = noviPoluprecnik;
	}
	
	public void setCentarKruga(Tacka noviCentarKruga){
		centarKruga=noviCentarKruga;
	}
	
	public void setPoluprecnik(int noviPoluprecnik){
		poluprecnik=noviPoluprecnik;
	}
	
	public int getPoluprecnik(){
		return poluprecnik;
	}
	
	public Tacka getCentarKruga(){
		return centarKruga;
	}
	
	public void pomeriNa(int pomeriNaX, int pomeriNaY){
		centarKruga.pomeriNa(pomeriNaX, pomeriNaY);
	}
	
	public void pomeriZa(int pomeriZaX, int pomeriZaY){
		centarKruga.pomeriZa(pomeriZaX, pomeriZaY);
	}
	
	public double povrsina(){
		double p = poluprecnik * poluprecnik * Math.PI;
		return p;
	}
	
	public double obim(){
		double o = 2 * poluprecnik * Math.PI;
		return o;
	}
	
	public String toString(){
		String s = "centar=" + centarKruga.toString() + ", poluprecnik=" + poluprecnik+
				 " boja oboda = "+super.getBoja()+ ", boja unutrasnjosti = "+ super.getBojaUnutrasnjosti();
		return s;
	}
	
	public boolean equals(Object obj){
		if (obj instanceof Krug){
			Krug druga = (Krug)obj;
			if (centarKruga.equals(druga.getCentarKruga()) 
			    && poluprecnik == druga.getPoluprecnik()
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
		g.drawOval(centarKruga.getX()-poluprecnik, centarKruga.getY()-poluprecnik, 2*poluprecnik, 2*poluprecnik);
		if(isSelektovan()){
			Tacka gore = new Tacka(centarKruga.getX(), centarKruga.getY()-poluprecnik);
			Tacka dole = new Tacka(centarKruga.getX(), centarKruga.getY()+ poluprecnik);
			Tacka levo = new Tacka(centarKruga.getX()-poluprecnik, centarKruga.getY());
			Tacka desno = new Tacka(centarKruga.getX()+poluprecnik, centarKruga.getY());
			gore.crtajKvadratic(g);
			dole.crtajKvadratic(g);
			levo.crtajKvadratic(g);
			desno.crtajKvadratic(g);
		}
	}

	public void popuni(Graphics g) {
		g.setColor(getBojaU());
		g.fillOval(centarKruga.getX()-poluprecnik, centarKruga.getY()-poluprecnik, 2*poluprecnik, 2*poluprecnik);
	}

	public boolean sadrzi(int x, int y) {
		Tacka prosledjena = new Tacka(x,y);
		if (prosledjena.udaljenost(centarKruga)<=poluprecnik){
			return true;
		} else {
			return false;
		}
		
	}

	public int compareTo(Object o) {
		Krug prosledjen = (Krug)o;
		int result = this.poluprecnik - prosledjen.poluprecnik;
		return result;
	}
	
}
