package test.web.socket;
//https://www.cnblogs.com/xdp-gacl/p/5193279.html
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocket {
 
	//用来记录有多少人建立了连接
	private static int numId = 0;
	//用来存储用户连接数据
	private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();
	//与客户端的链接回话
	private Session session;
	private String  username;
	@OnMessage
	public void onMessage(String message,Session session) throws IOException, InterruptedException{
		
		//这些数据需要写入数据库
		System.out.println("浏览器:"+message);
		
		for(WebSocket item: webSocketSet){
			item.session.getBasicRemote().sendText(message);
		}
		
		//session.getBasicRemote().sendText(message);
			
		
	}
	@OnOpen
	public void onOpen(Session session){
		
		//获取当前用户名
		//this.username = 
		//获取当前链接用户
		this.session = session;
		//将当前用户添加到集合中
		webSocketSet.add(this);
		//人数加一
		numId++;
		
		System.out.println("Client connected");
		//用来记录有多少人建立连接
		
		System.out.println("当前在线人数为"+numId);
	}
	
	
	@OnClose
	public void onClose(){
		//从集合中移除
		webSocketSet.remove(this);
		//在线人数减一
		numId--;
		System.out.println("Connection closed");
		
		System.out.println("有一个人下线，当前人数是"+numId);
	}
	
}
