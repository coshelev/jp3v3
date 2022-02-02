import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.servlets.EventSource;
//import org.eclipse.jetty.servlets.EventSourceServlet;

public class SSEventSourceServlet extends org.eclipse.jetty.servlets.EventSourceServlet
{
    @Override
    protected EventSource newEventSource(HttpServletRequest request)
    {
        return new SSEventSource();
    }
}