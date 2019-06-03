package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat {
	
	private int visina;
	
	public Pravougaonik(){
	}
	
	public Pravougaonik(Tacka novoGoreLevo, int novaSirina, int novaVisina){
		super(novoGoreLevo, novaSirina);
		visina = novaVisina;
	}
	
	public Pravougaonik(Tacka novoGoreLevo, int novaSirina, int novaVisina, String novaBoja){
		this(novoGoreLevo, novaSirina, novaVisina);
		setBoja(novaBoja);
	}
	
	public Pravougaonik(Tacka novoGoreLevo, int novaSirina, int novaVisina, 
			String novaBoja, String novaBojaUnutrasnjosti){
		this(novoGoreLevo, novaSirina, novaVisina);
		setBoja(novaBoja);
		setBojaUnutrasnjosti(novaBojaUnutrasnjosti);
	}
	
	public Pravougaonik(Tacka novoGoreLevo, int novaSirina, int novaVisina, 
			Color novaBoja, Color novaBojaUnutrasnjosti){
		this(novoGoreLevo, novaSirina, novaVisina);
		setBoja1(novaBoja);
		setBojaU(novaBojaUnutrasnjosti);
	}
	

	
	public void setVisina(int novaVisina){
		visina = novaVisina;
	}
	
	public int getVisina(){
		return visina;
	}
	
	public void pomeriZa(int pomeriZaX, int pomeriZaY){
		//super.getGoreLevo().pomeriZa(pomeriZaX, pomeriZaY);
		super.goreLevo.pomeriZa(pomeriZaX, pomeriZaY);
	}
	
	public void pomeriNa(int pomeriNaX, int pomeriNaY){
		super.goreLevo.pomeriNa(pomeriNaX, pomeriNaY);
	}
	
	public double povrsina(){
		int povrsina=super.getSirina()*visina;
		return povrsina;
	}
	
	public double obim(){
		int obim = 2*super.getSirina()+2*visina;
		return obim;
	}
	
	public Linija dijagonala(){
		int doleDesnoX = goreLevo.getX() + super.getSirina();
		int doleDesnoY = goreLevo.getY() + visina;
		
		Tacka doleDesno = new Tacka();
		doleDesno.setX(doleDesnoX);
		doleDesno.setY(doleDesnoY);
		
		Linija dijagonala = new Linija();
		dijagonala.setPocetna(goreLevo);
		dijagonala.setKrajnja(doleDesno);
		return dijagonala;
	}
	
	public Tacka centarPravougaonika(){
		return dijagonala().sredinaLinije();
	}
	
	public String toString(){
		String s = "gornji levi ugao=" 
					+ goreLevo.toString() 
					+ ", sirina=" 
					+ super.getSirina() 
					+ ", visina=" 
					+ visina;
		return s;
	}
	
	public boolean equals(Object obj){
		if (obj instanceof Pravougaonik){
			Pravougaonik druga = (Pravougaonik)obj;
			if (goreLevo.equals(druga.getGoreLevo()) 
			    && super.getSirina() == druga.getSirina()
			    && visina == druga.getVisina()
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
		g.drawRect(goreLevo.getX(), goreLevo.getY(), getSirina(), visina);
		if(isSelektovan()){
			Tacka goreDesno = new Tacka(goreLevo.getX()+getSirina(), goreLevo.getY());
			Tacka doleLevo = new Tacka(goreLevo.getX(), goreLevo.getY()+visina);
			Tacka doleDesno = new Tacka(goreLevo.getX()+getSirina(), goreLevo.getY()+visina);
			Tacka goreSredina = new Tacka(goreLevo.getX()+getSirina()/2, goreLevo.getY());
			Tacka doleSredina = new Tacka(goreLevo.getX()+ getSirina()/2, goreLevo.getY()+visina);
			Tacka levoSredina = new Tacka(goreLevo.getX(), goreLevo.getY()+visina/2);
			Tacka desnoSredina = new Tacka(goreLevo.getX()+getSirina(),goreLevo.getY()+visina/2);
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
		g.fillRect(goreLevo.getX(), goreLevo.getY(), getSirina(), visina);
	}
	
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + getSirina())
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + visina)){
			return true;
		} else {
			return false;
		}
	}
	
	public int compareTo(Object o) {
		Pravougaonik prosledjen = (Pravougaonik)o;
		double result = this.povrsina() - prosledjen.povrsina();
		return (int)result;
	}
	
}
