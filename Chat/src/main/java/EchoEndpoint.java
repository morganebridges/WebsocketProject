import javax.websocket.*;
import java.io.IOException;

public class EchoEndpoint extends Endpoint{


    @Override
    public void onOpen(Session session, EndpointConfig config) {
        RemoteEndpoint.Basic remoteEndpointBasic = session.getBasicRemote();
        new EchoMessageHandler(remoteEndpointBasic);
    }

    private static class EchoMessageHandler implements MessageHandler.Whole<String> {

        private final RemoteEndpoint.Basic  remoteEndpointBasic;

        private EchoMessageHandler(RemoteEndpoint.Basic remoteEndpointBasic) {
            this.remoteEndpointBasic = remoteEndpointBasic;
        }

        @Override
        public void onMessage(String message) {
            try{
                if(remoteEndpointBasic != null){
                    remoteEndpointBasic.sendText(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
