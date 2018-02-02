package test.web.socket;
//https://www.cnblogs.com/xdp-gacl/p/5193279.html
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocket {
 
	//������¼�ж����˽���������
	private static int numId = 0;
	//�����洢�û���������
	private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();
	//��ͻ��˵����ӻػ�
	private Session session;
	private String  username;
	@OnMessage
	public void onMessage(String message,Session session) throws IOException, InterruptedException{
		
		//��Щ������Ҫд�����ݿ�
		System.out.println("�����:"+message);
		
		for(WebSocket item: webSocketSet){
			item.session.getBasicRemote().sendText(message);
		}
		
		//session.getBasicRemote().sendText(message);
			
		
	}
	@OnOpen
	public void onOpen(Session session){
		
		//��ȡ��ǰ�û���
		//this.username = 
		//��ȡ��ǰ�����û�
		this.session = session;
		//����ǰ�û���ӵ�������
		webSocketSet.add(this);
		//������һ
		numId++;
		
		System.out.println("Client connected");
		//������¼�ж����˽�������
		
		System.out.println("��ǰ��������Ϊ"+numId);
	}
	
	
	@OnClose
	public void onClose(){
		//�Ӽ������Ƴ�
		webSocketSet.remove(this);
		//����������һ
		numId--;
		System.out.println("Connection closed");
		
		System.out.println("��һ�������ߣ���ǰ������"+numId);
	}
	
}
