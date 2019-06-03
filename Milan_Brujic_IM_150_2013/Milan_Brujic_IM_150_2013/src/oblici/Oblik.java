package oblici;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Pomerljiv, Comparable{
	
	private String boja;
	private boolean selektovan;
	private Color boja1;

	
	public boolean isSelektovan() {
		return selektovan;
	}

	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}

	public Oblik(){
		
	}
	
	public Oblik(String novaBoja){
		boja= novaBoja;
	}
	
	public void setBoja(String novaBoja){
		boja = novaBoja;
		
	}

	public String getBoja(){
		return boja;
	}
	
	public  Oblik(Color novaBoja1){
		boja1=novaBoja1;
	}
	
	
	

	
	public Color getBoja1() {
		return boja1;
	}

	public void setBoja1(Color boja1) {
		this.boja1 = boja1;
	}

	public abstract void crtajSe(Graphics g);
	
	public static Color pronadjiBoju(String boja){
		switch(boja){
		case "crvena":
			return Color.RED;
		case "plava":
			return Color.BLUE;
		case "zuta":
			return Color.YELLOW;
		case "zelena":
			return Color.GREEN;
		case "bela":
			return Color.WHITE;
		case "crna":
			return Color.BLACK;
		default:
			return Color.BLACK;
		}
	}
	
	public abstract boolean sadrzi(int x, int y);
}
