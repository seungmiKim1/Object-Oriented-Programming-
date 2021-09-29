class RunnableThread implements Runnable { 
	public void run() { 
		System.out.println("Runnable 쓰레드 실행중입니다");
	}
} 

public class TestRunnableThread { 
	public static void main(String[] args) { 
		RunnableThread r = new RunnableThread(); // 1번째 객체 생성 (r) 
		Thread t = new Thread(r); //2번째 객체 생성. 최종 일하는 쓰레드 객체는 t가 된다. 	
		System.out.println("쓰레드 시작 전");
		t.start();
		System.out.println("쓰레드 시작 후");
	}
}
