import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.HashSet;
import java.util.Set;

public class EchoEndpointConfiguration implements ServerApplicationConfig{


    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
        Set<ServerEndpointConfig> result = new HashSet<>();
        if(set.contains(EchoEndpoint.class)){
            result.add(ServerEndpointConfig.Builder.create(
                    EchoEndpoint.class,
                    "websocket/echo").build());

        }
        return result;
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
        return null;
    }
}
