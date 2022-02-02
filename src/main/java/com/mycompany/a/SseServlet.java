import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class SseServlet extends HttpServlet
{
    private String greeting="Hello World from servlet";
    public SseServlet(){}
    public SseServlet(String greeting)
    {
        this.greeting=greeting;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>"+sse greeting+"</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());
    }
}