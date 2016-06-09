import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class MyWindow extends JFrame {

	public final static int SOLVE = 2;
	public final static int CLEAR_ALL = 1;

	private JTextField textMatris [][];
	private JPanel panelC;
	private JPanel panelS;

	/*Creates panels, buttons and adds actionlisteners to the buttons. */
	public MyWindow(String a){

		super(a); 



		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panelC = new JPanel();
		panelS = new JPanel();

		JButton c = new JButton("Clear");
		JButton s = new JButton("Solve");

		panelS.add(c);
		panelS.add(s); 

		c.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				setGrid(new int[9][9]);

			}
		});

		s.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				int [][] tempMatris = getGrid();
				Sudoku s = new Sudoku();
				boolean solvable=true;

				for (int i=0;i<9 && solvable;i++){
					for (int j = 0; j<9 && solvable;j++){
						if(tempMatris[i][j]!=0){
							if(s.canPut(i, j, tempMatris[i][j])){
								s.put(i, j, tempMatris[i][j]);
								/*Shows a message to the user saying "Impossible to solve the Sudoku" 
								when it is impossible to solve the sudoku. */
							}else{
								JOptionPane.showMessageDialog(null,"Impossible to solve the Sudoku!");
								solvable=false;
							}
						}
					}
				}
				if (solvable){
					s = SudukoSolve.solve(s);
					if (s!=null){
						setGrid(s.getBox());
					}else{
						JOptionPane.showMessageDialog(null,"Impossible to solve the Sudoku!");
					}
				}

			}
		});

		textMatris = initTextFields(9, 9);

		panelC.setLayout(new GridLayout (9, 9));
		add(panelC, BorderLayout.CENTER);
		add(panelS, BorderLayout.SOUTH);

		setSize(800,700);
		setVisible(true);


	}

	/* getGrid gets the numbers.
	 * @return returns a matrix that contains the numbers put
	  	into the window by the program user */
	public int[][] getGrid(){
		int [][] temp = new int [9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if (!textMatris[i][j].getText().isEmpty())
					temp[i][j] = Integer.valueOf(textMatris[i][j].getText());
			}
		}

		return temp;
	}
	/*setGrid sets the Sudoku into the window that the matrix param contains.
	 * @Param setGrid shall have a int Matrix that contains a sudoku. */
	public void setGrid(int [][] intMatris){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(intMatris[i][j] == 0){
					textMatris[j][i].setText("");
				}else{
					textMatris[j][i].setText(String.valueOf(intMatris[i][j]));

				}
			}
		}
	}

	/* initTextFields makes it possible for the user to write in their numbers because it 
	 * creates new JTextFields.
	 * @param int x and int y indicate what position in the matrix that is wanted.
	 * @return returns a JTextField matrix.*/
	private JTextField[][] initTextFields(int x, int y){
		JTextField temp[][] = new JTextField[x][y];
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				temp[i][j]=new SudokuSquares();

				if(i/3 %2==0 && j/3 %2==0 || (i/3==1 && j/3==1)){
					temp[i][j].setBackground(new Color(160, 30, 58));
					temp[i][j].setForeground(new Color(230, 80, 128));
				}
				panelC.add(temp[i][j]);

			}
		}

		return temp;
	}


	public static void main(String args[]){
		new MyWindow("Cattas Sudoku");
	}


}
