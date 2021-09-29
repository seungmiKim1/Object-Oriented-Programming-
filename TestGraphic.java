import java.awt.*; 
import java.util.*;

class GraphicThread extends Frame implements Runnable { 
	int num; 
	Color color; 
	Random r;
	int x,y; 
	
	public GraphicThread(int n, Color c) { 
		num = n; 
		color = c;
		r = new Random();
	} 
	public void paint(Graphics g) { 
		g.setColor(color);
		g.fillOval(x,y,15,15);
	}
	public void update(Graphics g) { 
		paint(g);
	} 
	public void run() { 
		Rectangle rec = getBounds();
		for(int i=0; i<num; i++){ 
			x = r.nextInt(rec.width);
			y = r.nextInt(rec.height);
			repaint();
			try { 
				Thread.sleep(100);
			} catch (Exception e) { } 
		}
	}
}

class TestGraphic { 
	public static void main(String[] args){ 
		GraphicThread gt = new GraphicThread(500, Color.red);
		gt.setSize(400,400);
		gt.setVisible(true);
		Thread t = new Thread(gt);
	
		GraphicThread gt2 = new GraphicThread(500, Color.blue);
		gt2.setSize(400,400);
		gt2.setVisible(true);
		Thread t2 = new Thread(gt2); 

		t.start();
		t2.start();
	}
}
