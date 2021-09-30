public class PlayBall{
	public static void main (String[] args){
		Ball ball = new Ball();   // �����ڿ� �󱸰� ��ü
		Player first = new Player (ball, "ù��°", 1); // ù��° ��� - �� �̸� ��ѹ�
		Player second = new Player (ball, "�ι�°", 2);

		first.start(); second.start();
	}
}


class Player extends Thread {
	Ball ball; int back_number;

	public Player(Ball b, String name, int no){
		super(name);	
		back number = no;
		ball = b;
	}
}


public void run() {
	for ( int i = 1 ; i <= 10; i++ ) {
		if(ball.ball_owner == 0 ){
			ball.catching(getName(), back_number); // �ʱ���� �Ǵ� ��밡 ���� ���ϰ� �� ����
			ball.dribble(getName(), back_number); // ���� ��´�
			ball.shoot(getName(), back_number); // ���� ���Ѵ�
		}
		else if ( ball.intercepted && ball.ball_owner == back_number ) { // ���� ����ä�� ����
			ball.intercepted = false; // �׻���� �ڽ��̸� ��밡 ����ä�� ������ ���·�
			ball.catching(getName(), back_number);  // ����ä���� �� ���� ���
			ball.dribble(getName(), back_number); // �帮���Ѵ�
			ball.shoot(getName(), back_number);  // ���Ѵ�

		}
		else{
			ball.intercept(getName(), back_number); // ����� ���� ����ä�� �Ѵ�.
		}
	}
}

class Ball{
	int ball_owner; int c[]; boolean intercepted;
	ball () {ball_owner = 0; c = new int[3]; intercepted = false;}

	synchronized void catching (String name, int no) {
		ball_owner = no;
		System.out.println( no + "��" + name + "������ ���� ��Ҵ�.");
	}
	synchronized void dribble (String name, int no) {
		if (ball_owner == no)
		System.out.println( no + "��" + name + "������ �帮�� �Ѵ�.");
	}
	synchronized void shoot (String name, int no) {
		if (ball_owner == no){
		c[no]++;
		System.out.println( no + "��" + name + "������ ���� ���Ͽ� " + c[no] + "��");
		ball_owner = 0;
		}
	}
	synchronized void intercept (String name, int no) {
		ball_owner = no; intercepted = true;
		System.out.println( no + "��" + name + "������ ���� ����ä�� �ߴ�.");
} // Ball ��