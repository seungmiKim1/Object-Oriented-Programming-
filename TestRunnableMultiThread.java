class RunnableThread implements Runnable { 
	String name; 
	RunnableThread(String s){ 
		name = s;
	}
	public void run() { 
		for(int i=0; i<5; i++)
			System.out.println(name+"실행중");
	}
}

public class TestRunnableMultiThread { 
	public static void main(String[] args){
		RunnableThread r = new RunnableThread("첫번째 쓰레드");
		Thread t = new Thread(r);
		RunnableThread r2 = new RunnableThread("두번째 쓰레드");
		Thread t2 = new Thread(r2);
		System.out.println("쓰레드 시작 전");
		t.start();
		t2.start();
		System.out.println("쓰레드 시작 후");
	}
}
