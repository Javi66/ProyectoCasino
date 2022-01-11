package ventana;


import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import clases.Ranking;
import database.Db;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class VentanaRuleta extends JFrame {
	 private JButton jBnegro;
	 private JButton jBrojo;
	 private JButton jBverde;
	 private JLabel jLimg;
	 private JButton jBaniadir;
	 private JButton jBmenu;
	 private JFrame jFrame1;
	 private JLabel jLsaldo;
	 private JLabel jLsaldodinero;
	 private JLabel jLapuesta;
	 private JPanel jPsaldo;
	 private JTextField jTxtapuesta;
	 private int saldo= 0;
	 private String eleccion = "";
	 public static JLabel lblNumero;
	 public static boolean ganado = false;
	 private int puntos = 0;
	 private JLabel lblpuntos;
	 private int numpartida;
	    
     public VentanaRuleta(String usuario) {
        initComponents(usuario);
        setLocationRelativeTo(null);
    }
  
    private void initComponents(String usuario) {
   
    	Properties properties = new Properties();
    	
    	try {
			properties.loadFromXML(new FileInputStream("properties.xml"));
			if (properties.containsKey(usuario)) {
				saldo = Integer.parseInt(properties.getProperty(usuario));
			}
	    	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	

        jFrame1 = new JFrame();
        jTxtapuesta = new JTextField();
        jPsaldo = new JPanel();
        jLsaldo = new JLabel();
        jBrojo = new JButton();
       jBrojo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(saldo<=Integer.parseInt(jTxtapuesta.getText())||jTxtapuesta.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Apuesta una cantidad que te puedas permitir", "Error",
							JOptionPane.ERROR_MESSAGE);
        		}else{
        			VentanaTragaperras.ReproducirSonido("ruleta.wav");
        			try {
						Thread.sleep(400);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
        			eleccion = "rojo";
        			ganado = girarRuleta(eleccion);
        			if(ganado) {
        				saldo = saldo- Integer.parseInt(jTxtapuesta.getText());
            			jLsaldodinero.setText("" + saldo);
            			puntos = puntos + Integer.parseInt(jTxtapuesta.getText())*10;
            			lblpuntos.setText("Puntos: "+puntos);
                		mensajeTirada(true);
        			}else {
        				saldo = saldo- Integer.parseInt(jTxtapuesta.getText());
            			jLsaldodinero.setText("" + saldo);
                		mensajeTirada(false);
        			}
        			
        		}
        	}
        });
        jBverde = new JButton();
        jBverde.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(saldo<=Integer.parseInt(jTxtapuesta.getText())||jTxtapuesta.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Apuesta una cantidad que te puedas permitir", "Error",
							JOptionPane.ERROR_MESSAGE);
        		}else{
        			VentanaTragaperras.ReproducirSonido("ruleta.wav");
        			try {
						Thread.sleep(400);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
        			eleccion = "verde";
        			ganado = girarRuleta(eleccion);
        			if(ganado) {
        				saldo = saldo- Integer.parseInt(jTxtapuesta.getText());
            			jLsaldodinero.setText("" + saldo);
            			puntos = puntos + Integer.parseInt(jTxtapuesta.getText())*200;
            			lblpuntos.setText("Puntos: "+puntos);
                		mensajeTirada(true);
        			}else {
        				saldo = saldo- Integer.parseInt(jTxtapuesta.getText());
            			jLsaldodinero.setText("" + saldo);
                		mensajeTirada(false);
        			}
        			
        		}   		
        	
        	}
        });
        jBnegro = new JButton();
        jBnegro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(saldo<=Integer.parseInt(jTxtapuesta.getText())||jTxtapuesta.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Apuesta una cantidad que te puedas permitir", "Error",
							JOptionPane.ERROR_MESSAGE);
        		}else{
        			VentanaTragaperras.ReproducirSonido("ruleta.wav");
        			try {
						Thread.sleep(400);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
        			eleccion = "negro";
        			ganado = girarRuleta(eleccion);
        			if(ganado) {
        				saldo = saldo- Integer.parseInt(jTxtapuesta.getText());
            			jLsaldodinero.setText("" + saldo);
            			puntos = puntos + Integer.parseInt(jTxtapuesta.getText())*10;
            			lblpuntos.setText("Puntos: "+puntos);
                		mensajeTirada(true);
        			}else {
        				saldo = saldo- Integer.parseInt(jTxtapuesta.getText());
            			jLsaldodinero.setText("" + saldo);
                		mensajeTirada(false);
        			}
        			
        		}
        	}
        });
        jLimg = new JLabel();
       
        
        jBaniadir = new JButton("AÃ±adir dinero");
        jBaniadir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cant = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dinero que quieres ingresar: "));
        		int tot = cant +saldo;
        		jLsaldodinero.setText(tot+"$");
        		saldo = tot;
        	}
        });

        jLapuesta = new JLabel();
       GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);
   

        jTxtapuesta.setFont(new java.awt.Font("Arial", 0, 16));
       
       
        jLsaldo.setFont(new java.awt.Font("Arial", 1, 16)); 
        jLsaldo.setForeground(Color.BLACK);
        jLsaldo.setText("Saldo:");
        
        jLsaldodinero = new JLabel(saldo+" $");
        jLsaldodinero.setFont(new java.awt.Font("Arial", 1, 16)); 
        jLsaldodinero.setForeground(Color.BLACK);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPsaldo);
        jPanel12Layout.setHorizontalGroup(
        	jPanel12Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel12Layout.createSequentialGroup()
        			.addComponent(jLsaldo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLsaldodinero, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
        	jPanel12Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel12Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel12Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLsaldo)
        				.addComponent(jLsaldodinero))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPsaldo.setLayout(jPanel12Layout);

        jBrojo.setBackground(Color.RED);
        jBrojo.setFont(new Font("Arial", 1, 14));
        jBrojo.setForeground(Color.WHITE);
        jBrojo.setText("ROJO");
       
        jBverde.setBackground(Color.GREEN);
        jBverde.setFont(new Font("Arial", 1, 14));
        jBverde.setForeground(Color.WHITE);
        jBverde.setText("VERDE");
       
        jBnegro.setBackground(Color.BLACK);
        jBnegro.setFont(new Font("Arial", 1, 14));
        jBnegro.setForeground(Color.WHITE);
        jBnegro.setText("NEGRO");
        
        jBaniadir.setForeground(Color.BLACK);
        jBaniadir.setBackground(Color.BLUE);
        jBaniadir.setFont(new Font("Arial", 1, 14));
        
        jLimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ruleta.jpg")));
       
        jLapuesta.setFont(new Font("Arial", 1, 14)); 
        jLapuesta.setText("Apuesta de:");
        
        jBmenu = new JButton("Menu");
        jBmenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				try {
					Db.initDB("casino1.db", false);
					numpartida = Db.obtenerPartidas(usuario) + 1;
					Ranking r = new Ranking("Ruleta", usuario, numpartida, puntos);
					Db.anadirRanking(r);
					Db.closeBD();
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		Main m = new Main(usuario);
        		m.setVisible(true);
        		dispose();
        		if(usuario!="") {
        			Main.activarBotones();
        		}
        	}
        });
       
        
        jBmenu.setFont(new Font("Arial", Font.PLAIN, 14));
        jBmenu.setBackground(Color.RED);
        
        lblNumero = new JLabel("Numero: ");
        lblNumero.setForeground(Color.BLACK);
        lblNumero.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        lblpuntos = new JLabel("Puntos:"+" "+puntos);
        lblpuntos.setForeground(Color.BLACK);
        lblpuntos.setFont(new Font("Arial", Font.BOLD, 16));
        
        
        
       
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(14)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLimg, GroupLayout.PREFERRED_SIZE, 709, Short.MAX_VALUE)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jBrojo, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
        							.addGap(14)
        							.addComponent(jBverde, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(jBnegro, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jBaniadir, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(jLapuesta, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(jTxtapuesta, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)))
        							.addGap(59)
        							.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPsaldo, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
        					.addGap(8)
        					.addComponent(lblpuntos, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 411, Short.MAX_VALUE)
        					.addComponent(jBmenu)
        					.addGap(20))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jPsaldo, GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
        						.addComponent(jBmenu)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(19)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblpuntos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jBaniadir))
        					.addGap(11)))
        			.addGap(26)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLapuesta)
        				.addComponent(jTxtapuesta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNumero))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLimg, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jBrojo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jBnegro, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jBverde, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        			.addGap(22))
        );
        getContentPane().setLayout(layout);

        pack();
        
        this.addWindowListener( new WindowAdapter() {
        	public void windowClosing( WindowEvent evt ) {
        	
        	
        	properties.setProperty(usuario, String.valueOf(saldo));
        	try {
				properties.storeToXML(new FileOutputStream("properties.xml"), "casino");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      	
        	}
        } );

       
    }
    
   


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRuleta("").setVisible(true);
            }
        });
    }
    
    
    public static  boolean girarRuleta(String eleccion) {
   
    	 HashMap<Integer,String> ruletamap = new HashMap();
         ruletamap.put(0, "verde");
         ruletamap.put(1, "rojo");
         ruletamap.put(2, "negro");
         ruletamap.put(3, "rojo");
         ruletamap.put(4, "negro");
         ruletamap.put(5, "rojo");
         ruletamap.put(6, "negro");
         ruletamap.put(7, "rojo");
         ruletamap.put(8, "negro");
         ruletamap.put(9, "rojo");
         ruletamap.put(10, "negro");
         ruletamap.put(11, "negro");
         ruletamap.put(12, "rojo");
         ruletamap.put(13, "negro");
         ruletamap.put(14, "rojo");
         ruletamap.put(15, "negro");
         ruletamap.put(16, "rojo");
         ruletamap.put(17, "negro");
         ruletamap.put(18, "rojo");
         ruletamap.put(19, "rojo");
         ruletamap.put(20, "negro");
         ruletamap.put(21, "rojo");
         ruletamap.put(22, "negro");
         ruletamap.put(23, "rojo");
         ruletamap.put(24, "negro");
         ruletamap.put(25, "rojo");
         ruletamap.put(26, "negro");
         ruletamap.put(27, "rojo");
         ruletamap.put(28, "negro");
         ruletamap.put(29, "negro");
         ruletamap.put(30, "rojo");
         ruletamap.put(31, "negro");
         ruletamap.put(32, "rojo");
         ruletamap.put(33, "negro");
         ruletamap.put(34, "rojo");
         ruletamap.put(35, "negro");
         ruletamap.put(36, "rojo");
         
         Random random = new Random();
         int numero = random.nextInt(36);
   
         System.out.println(numero);
         lblNumero.setText("Numero:" +" "+String.valueOf(numero) + ", " + ruletamap.get(numero));
         
         String color = ruletamap.get(numero);
         
         if (color.equals(eleccion)) {
        	 ganado = true;
         } else {
        	 ganado = false;
         }
    	
		return ganado;
    };
    
 
	public static void mensajeTirada(boolean ganado) {
    	if (ganado) {
    		JOptionPane.showMessageDialog(null, "¡Has ganado!", "Resultado.",JOptionPane.INFORMATION_MESSAGE);
    		System.out.println("GANADO");
    	}else {
    		JOptionPane.showMessageDialog(null, "Has perdido", "Resultado.",JOptionPane.INFORMATION_MESSAGE);
    		System.out.println("PERDIDO");
    		
    	}
    	
    }
}
