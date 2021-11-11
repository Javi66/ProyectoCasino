package clases;


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
		
		
	

}
 