package frame;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SendThread extends Thread{
	
	private Map<String,Socket>map;
	private String message;
	private String name;
	public SendThread(Map<String,Socket>map,String message,String name){
		this.map = map;
		this.message = message;
		this.name = name;
	}
	
	@Override
	public void run() {
		Set <String>set = map.keySet();
		Iterator<String>it = set.iterator();
		for(;it.hasNext();){
			String key = it.next();
			Socket so = map.get(key);
			try {
				OutputStream os = so.getOutputStream();
				if(null == message){
					for(Iterator<String>ite = set.iterator();ite.hasNext();){
						os.write(ite.next().getBytes());
					}
				}
				if(null != message){
//					os.write(("1"+message).getBytes());
				    
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
