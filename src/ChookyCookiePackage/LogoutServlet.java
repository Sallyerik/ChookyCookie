package ChookyCookiePackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	
    	String User = null;
    	Cookie[] Usercookies = request.getCookies();
    	for(Cookie cookie : Usercookies){
		if(cookie.getName().equals("user")) User = cookie.getValue();
    	}	
		String RemoveEntryUS = ChookyCookie.RemovehashmaUSpentry(User);
		String RemoveEntry = ChookyCookie.Removehashmapentry(User);
		System.out.println("LOGOUT State Delete: "+ RemoveEntryUS);
		System.out.println("LOGOUT Cookie Delete: "+ RemoveEntry);
    	
    	Cookie loginCookie = null;
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("user")){
    			loginCookie = cookie;
    			break;
    		}
    	}
    	}
    	if(loginCookie != null){
    		loginCookie.setMaxAge(0);
        	response.addCookie(loginCookie);
    	}
    	response.sendRedirect("login.html");
    }

}