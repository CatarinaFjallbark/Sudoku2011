
public class SudukoSolve {

	/*solve gives a solved sudoku,
	 * @param what Sudoku we will solve
	 * @return returns a solved sudoku.*/
	public static Sudoku solve(Sudoku s){
		return solve(0, 0, s);
	}

	/**solve gives a solved sudoku,
	 * @param int x and int y is from what position we want to begin,
	 *  what Sudoku we want to solve is also included.
	 * @return returns a solved Sudoku. */
	private static Sudoku solve(int x, int y, Sudoku s){
		Sudoku temp = null;
		int oldX = x;
		int oldY = y;

		
		

		if(!s.boxEmpty(x, y)){
			if(x==8){
				if(y==8){
					return s;
				}
				x=0;
				y=oldY+1;
			}else{
				x=oldX+1;
			}
			return solve(x, y, s);
		}
		for(int i = 1; i < 10; i++){


			if(s.canPut(oldX, oldY, i)){

					
				s.put(oldX, oldY, i);
				if(oldX==8){
					if(oldY==8){
						return s;
					}else{
						x=0;
						y=oldY+1;
					}
				}else{
					x=oldX+1;
				}
				temp = solve(x, y, s);
				if(temp!=null){
					return temp; 
				}
				s.put(oldX, oldY, 0);
			}
		}
		return null;
	}

}
