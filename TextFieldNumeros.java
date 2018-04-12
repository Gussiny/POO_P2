import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

//José Fausto Rodriguez Herrera A01634943

public class TextFieldNumeros extends JTextField{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelAdvertencia;
	
	public TextFieldNumeros(JLabel labelAdvertencia) {
		super(15);
		this.labelAdvertencia=labelAdvertencia;
		this.labelAdvertencia.setForeground(Color.RED);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					Double.parseDouble(TextFieldNumeros.this.getText());
					TextFieldNumeros.this.labelAdvertencia.setText("");
				}
				catch(NumberFormatException nfe){
					TextFieldNumeros.this.labelAdvertencia.setText("Ingrese solo numeros");
				}
			}
		});
		
	}
}
