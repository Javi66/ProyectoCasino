package clases;


public class Tragaperras extends Juego{
	
	/*iconos(0) = 7
	* iconos(1) = bar
	* iconos(2) = campana
	* iconos(3) = cerezas
	* iconos(4) = diamante
	* iconos(5) = dolar
	* iconos(6) = limon
	* iconos(7) = sandia
	* iconos(8) = trebol
	* iconos(9) = uva
	*/
	
	public static int score(int a, int b, int c) {
		int sc = 0;
		//CADA SIGNO DE DOLAR SUMA 200PTS (no dan recompensa por linea)
		if(a==5) {sc += 200;}
		if(b==5) {sc += 200;}
		if(c==5) {sc += 200;}
		
		//AJUSTAMOS SCORE CUANDO SE HACE LINEA DE 3
		//Todos los casos con 3 coincidentes 2 con comodin, o 1 con dos comodines
		if(a==b && a==c || a==b && b!=1 && c==1 || b==c && b!=1 && a==1 || a==c && a!=1 && b==1 || a==b && b==1 && c!=1 || b==c && b==1 && a!=1 || a==c && a==1 && b!=1) {
			if(a==0||b==0||c==0) {				//777
				 sc = 1000;
			}else if(a==2||b==2||c==2) {			//3Campanas
				sc = 750;
			}else if(a==4||b==4||c==4) {			//3Diamantes
				sc = 850;
			}else if(a==1 && b==1 && c==1) {		//3BAR (3 comodin suman)
				sc = 500;
			}else if(a==8||b==8||c==8) {			//3TREBOL
				sc = 500;
			}else if(a==3||a==6||a==7||a==9||b==3||b==6||b==7||b==9||c==3||c==6||c==7||c==9) {		//3 FRUTAS(uva, sandia, limon, cerezas)
				sc = 250;
			}
			
		//Todos los casos con 2 coincidentes y sin comodines
		}else if(a==b||b==c||a==c && a!=5||b!=5){		
			if(a==0 && b==0||b==0 && c==0||a==0 && c==0) {				//2 7s
				sc = 200;
			}else if(a==2 && b==2||b==2 && c==2||a==2 && c==2){			//2 Campanas
				sc = 150;
			}else if(a==4 && b==4||b==4 && c==4||a==4 && c==4){			//2 Diamantes
				sc = 175;
			}else if(a==8 && b==8||b==8 && c==8||a==8 && c==8){			//2 Trebol
				sc = 100;
			}else if(a==3||a==6||a==7||a==9||b==3||b==6||b==7||b==9){			//2 Frutas
				sc = 50;
			}
			
		//Ninguna coincide pero hay un comodín	
		}else if(a==1||b==1||c==1){ 
			if(a==1) {
				if(score(b,b,c)>score(c,b,c)){
					sc = score(b,b,c);		//Como es un comodín, volvemos a llamar a la función score con el valor que obtenga un resultado mayor (RECURSIVIDAD)
				} else {
					sc = score(c,b,c);
				}
			}
			if(b==1) {
				if(score(a,a,c)>score(a,c,c)){
					sc = score(a,a,c);
				} else {
					sc = score(a,c,c);
				}
			}
			if(c==1) {
				if(score(a,b,a)>score(a,b,b)){
					sc = score(a,b,a);
				} else {
					sc = score(a,b,b);
				}
			}
		}
		return sc;
	}
	
}
