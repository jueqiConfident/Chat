package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import javax.swing.JTextArea;

public class ClientInputThread extends Thread{
	private Socket so;
	private JTextArea jTextArea1;
	private JTextArea jTextArea2;
	
	public ClientInputThread(Socket so,JTextArea jTextArea1,JTextArea jTextArea2){
		this.so = so;
		this.jTextArea1 = jTextArea1;
		this.jTextArea2 = jTextArea2;
	}
	@Override
	public void run() {
		try {
			InputStream is = so.getInputStream();
			while(true){
				byte [] b = new byte[200];
				is.read(b);
				String str = new String(b);
				if("1" .equals(str.substring(0, 1)) ){
					jTextArea1.setText(str);
				}
				else{
					jTextArea2.setText(str);
					
				}
					
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
