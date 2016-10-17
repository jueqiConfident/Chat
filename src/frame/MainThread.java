package frame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainThread extends Thread{
	private ServerFrame frame;
	public MainThread(ServerFrame frame){
		this.frame = frame;
	}
	@Override
	public void run() {
		int port = Integer.parseInt(frame.jTextField.getText());
		try {
			ServerSocket ss = new ServerSocket(port);
			while(true){
				Socket socket = ss.accept();
				new ReceiveThread(socket,frame.map,frame.jTextArea).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
