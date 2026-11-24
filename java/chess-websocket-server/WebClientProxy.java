package de.hsos.vs.chess.chessgame.rmi.client;

import de.hsos.vs.chess.chessgame.rmi.api.IClientProxy;
import de.hsos.vs.chess.chessgame.servlet.api.WebClientProxyListener;
import jakarta.websocket.Session;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Receives remote game server callbacks and forwards them to the web server.
 */
public class WebClientProxy extends UnicastRemoteObject implements IClientProxy {
    /**
     * The associated WebSocket session.
     */
    private final Session session;
    /**
     * The listener receiving game events.
     */
    private volatile WebClientProxyListener listener;

    /**
     * Instantiates a new Web client proxy.
     *
     * @param session the session
     * @throws RemoteException the remote exception
     */
    public WebClientProxy(Session session) throws RemoteException {
        super();
        this.session = session;
    }

    @Override
    public void startGame(String opponentName, boolean white) throws RemoteException {
        WebClientProxyListener currentListener = listener;
        if (currentListener != null) {
            currentListener.onStart(session, opponentName, white);
        }
    }

    @Override
    public void sendGameStatus(String gameStatus) throws RemoteException {
        WebClientProxyListener currentListener = listener;
        if (currentListener != null) {
            currentListener.onEnd(session, gameStatus);
        }
    }

    @Override
    public void receiveMove(int startRow, int startCol, int endRow, int endCol) throws RemoteException {
        WebClientProxyListener currentListener = listener;
        if (currentListener != null) {
            currentListener.onReceiveMove(session, startRow, startCol, endRow, endCol);
        }
    }

    /**
     * Sets listener.
     *
     * @param listener the listener
     */
    public void setListener(WebClientProxyListener listener) {
        this.listener = listener;
    }

    /**
     * Removes listener.
     */
    public void removeListener() {
        this.listener = null;
    }
}
