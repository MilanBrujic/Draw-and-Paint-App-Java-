package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik{
	private int x;
	private int y;
	
	public Tacka(){
	}
	
	public Tacka(int novoX, int novoY){
		x = novoX;
		y = novoY;
	}
	
	public Tacka(int novoX, int novoY, String novaBoja){
		super(novaBoja);
		x = novoX;
		y = novoY;
	}
	
	public Tacka(int novoX, int novoY, Color novaBoja){
		super(novaBoja);
		x = novoX;
		y = novoY;
	}
	

	
	public void setX(int novoX){
		x = novoX;
	}
	
	public void setY(int novoY){
		y = novoY;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void pomeriNa(int pomeriNaX, int pomeriNaY){
		x = pomeriNaX;
		y = pomeriNaY;
	}
	
	public void pomeriZa(int pomeriZaX, int pomeriZaY){
		x = x + pomeriZaX;
		y = y + pomeriZaY;
	}
	
	public double udaljenost(Tacka druga){
		//int rastojanjeX = druga.getX()-x;
		int rastojanjeX = druga.x-this.x;
		int rastojanjeY = druga.getY()-y;
		double izracunataUdaljenost = Math.sqrt(rastojanjeX*rastojanjeX + rastojanjeY*rastojanjeY);
		return izracunataUdaljenost;
	}
	
	public String toString(){
		String s = "(" + x + "," + y + ")";
		return s;
	}
	
	public boolean equals(Object obj){
		if (obj instanceof Tacka){
			Tacka druga = (Tacka)obj;
			if (x == druga.getX() 
			    && y == druga.getY()
			    && getBoja().equals(druga.getBoja())){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean daLiJeKvadrat(Tacka t1, Tacka t2, Tacka t3, Tacka t4){
		if (t1.y==t2.y
				&& t1.x==t3.x
				&& t1.udaljenost(t2)==t1.udaljenost(t3)
				&& t4.x==t2.x
				&& t4.y==t3.y){
			return true;
		}else {
			return false;
		}

	}
	
	public static boolean daLiJePravougaonik(Tacka t1, Tacka t2, Tacka t3, Tacka t4){
		if (t1.y==t2.y
				&& t1.x==t3.x
				&& t4.x==t2.x
				&& t4.y==t3.y){
			return true;
		}else {
			return false;
		}

	}
	
	public static boolean daLiJePravougaonikANijeKvadrat(Tacka t1, Tacka t2, Tacka t3, Tacka t4){
		if (daLiJePravougaonik(t1, t2, t3, t4) 
				&& !daLiJeKvadrat(t1, t2, t3, t4)){
			return true;
		}else {
			return false;
		}

	}

	public void crtajSe(Graphics g){
		g.setColor(getBoja1());
		g.drawLine(x-1, y-1, x+1, y+1);
		g.drawLine(x-1, y+1, x+1, y-1);
		if(isSelektovan()){
			this.crtajKvadratic(g);
		}
	}

	public boolean sadrzi(int x, int y) {
		Tacka prosledjena = new Tacka(x, y);
		if(this.udaljenost(prosledjena)<=3){
			return true;
		} else {
			return false;
		}
	}
	
	public void crtajKvadratic(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(this.getX()-2, this.getY()-2, 5, 5);
	}

	@Override
	public int compareTo(Object o) {
		Tacka prosledjena = (Tacka)o;
		Tacka nulta = new Tacka(0, 0);
		double result = this.udaljenost(nulta)-prosledjena.udaljenost(nulta);
		return (int)result;
	}
	

}
