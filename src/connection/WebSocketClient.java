package connection;

import java.io.IOException;
import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

// ClientEndPoint: manages everything related to requesting or receiving information from the socket.
@ClientEndpoint
public class WebSocketClient {

    private Session userSession = null;
    private MessageHandler messageHandler;

    public WebSocketClient(URI uri) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, uri);
        } catch (IOException | DeploymentException e) {
            throw new RuntimeException(e);
        }
    }

    // onOpen: enable the user session to be active.
    @OnOpen
    public void onOpen(Session userSession) {
        System.out.println("Opening websocket:");
        this.userSession = userSession;
    }

    // onClose: is responsible of unlinking the app with the socket for some reason that demands it.
    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        System.out.println("Closing websocket:");
        this.userSession = null;
    }

    @OnMessage
    public void onMessage(String message) {
        if (this.messageHandler != null) {
            this.messageHandler.handleMessage(message);
        }
    }

    public void addMessageHandler(MessageHandler msgHandler) {
        this.messageHandler = msgHandler;
    }

    public void sendMessage(String message) {
        this.userSession.getAsyncRemote().sendText(message);
    }

    public static interface MessageHandler {
        public void handleMessage(String message);
    }
}