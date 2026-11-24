package de.hsos.vs.chess.chessgame.servlet.api;

import jakarta.websocket.Session;

/**
 * Receives events forwarded by the web client proxy.
 */
public interface WebClientProxyListener {
    /**
     * On receive move.
     *
     * @param session  the session
     * @param startRow the start row
     * @param startCol the start col
     * @param endRow   the end row
     * @param endCol   the end col
     */
    public void onReceiveMove(Session session, int startRow, int startCol, int endRow, int endCol);

    /**
     * On start.
     *
     * @param session      the session
     * @param opponentName the opponent name
     * @param white        the white
     */
    public void onStart(Session session, String opponentName, boolean white);

    /**
     * On end.
     *
     * @param session    the session
     * @param gameStatus the game status
     */
    public void onEnd(Session session, String gameStatus);
}
