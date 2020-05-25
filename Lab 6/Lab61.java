import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

class ca {

	private boolean[] cell;
	private int size;
	private int rule;
	private boolean[] ttable;
	
	ca(int size, int rule){
		
		this.size = size;
		this.rule = rule;
		cell = new boolean[size];
		ttable = new boolean[8];
		
		for (int i = 0; i < size; i++){
			cell[i] = false;
		}
		
		cell[size/2] = true;
		StringBuffer s = new StringBuffer(Integer.toBinaryString(rule));

		while (s.length() != 8)
			s.insert(0, "0");
		
		s.reverse();

		for (int i = 0; i < 8; i++){
			if (s.charAt(i) == '1')
				ttable[i] = true;
			else
				ttable[i] = false;
		}
	}
	
	public void test (){
		
		for (int i = 0; i < 8; i++){
			
		System.out.println(ttable[i] + ", ");
		
		}
		
	}
	
	public int toInt(boolean b) {
		
		return b ? 1 : 0;
		
	}
	
	public boolean[] printState(){
	
		return cell;
	
	}
	
	public boolean[] getState(){
		
		boolean[] out = new boolean[size];
		int index;
		for (int i = 1; i < size-1; i++){
			index = 4 * toInt(cell[i-1]) + 2 * toInt(cell[i]) + toInt(cell[i+1]);
			out[i] = ttable[index];

		}
		out[0] = ttable[4 * toInt(cell[size-1]) + 2 * toInt(cell[0]) + toInt(cell[1])];
		out[size-1] = ttable[4 * toInt(cell[size-2]) + 2 * toInt(cell[size-1]) + toInt(cell[0])];
		this.cell = out;
		return out;
		
	}

}

class SwingCA extends JPanel {
    private static final int WINDOW_WIDTH = 415;
    private static final int WINDOW_HEIGHT = 639;
    private static int inputRule;
	

    public SwingCA(int inputRule) {
		this.inputRule = inputRule;
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    }  

    protected void paintComponent( Graphics g ) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
		
		int size = 400;	
		
		int rule = inputRule;	
		
		boolean[] cell = new boolean[size];
		boolean[] firstCell = new boolean[size];
		ca CA = new ca(size,rule);
		firstCell = CA.printState();

		
		for (int j = 0; j < 400; j++){
			int i = 0;
			if (firstCell[j] == false)
				g2d.setColor(Color.WHITE);
			else
				g2d.setColor(Color.BLACK);
			
			Rectangle2D r = new Rectangle2D.Double(j, i, 1, 1);
            g2d.fill(r);
		
		}	
		
		
		for (int i = 1; i < 600; i++){
			
			cell = CA.getState();
			
			for (int j = 0; j < 400; j++){
				
				if (cell[j] == false)
					g2d.setColor(Color.WHITE);
				else
					g2d.setColor(Color.BLACK);
				if (j == 400-1)
					g2d.setColor(Color.WHITE);
				
                Rectangle2D r = new Rectangle2D.Double(j, i, 1, 1);
                g2d.fill(r);				
			
			}
		
		}
		
    }
	
    public static void runApplication(JPanel app) {
        JFrame frame = new JFrame();
        frame.setSize(app.getPreferredSize());
        frame.setTitle(app.getClass().getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(app);
        frame.setVisible(true);
    }

	
}

class Lab61 {
	
	public static void main (String[] args){
		
		int ruleNum = Integer.parseInt(args[0]);
        SwingCA s = new SwingCA(ruleNum);
        runApplication(s);
		
	}
	
    public static void runApplication(JPanel app) {
        JFrame frame = new JFrame();
        frame.setSize(app.getPreferredSize());
        frame.setTitle(app.getClass().getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(app);
        frame.setVisible(true);
    }
	
	
	
}





































