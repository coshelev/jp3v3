import javax.servlet.http.HttpServletRequest;

public class SSEventSourceServlet extends org.eclipse.jetty.servlets.EventSourceServlet
{
    @Override
    protected EventSource newEventSource(HttpServletRequest request)
    {
        return new SSEventSource();
    }
}