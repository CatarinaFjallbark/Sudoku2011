import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class SudokuSquares extends JTextField implements KeyListener   {
	
	/*Sets all settings in the window such as color etcetera */
	public SudokuSquares(){
		super(); 
		setBackground(new Color(230, 80, 128));
		setForeground(new Color(160, 30, 58));
		addKeyListener(this);
		setFont(new Font("Calibri", 50, 50));
		setHorizontalAlignment(CENTER);
		setBorder(new LineBorder(Color.BLACK, 2));

	
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/*keyTyped forbids the user to put a character smaller than one and
	 * higher than nine */
	public void keyTyped(KeyEvent arg0) {
		if(this.getText().length()>0){
			arg0.consume();
		}
		if(!(arg0.getKeyChar() >= KeyEvent.VK_1 && arg0.getKeyChar() <= KeyEvent.VK_9)){
		arg0.consume();
		}
		
	}

}
