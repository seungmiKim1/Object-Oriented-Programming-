class Printer{
	static int num = 0;
	synchronized void printing(String name) {
		System.out.println( name + "�� " + num++  +"��°�� ����Ʈ ���");
	}
}

class PC extends Thread {
	Printer sp;
	PC(Printer p, String name) {
		super(name);
		sp = p;
	}
	public void run() {
		for (int i = 0; i < 3; i++)
			sp.printing(getName());
	
	}
}

public class SyncPCThread {
	public static void main(String[] args){
		Printer printer = new Printer();
		PC c1 = new PC(printer, "ù��° ��ǻ��");
		PC c2 = new PC(printer, "�ι�° ��ǻ��");
		PC c3 = new PC(printer, "����° ��ǻ��");

		c1.start();
		c2.start();
		c3.start();
	}
}