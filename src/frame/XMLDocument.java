package frame;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLDocument {
	public XMLDocument(){
		createDocument();
	}
	public XMLDocument(String path){
		createDocument();
		try {
			saveXML(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Document document; 
	public Element root;
	public Element clientName;//用户名
	public Element message;//消息
	public Element IP;//IP
	public Element element3;//用户列表
	
	void createDocument() {
		root = DocumentHelper.createElement("chatMessage");
		document = DocumentHelper.createDocument(root);
		clientName = root.addElement("用户名");
		message = root.addElement("消息");
		IP = root.addElement("IP");
		element3 = root.addElement("用户列表");
		
		
	}
	void saveXML(String path) throws Exception, FileNotFoundException{
		XMLWriter writer = new XMLWriter(new FileOutputStream(path),new OutputFormat("    ",true));
		writer.write(document);
	}
	
	
}
