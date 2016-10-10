package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ClientFrame extends JFrame {
	public ClientFrame(String name){
		super(name);
		this.createClientFrame();
	}

	private JPanel jPanel1;
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	
	private JButton jButton1;
	private JButton jButton2;
 
	public void createClientFrame(){
		jLabel1 = new JLabel("用户名");
		jLabel2 = new JLabel("服务器");
		jLabel3 = new JLabel("端口号");
		
		jTextField1 = new JTextField(10);
		jTextField2 = new JTextField(10);
		jTextField3 = new JTextField(10);
		
		jButton1 = new JButton("登陆");
		jButton1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new ChatPanel("聊天室");
				
			}
			
		});
		jButton2 = new JButton("重置");
		
		jPanel1 = new JPanel();
		
		jPanel1.setBorder(BorderFactory.createTitledBorder("用户登陆"));
		
		jPanel1.add(jLabel1);
		jPanel1.add(jTextField1);
		jPanel1.add(jLabel2);
		jPanel1.add(jTextField2);
		jPanel1.add(jLabel3);
		jPanel1.add(jTextField3);
		jPanel1.add(jButton1);
		jPanel1.add(jButton2);
		
		this.getContentPane().add(jPanel1);
		
		this.setAlwaysOnTop(true);//窗口设置在最前面
		this.setResizable(false);//不可娈窗口尺寸
		this.setSize(200, 260);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ClientFrame("用户登陆");
	}
}
