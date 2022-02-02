import java.io.IOException;
import java.util.Date;
 
public class SSEventSource implements org.eclipse.jetty.servlets.EventSource
{
    private Emitter emitter;

    public void onOpen(Emitter emitter) throws IOException
    {
        this.emitter = emitter;
        emitter.data("new server event " + new Date().toString());
 
    }

    public void emitEvent(String dataToSend)
    {
        this.emitter.data(dataToSend);
    }

    public void onClose()
    {
    }
}