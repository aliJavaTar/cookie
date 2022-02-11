package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/counter")
public class CookieCounter extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int counter = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("counter")) {
                    Cookie c = cookies[i];
                    counter = Integer.parseInt(c.getValue());
                    break;
                }
            }
        }
        counter++;
        Cookie cookie = new Cookie("counter", String.valueOf(counter));
        response.addCookie(cookie);
        response.getWriter().println("<h1>it is your " + counter + " visit</h1>");
    }
}
