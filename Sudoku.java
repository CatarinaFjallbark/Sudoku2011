
public class Sudoku {

	private int [][] matrisen;

	public Sudoku(int matrisen[][]){
		this.matrisen = matrisen;
	}

	/* Sudoku creates a new matrix with 9*9 squares */
	public Sudoku(){
		matrisen=new int[9][9];
	}

	/* put puts number into wanted position
	 * @param int x and int y tells what position the int number will be placed*/
	public void put(int x, int y, int number){

		matrisen[x][y] = number;

	}

	/*toString method convert the int in the matrix to a string and 
	 * @return return the string */
	public String toString(){
		String s = "";
		for(int i = 0; i < 9; i ++){
			for(int j = 0; j < 9; j++){
				s += (matrisen[i][j]) + " ";
			}
			s += "\n";
		} 
		return s;
	}

	/*canPut tells us if it is possible according to the sudoku rules to put a certain number.
	 * @param int x and int y tells what place that is wanted the be controlled and int number 
	 * is the number that shall be checked if it is possible to put.
	 * @return returns true if it is possible to put number according to the sudoko rules and false
	 * if it is not*/
	public boolean canPut(int x, int y, int number){
		if(matrisen[x][y] != 0){
			return false;
		}


		for(int i = 0; i<9; i++){
			if(matrisen[i][y]==number){
				return false;
			}
		}
		for(int i = 0; i<9; i++){
			if(matrisen[x][i]==number){
				return false;
			}
		}
		int d = x/3;
		d *=3;
		int l = y/3;
		l *=3;

		for(int i = d; i< d+3; i++){
			for(int j = l; j < l+3; j++){
				if(matrisen[i][j]==number){
					return false;
				}
			}
		}
		return true;
	}

	/*boxEmpty controls if the square got a number or not
	 * @param what position we want to control
	 * @return return true if the box is empty and false if it is not. */
	public boolean boxEmpty(int x, int y){
		if(matrisen[x][y]==0){
			return true;
		}return false;	
	}

	/*get box gives all the boxes in the sudoku
	 * @return returns a matrix with the boxes. */
	public int[][] getBox(){
		return matrisen;
	}
}
