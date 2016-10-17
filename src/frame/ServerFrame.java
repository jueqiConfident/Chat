package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ServerFrame extends JFrame{
	
	public ServerFrame(String name) {
		super(name);
		this.createFrame();
		map = new HashMap<String,Socket>();
	}
	Map<String,Socket> map;

	public ServerSocket ss;
	public Socket socket;
	
	
	private String serverKey = "启动服务器";//button1 文本
	private String serverStatus = "停止"; //jLabel2文本
	
	private JPanel jPanel1;//服务器界面
	private JPanel jPanel2;//在线用户列表
	
	private JLabel jLabel1;//服务器状态
	private JLabel jLabel2;//停止，运行
	private JLabel jLabel3;//端口号
	
	private JButton jButton1;//启动/停止服务器
	
	private JScrollPane jScrollPane;
	
	JTextField jTextField;//端口号文本框
	 JTextArea jTextArea;//用户列表文本框
	
	public void createFrame(){
		
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		
		jLabel1 = new JLabel("服务器状态");
		jLabel2 = new JLabel(serverStatus);
		jLabel2.setForeground(new Color(201, 2, 4));
		jLabel3 = new JLabel("端口号");
		
		jButton1 = new JButton(serverKey);//按键的字是会改变的，所以用一个变量
		jButton1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if("启动服务器".equals(serverKey)){
					serverKey = "停止服务器";
					serverStatus = "运行";
					
				}
				else{
					serverKey = "启动服务器";
					serverStatus = "停止";
				}
				jLabel2.setText(serverStatus);
				jButton1.setText(serverKey);
				
				new MainThread(ServerFrame.this).start();
				
			
			}
			
		});
		
		jScrollPane = new JScrollPane();
		
		jTextField = new JTextField(10);//文本框的长度
		jTextField.setText("5000");
		jTextArea = new JTextArea();
		jTextArea.setEditable(false);//文本框不可以编辑
		jTextArea.setForeground(new Color(245,0,0));//文本的颜色
		jTextArea.setRows(20);//文本框行
		jTextArea.setColumns(30);//文本框列
		jScrollPane.setViewportView(jTextArea);//将文本框设置滚动条（将jTextArea放到jScrollPane里）
		
		jPanel1.setBorder(BorderFactory.createTitledBorder("服务器信息"));//设置面板标签
		jPanel1.add(jLabel1);
		jPanel1.add(jLabel2);
		jPanel1.add(jLabel3);
		jPanel1.add(jTextField);
		jPanel1.add(jButton1);
		
		jPanel2.setBorder(BorderFactory.createTitledBorder("在线用户列表"));//设置面板标签
		jPanel2.add(jScrollPane);
		
		this.getContentPane().add(jPanel1, BorderLayout.NORTH); //把jPanel1设置在北边
		this.getContentPane().add(jPanel2, BorderLayout.SOUTH);//把jPanel2设置在南边 
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);//窗口设置在最前面
		this.setResizable(false);//不可娈窗口尺寸
		this.pack();//正好大小
		this.setVisible(true);
	}
	

	
//	public void receiveSend() throws Exception{
//		ss = new ServerSocket(Integer.parseInt(jTextField.getText()));
//		while(true){
//			
//			new ReceiveThread(ss,map).start();
//		}
//		
//		
///*		while(true){
//			socket = ss.accept();
//			InputStream is = socket.getInputStream();
//			byte [] b = new byte[200];
//			int length = 0 ;
//			int i = 0 ;//记数传了多少个
//			while(-1 != (length = is.read(b, 0, b.length))){
//				
//				String str = new String(b,0,length);
//				if(i == 0){
//					xml.clientName.setText(str);
//				}
//				if(i == 1){
//					xml.message.setText(str);
//				}
//				if(i >= 2){
//					xml.IP.setText(str);
//				}
//				i++;
//			} 
//			System.out.println("savexml");
//			xml.saveXML("serverXML.xml");
//			
//		}
//		*/
//		
//	}
	
	public static void main(String[] args) throws Exception {
		 new ServerFrame("服务器");
		
	}
}



















