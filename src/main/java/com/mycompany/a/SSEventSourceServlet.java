import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.servlets.EventSource;
//import org.eclipse.jetty.servlets.EventSourceServlet;

public class SSEventSourceServlet extends org.eclipse.jetty.servlets.EventSourceServlet
{
    @Override
    protected EventSource newEventSource(HttpServletRequest request)
    {
        EventSource eS = new SSEventSource(); 
        this.EvSourse = eS;
        return eS;
        //return new SSEventSource();
    }

    private EventSource EvSourse;
    public EventSource getEventSource(){
        return this.EvSourse;
    }
}