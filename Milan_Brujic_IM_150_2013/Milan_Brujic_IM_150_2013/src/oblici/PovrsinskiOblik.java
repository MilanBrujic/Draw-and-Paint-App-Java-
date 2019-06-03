package oblici;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik {
	private String bojaUnutrasnjosti="bela";
	private Color bojaU=(Color.WHITE);
	
	
	
	

	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}
	
	
	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	
	
	public Color getBojaU() {
		return bojaU;
	}


	public void setBojaU(Color bojaU) {
		this.bojaU = bojaU;
	}


	public abstract void popuni(Graphics g);
	
	public abstract double povrsina();
	
	public abstract double obim();
	
}
