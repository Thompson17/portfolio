package de.hsos.vs.chess.chessgame.servlet.util;

import de.hsos.vs.chess.chessgame.rmi.api.IClientProxy;
import de.hsos.vs.chess.chessgame.rmi.api.IGameProxy;
import jakarta.websocket.Session;

/**
 * Stores WebSocket session data and associated RMI proxies.
 */
public class SessionData {

    /**
     * The Session.
     */
    private Session session;
    /**
     * The Client proxy.
     */
    private IClientProxy clientProxy;
    /**
     * The Game proxy.
     */
    private IGameProxy gameProxy;

    /**
     * Instantiates a new Session data.
     *
     * @param session the session
     */
    public SessionData(Session session) {
        this.session = session;
    }

    /**
     * Gets session.
     *
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /**
     * Sets session.
     *
     * @param session the session
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * Gets client proxy.
     *
     * @return the client proxy
     */
    public IClientProxy getClientProxy() {
        return clientProxy;
    }

    /**
     * Sets client proxy.
     *
     * @param clientProxy the client proxy
     */
    public void setClientProxy(IClientProxy clientProxy) {
        this.clientProxy = clientProxy;
    }

    /**
     * Gets game proxy.
     *
     * @return the game proxy
     */
    public IGameProxy getGameProxy() {
        return gameProxy;
    }

    /**
     * Sets game proxy.
     *
     * @param gameProxy the game proxy
     */
    public void setGameProxy(IGameProxy gameProxy) {
        this.gameProxy = gameProxy;
    }
}
