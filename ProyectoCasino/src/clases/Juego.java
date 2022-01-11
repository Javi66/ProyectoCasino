package clases;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public abstract class Juego {
	

		private int giros;
		private double dineroapostado;
		private Usuario usuario;
		
		
		public Juego() {
			super();
		}


		public Juego(int giros, double dineroapostado, Usuario usuario) {
			super();
			this.giros = giros;
			this.dineroapostado = dineroapostado;
			this.usuario = usuario;
		}


		public int getGiros() {
			return giros;
		}


		public void setGiros(int giros) {
			this.giros = giros;
		}


		public double getDineroapostado() {
			return dineroapostado;
		}


		public void setDineroapostado(double dineroapostado) {
			this.dineroapostado = dineroapostado;
		}


		public Usuario getUsuario() {
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}


		@Override
		public String toString() {
			return "Juego [giros=" + giros + ", dineroapostado=" + dineroapostado + ", usuario=" + usuario + "]";
		}
		
		
		public static void ReproducirSonido(String nombreSonido){
		       try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
		         System.out.println("Error al reproducir el sonido.");
		       }
		}
		
	

}
 