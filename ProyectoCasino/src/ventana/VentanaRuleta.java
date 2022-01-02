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
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
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
	
	    
     public VentanaRuleta(String usuario) {
        initComponents(usuario);
    }
  
    private void initComponents(String usuario) {

        jFrame1 = new JFrame();
        jTxtapuesta = new JTextField();
        jPsaldo = new JPanel();
        jLsaldo = new JLabel();
        jBrojo = new JButton();
        jBrojo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jBverde = new JButton();
        jBverde.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jBnegro = new JButton();
        jBnegro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jLimg = new JLabel();
       
        
        jBaniadir = new JButton("Añadir dinero");
        jBaniadir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int cant = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dinero que quieres ingresar: "));
        		int tot = cant +saldo;
        		jLsaldodinero.setText(tot+"€");
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
        jTxtapuesta.setText("0");
       
        jLsaldo.setFont(new java.awt.Font("Arial", 1, 16)); 
        jLsaldo.setForeground(new java.awt.Color(51, 51, 51));
        jLsaldo.setText("Saldo:");
        
        jLsaldodinero = new JLabel(saldo+"€");
        jLsaldodinero.setFont(new java.awt.Font("Arial", 1, 16)); 
        jLsaldodinero.setForeground(new java.awt.Color(51, 51, 51));

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
        		Main m = new Main(usuario);
        		m.setVisible(true);
        		dispose();
        	}
        });
        jBmenu.setFont(new Font("Arial", Font.PLAIN, 14));
        jBmenu.setBackground(Color.RED);
        
       
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
        							.addComponent(jLapuesta, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(jTxtapuesta, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jBrojo, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
        							.addGap(14)
        							.addComponent(jBverde, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(jBnegro, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)))
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPsaldo, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
        					.addGap(61)
        					.addComponent(jBaniadir, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
        					.addComponent(jBmenu)
        					.addGap(20))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(19)
        					.addComponent(jBaniadir))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jBmenu)
        						.addComponent(jPsaldo, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLapuesta)
        				.addComponent(jTxtapuesta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLimg, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jBrojo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jBnegro, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jBverde, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        			.addContainerGap(22, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRuleta("").setVisible(true);
            }
        });
    }
}