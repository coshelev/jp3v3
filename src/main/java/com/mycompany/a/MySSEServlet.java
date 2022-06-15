import java.io.IOException;
import java.util.Date;
 
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
 
import org.eclipse.jetty.servlets.EventSource;
import org.eclipse.jetty.servlets.EventSourceServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
 
//@WebServlet(urlPatterns = "/talk", initParams = { @WebInitParam(name = "heartBeatPeriod", value = "5") }, asyncSupported = true)
public class MySSEServlet extends EventSourceServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //response.setContentType("text/html");
        //response.setStatus(HttpServletResponse.SC_OK);

        //content type must be set to text/event-stream
        //---------------------------------------------
        response.setContentType("text/event-stream");

        //encoding must be set to UTF-8
        //------------------------------
        response.setCharacterEncoding("UTF-8");

        response.getWriter().println("<html><h1>talk</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());

        response.getWriter().println("<body><script>var eventSource = new EventSource(\"/talk\"); eventSource.onmessage = function(event){console.log(event.data)};</script></body></html>");

        EventSource ev = new EventSource() {
 
            

            @Override
            public void onOpen(final Emitter emitter) throws IOException {
                emitter.data("new server event " + new Date().toString());
                while (true) {
                    System.out.println("propagating event..");
                    try {
                        Thread.sleep(5000);
                        emitter.data("new server event " + new Date().toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }   
                }
            }
 
            @Override
            public void onClose() {
                System.out.println("closed");
            }
        };
        
    }

    @Override
    protected EventSource newEventSource(final HttpServletRequest req) {
        return new EventSource() {
 
            

            @Override
            public void onOpen(final Emitter emitter) throws IOException {
                emitter.data("new server event " + new Date().toString());
                while (true) {
                    System.out.println("propagating event..");
                    try {
                        Thread.sleep(5000);
                        emitter.data("new server event " + new Date().toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }   
                }
            }
 
            @Override
            public void onClose() {
                System.out.println("closed");
            }
        };
    }
}