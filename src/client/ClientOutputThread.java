package client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientOutputThread extends Thread{
	private Socket so;
	private String message;
	
	public ClientOutputThread(Socket so,String message){
		this.so = so;
		this.message = message;
		
	}
	@Override
	public void run() {
		try {
			OutputStream os = so.getOutputStream();
				
				os.write(message.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
