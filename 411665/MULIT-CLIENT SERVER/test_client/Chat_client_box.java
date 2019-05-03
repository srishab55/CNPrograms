package test_client;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Chat_client_box extends Frame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7087197971727656205L;
	Button b1;
	TextField t1;
	client_test ct;
	public Chat_client_box() {
		setLayout(new FlowLayout());
		b1=new Button("Send Message");
		t1 =new TextField(20);
		add(t1);
		add(b1);
		b1.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				try {
					ct.socket.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					ct.input.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ct.out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.windowClosing(e);
				System.exit(-1);
			}
		});
		try {
			ct=new client_test("", 5000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
			Chat_client_box ct=new Chat_client_box();
			ct.setSize(700,700);
			ct.setTitle("Chat box");
			ct.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		client_test c1=ct;
		String str=t1.getText();
		if(!str.equals("")) {
			try {
				ct.out.writeUTF(str);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			t1.setText("");
		}
	}

}
