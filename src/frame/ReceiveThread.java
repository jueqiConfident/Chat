package frame;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JTextArea;

public class ReceiveThread extends Thread {
	public Socket socket;  
	public String message;
	private Map<String,Socket>map;
	private JTextArea jTextArea;
	public ReceiveThread(Socket socket,Map<String,Socket>map,JTextArea jTextArea){
	
		this.socket = socket;
		this.map = map;
		this.jTextArea = jTextArea;
		
	}
	
	@Override
	public void run() {
		try {
			int i = 0;
			
			InputStream is = socket.getInputStream();
			while(true){
				byte[] b = new byte[300];
				
				is.read(b);
				if(0 == i){  //如果是第一次登陆注册，那一定是注册一个用户,把所有用户在用户列表显示
					String str = new String(b);
					map.put(str, socket);
					Set<String> set = map.keySet();
					Iterator<String> it = set.iterator();
					for(;it.hasNext();){
						String key = it.next();
						jTextArea.setText(key);
					}
					new SendThread(map,null,str).start();
					i++;
				}
				if(1 <= i){//如果已经登陆注册,那一定是发的消息
					message = new String(b);
					Set<String> set = map.keySet();
					Iterator<String> it = set.iterator();
					for(;it.hasNext();){
						String key = it.next();
						if(socket == map.get(key)){
							new SendThread(map,message,key).start();
						}
					}
				}
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
