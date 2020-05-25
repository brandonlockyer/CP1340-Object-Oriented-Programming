class CA{
	private boolean[] cell;
	private int size;
	private int rule;
	private boolean first;
	private boolean[] ttable;
	
	public CA(int size, int rule){
		first = true;
		cell = new boolean [size];
		cell[size/2] = true;
		dtob(rule);
	}
	
	private void dtob (int rule){
		ttable = new boolean[8];
		
		for (int i = 0; i < ttable.length - 1 ; i++){
			if (rule % 2 == 1) ttable[i] = true;
			else ttable[i] = false;
			rule = rule/2;
			//System.out.println(ttable[i]);
		}
		
	}	
	
	public boolean[] getState(){
		int left = 0;
		int cur = 0;
		int right = 0;
		int index;
		boolean[] next = new boolean[cell.length];
		String output = "";
		
		for (int i = 0; i < cell.length; i++){
			if (first){ first = false; return cell;}
			
			if(i > 0){
				if (cell[i-1]) {left = 1;}
			}else{
				if(cell[cell.length - 1]) left = 1;
				else left = 0;
			}
			
			if (cell[i]) {cur = 1;}
			
			if (i < cell.length - 1){
				if (cell[i+1]) {right = 1;}
			}
			else{
				if (cell[0]){ right = 1;}
			}
			index = 4 * left + 2 * cur + 1 * right;
			
			left = 0;
			cur = 0;
			right = 0;
			
			System.arraycopy(ttable,index,next,i,1);
		}
		cell = next.clone();
		return cell;
		//System.out.println(output);
		
	}
}

public class Lab32{
	public static void main (String[] args){
		CA a = new CA(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		boolean[] aLine;
		
		for (int i = 0; i < 100; i++){
			aLine = a.getState();
			for (int j = 0; j < aLine.length; j++){
				if (aLine[j] == false) System.out.print(" ");
				else System.out.print("X");
			}
		System.out.print("\n");
		}
	}
}