package test.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("info===========");
        PrintWriter out = response.getWriter();
		String info = request.getParameter("name");
		System.out.println("info=="+info);
		out.write("hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("application/json; charset=utf-8");
		//允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		System.out.println("进入POST方法");
		String username=null;
		String password=null;
		String json=null;  
		PrintWriter out = response.getWriter();
		
		
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		           
		System.out.println("username===="+username);
		System.out.println("password===="+password);
		
		if((username.equals("LiMing") && password.equals("12345")) || (username.equals("Mike") && password.equals("12345")) || (username.equals("Lily") && password.equals("123")) ){
			System.out.println("Yes");
			json="{\"result\":\"yes\"}"; 
			out.write(json);
		}else{
			System.out.println("No");
			json="{\"result\":\"no\"}";
			out.write(json);
		}
		
	}

}
