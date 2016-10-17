package client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLClientDoc {
	public XMLClientDoc(){
		createDocument();
	}
	public XMLClientDoc(String path){
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
	public Element element1;//用户名
	public Element element2;//服务器IP
	public Element element3;//端口号（port）
	
	void createDocument() {
		root = DocumentHelper.createElement("chatMessage");
		document = DocumentHelper.createDocument(root);
		element1 = root.addElement("用户名");
		element2 = root.addElement("服务器");
		element3 = root.addElement("端口号");
		
		
	}
	void saveXML(String path) throws Exception, FileNotFoundException{
		XMLWriter writer = new XMLWriter(new FileOutputStream(path),new OutputFormat("    ",true));
		writer.write(document);
	}
}
