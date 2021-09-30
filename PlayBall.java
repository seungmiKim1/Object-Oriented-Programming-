public class PlayBall{
	public static void main (String[] args){
		Ball ball = new Ball();   // 공유자원 농구공 객체
		Player first = new Player (ball, "첫번째", 1); // 첫번째 사람 - 공 이름 백넘버
		Player second = new Player (ball, "두번째", 2);

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
			ball.catching(getName(), back_number); // 초기상태 또는 상대가 공을 슛하고 난 직후
			ball.dribble(getName(), back_number); // 공을 잡는다
			ball.shoot(getName(), back_number); // 공을 슛한다
		}
		else if ( ball.intercepted && ball.ball_owner == back_number ) { // 현재 가로채기 상태
			ball.intercepted = false; // 그사람이 자신이면 상대가 가로채기 가능한 상태로
			ball.catching(getName(), back_number);  // 가로채기한 후 공을 잡다
			ball.dribble(getName(), back_number); // 드리블한다
			ball.shoot(getName(), back_number);  // 슛한다

		}
		else{
			ball.intercept(getName(), back_number); // 상대의 공을 가로채기 한다.
		}
	}
}

class Ball{
	int ball_owner; int c[]; boolean intercepted;
	ball () {ball_owner = 0; c = new int[3]; intercepted = false;}

	synchronized void catching (String name, int no) {
		ball_owner = no;
		System.out.println( no + "번" + name + "선수가 공을 잡았다.");
	}
	synchronized void dribble (String name, int no) {
		if (ball_owner == no)
		System.out.println( no + "번" + name + "선수가 드리블 한다.");
	}
	synchronized void shoot (String name, int no) {
		if (ball_owner == no){
		c[no]++;
		System.out.println( no + "번" + name + "선수가 공을 슛하여 " + c[no] + "점");
		ball_owner = 0;
		}
	}
	synchronized void intercept (String name, int no) {
		ball_owner = no; intercepted = true;
		System.out.println( no + "번" + name + "선수가 공을 가로채기 했다.");
} // Ball 끝