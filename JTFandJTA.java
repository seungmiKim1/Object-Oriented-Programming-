import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JTFandJTA extends JFrame implements ActionListener {
	
	private JTextField jtf;
	private JTextArea jta;
	
	public JTFandJTA() { 
		jtf = new JTextField(20);
		jta = new JTextArea(7,20);
		jtf.addActionListener(this);
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		ct.add(jtf);
		ct.add(jta);
	}
	
	public void actionPerformed(ActionEvent ae) {
		jta.append(ae.getActionCommand()+"\n");
		jtf.setText("");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTFandJTA jj = new JTFandJTA();
		jj.setTitle("JTextField,JTextArea Test");
		jj.setSize(500,200);
		jj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jj.setVisible(true);
	}


}
