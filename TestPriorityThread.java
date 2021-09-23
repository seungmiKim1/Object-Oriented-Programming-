// 우선순위 갖는 멀티쓰레드  

class PriorityThread extends Thread { 
	public PriorityThread (String name) { 
		super(name);
	}
	public void run() { 
		for (int i=0; i<5; i++) 
			System.out.println(getName()+":"+i+"번째");
	}
}
public class TestPriorityThread { 
	public static void main(String[] args){ 
		PriorityThread p1 = new PriorityThread("우선순위가 제일 높은 쓰레드");
		PriorityThread p2 = new PriorityThread("우선순위가 중간인 쓰레드");
		PriorityThread p3 = new PriorityThread("우선순위가 제일 낮은 쓰레드"); 
		p1.setPriority(p1.MAX_PRIORITY); 
		p2.setPriority(p2.NORM_PRIORITY);
		p3.setPriority(p3.MIN_PRIORITY); 
		p1.start();
		p2.start();
		p3.start(); 
	} 
}
