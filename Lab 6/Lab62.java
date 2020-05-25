import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

class spaceObject {

	private Ellipse2D object = new Ellipse2D.Double();
	private static Random random = new Random();
	
	private double x = 250;
	private double y = 250;
	private double originX = 250;
	private double originY = 250;	
	private double orbit;
	private double parentOrbit = 0;	
	private double starSize;
	private double t = 0;
	private double speed = random.nextDouble() * 0.03 + 0.005;
	private Color color;
	
	
	spaceObject(double orbit, double starSize, Color color){
		
		x = x + orbit;
		this.orbit = orbit;
		this.starSize = starSize;
		this.color = color;
		
		this.object.setFrame(x, y, starSize, starSize);
	}
	
	public double[] getOrigin(){
	
		double[] r = {this.x, this.y};
		return r;
	
	}
	
	public void setOrigin(spaceObject o){
	
		double[] r = o.getOrigin();
		this.originX = r[0];
		this.originY = r[1];
		
	}	
	
    public void print(Graphics2D g) {
		Color c = g.getColor();
        g.setColor(color);
        g.fill(object);
		g.setColor( c );
    }
	
	public void Orbit(){
		
		t = t + speed;
		int size = 25;
		if (t == 2.02)
			t = 0;
		
		if (starSize == 50)
			size = 0;
		
		if (starSize == 10)
			size = 11;
		
		x = originX + size + orbit * Math.cos(t);
		y = originY + size + orbit * Math.sin(t);
		
		this.object.setFrame(x, y, starSize, starSize);
		
	}

}

public class Lab62 extends JPanel implements ActionListener {

    private javax.swing.Timer timer;
	private spaceObject objects[];
	
    public Lab62() {
		
		setBackground( Color.BLACK );
		objects = new spaceObject[4];

		objects[0] = new spaceObject(0, 50, Color.YELLOW);
		objects[1] = new spaceObject(60, 18, Color.RED);
		objects[2] = new spaceObject(130, 22, Color.BLUE);
		objects[3] = new spaceObject(45, 10, Color.WHITE);
		
        timer = new javax.swing.Timer(25, this);
        timer.start();
    }
	

		
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		for ( int i = 0 ; i < 4; i++ ) {

			objects[i].print( g2d );

        }

	}
	
	public void actionPerformed(ActionEvent e){
			
		for ( int i = 0 ; i < 4; i++ ) {

			objects[3].setOrigin(objects[2]);
            objects[i].Orbit();
			
        }
		repaint();
	}
	
	public static void main(String[] args){
			
			Lab62 Lab = new Lab62();
			JFrame frame = new JFrame();
			
			frame.setTitle("Galaxy");
			frame.setSize(600, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(Lab);
        		frame.setVisible(true);
	}

}