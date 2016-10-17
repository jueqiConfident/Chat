package client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ChatPanel extends JFrame{
	
	public ChatPanel(Socket so){
		super("聊天室");
		this.so = so;
		this.createChatPanel();
		
	}
	private Socket so;
	private JPanel jPanel1;//chat panel
	private JPanel jPanel2;//client panel
	private JPanel jPanel3;//send panel
	
	public JTextArea jTextArea1;//聊天消息
	private JTextArea jTextArea2;//用户列表
	
	private JTextField jTextField;//消息编辑
	
	private JButton jButton1;//send
	private JButton jButton2;//clear
	
	
	
	
	public void createChatPanel(){
		jTextArea1 = new JTextArea();
		jTextArea1.setRows(20);
		jTextArea1.setColumns(50);
		jTextArea1.setEditable(false);//文本框不可以编辑
		
		jTextArea2 = new JTextArea();
		jTextArea2.setRows(25);
		jTextArea2.setColumns(10);
		jTextArea2.setEditable(false);//文本框不可以编辑
		
		jTextField = new JTextField(30);
		
		jButton1 = new JButton("发送");
		jButton1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new ClientOutputThread(so,jTextField.getText()).start();
			}
			
		});
		jButton2 = new JButton("清屏");
		
		jPanel3 = new JPanel();
		jPanel3.add(jTextField);
		jPanel3.add(jButton1);
		jPanel3.add(jButton2);
		
		jPanel1 = new JPanel();
		jPanel1.setBorder(BorderFactory.createTitledBorder("聊天室信息"));
		jPanel1.setLayout(new BorderLayout());
		jPanel1.add(jTextArea1,BorderLayout.CENTER);
		jPanel1.add(jPanel3, BorderLayout.SOUTH);
		
		jPanel2 = new JPanel();
		jPanel2.setBorder(BorderFactory.createTitledBorder("在线用户列表"));
		jPanel2.add(jTextArea2);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.add(jPanel1,BorderLayout.WEST);
		this.add(jPanel2,BorderLayout.EAST);
//		this.add(jPanel3,BorderLayout.SOUTH);
		
		this.setAlwaysOnTop(true);//窗口设置在最前面
		this.setResizable(false);//不可娈窗口尺寸
		this.pack();//正好大小
		this.setVisible(true);
		
	}
}


















