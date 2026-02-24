package de.hsos.vs.chess.chessgame.servlet;

import de.hsos.vs.chess.chessgame.rmi.api.IUserServer;
import de.hsos.vs.chess.chessgame.rmi.client.WebClientProxy;
import de.hsos.vs.chess.chessgame.servlet.util.SessionData;
import de.hsos.vs.chess.chessgame.servlet.api.WebClientProxyListener;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 * Server Endpoint of the webserver. Receives, processes and forwards messages between web clients and the game server.
 */
@ServerEndpoint("/game")
public class GameServlet implements WebClientProxyListener {

    /**
     * The constant sessions.
     */
    private static final Map<String, SessionData> sessions = new HashMap<>();
    /**
     * The constant userServer.
     */
    private static IUserServer userServer;

    /**
     * On open.
     * Gets Called when a web client opens the website.
     *
     * @param session the session
     */
    @OnOpen
    public void onOpen(Session session) {
        if (userServer == null) {
            try {
                System.out.println("connecting RMI...");
                userServer = (IUserServer) Naming.lookup("rmi://localhost:1098/UserServer");
            } catch (NotBoundException | MalformedURLException | RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        String id = session.getId();
        sessions.put(id, new SessionData(session));
        System.out.println("Connected Session: " + id);
    }

    /**
     * On message.
     * Gets called when a web client sends a message through a socket.
     *
     * @param message the message
     * @param session the session
     * @throws RemoteException the remote exception
     */
    @OnMessage
    public void onMessage(String message, Session session) throws RemoteException {
        String callerID = session.getId();
        if (!sessions.containsKey(callerID)) {
            System.out.println("message from unknown ID: " + callerID);
            return;
        }
        System.out.println("message from: " + callerID);
        SessionData sessionData = sessions.get(session.getId());
        JSONObject jsonData = new JSONObject(message);
        String type = jsonData.getString("type");
        switch (type) {
            case "login":
                handleLoginRegister(sessionData, jsonData, false);
                break;
            case "register":
                handleLoginRegister(sessionData, jsonData, true);
                break;
            case "logout":
                handleLogout(jsonData);
                break;
            case "matchmaking":
                handleMatchmaking(sessionData, jsonData);
                break;
            case "move":
                handleMove(sessionData, jsonData);
                break;
            case "resignation":
                handleResignation(sessionData, jsonData);
                break;
            default:
                System.err.println("Unknown method");
                break;
        }
    }

    /**
     * On close.
     * Get called when a web socket is closed.
     *
     * @param session the session
     */
    @OnClose
    public void onClose(Session session) {
        String id = session.getId();
        SessionData sessionData = sessions.get(id);
        if(sessionData != null){
            try {
                sessionData.getGameProxy().resignation();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                sessions.remove(id);
                System.out.println("Disconnected Session: " + id);
            }
        }
    }

    /**
     * On error.
     * Gets called when an error occurs between a web client and the web server
     *
     * @param e the e
     */
    @OnError
    public void onError(Throwable e) {
        System.err.println(e.getMessage());
    }

    /**
     * Handles login and register requests.
     * Creates WebClientProxy, sends it to the user server and receives a GameServerProxy
     *
     * @param sessionData the session data
     * @param jsonData    the json data
     * @param register    true if register, false if login
     * @throws RemoteException the remote exception
     */
    private void handleLoginRegister(SessionData sessionData, JSONObject jsonData, boolean register) throws RemoteException {
        String username = jsonData.getString("username");
        String hash = jsonData.getString("hash");
        String log = "message: ";
        if (register){
            log += " register: ";
        } else {
            log += "login: ";
        }
        log += username;
        System.out.println(log);
        WebClientProxy clientProxy = new WebClientProxy(sessionData.getSession());
        sessionData.setClientProxy(clientProxy);
        clientProxy.setListener(this);
        if (register){
            sessionData.setGameProxy(userServer.register(username, hash, clientProxy));
        } else {
            sessionData.setGameProxy(userServer.login(username, hash, clientProxy));
        }
        loginRegistrationResponse(sessionData, register);
    }

    /**
     * Handle logout.
     *
     * @param jsonData the json data
     * @throws RemoteException the remote exception
     */
    private void handleLogout(JSONObject jsonData) throws RemoteException {
        String username = jsonData.getString("username");
        String hash = jsonData.getString("hash");
        System.out.println("message: logout: " + username);
        userServer.logout(username, hash);
    }

    /**
     * Handle matchmaking. Requests the game server to add or remove GameProxy from the wait list
     *
     * @param sessionData the session data
     * @param jsonData    the json data
     * @throws RemoteException the remote exception
     */
    private void handleMatchmaking(SessionData sessionData, JSONObject jsonData) throws RemoteException {
        boolean waiting = jsonData.getBoolean("waiting");
        System.out.println("message: matchmaking: " + waiting);
        if (waiting) {
            sessionData.getGameProxy().enterMatchmaking();
        } else {
            sessionData.getGameProxy().exitMatchmaking();
        }
    }

    /**
     * Handle move. Sends move info to game server and calls moveResponse with the response.
     *
     * @param sessionData the session data
     * @param jsonData    the json data
     * @throws RemoteException the remote exception
     */
    private void handleMove(SessionData sessionData, JSONObject jsonData) throws RemoteException {
        int startRow = jsonData.getInt("startRow");
        int startCol = jsonData.getInt("startCol");
        int endRow = jsonData.getInt("endRow");
        int endCol = jsonData.getInt("endCol");
        System.out.println("message: move: startRow: " + startRow + ", startCol: " + startCol + ", endRow: " + endRow + ", endCol: " + endCol);
        boolean allowed = sessionData.getGameProxy().move(startRow, startCol, endRow, endCol);
        moveResponse(sessionData, allowed, startRow, startCol, endRow, endCol);
    }

    /**
     * Handle resignation.
     *
     * @param sessionData the session data
     * @param jsonData    the json data
     * @throws RemoteException the remote exception
     */
    private void handleResignation(SessionData sessionData, JSONObject jsonData) throws RemoteException {
        System.out.println("message: resgination by: " + jsonData.getString("username"));
        sessionData.getGameProxy().resignation();
    }

    /**
     * Login registration response.
     *
     * @param sessionData the session data
     * @param register    the register
     */
    private void loginRegistrationResponse(SessionData sessionData, boolean register) {
        boolean success = sessionData.getGameProxy() != null;
        JSONObject response = new JSONObject();
        if (register) {
            response.put("type", "register");
        } else {
            response.put("type", "login");
        }
        response.put("success", success);
        send(sessionData.getSession(), response.toString());
    }

    /**
     * Move response.
     *
     * @param sessionData the session data
     * @param allowed     whether move was allowed
     * @param startRow    the start row
     * @param startCol    the start col
     * @param endRow      the end row
     * @param endCol      the end col
     * @throws RemoteException the remote exception
     */
    private void moveResponse(SessionData sessionData, boolean allowed, int startRow, int startCol, int endRow,
                              int endCol) throws RemoteException {
        JSONObject response = new JSONObject();
        response.put("type", "move").put("allowed", allowed);
        if (allowed) {
            response.put("startRow", startRow).put("startCol", startCol).put("endRow", endRow).put("endCol", endCol);
        }
        send(sessionData.getSession(), response.toString());
        if (allowed){
            checkGameStatus(sessionData);
        }
    }

    @Override
    public void onReceiveMove(Session session, int startRow, int startCol, int endRow, int endCol) {
        JSONObject response = new JSONObject();
        response.put("type", "move").put("allowed", true).put("startRow", startRow).put("startCol", startCol).put("endRow", endRow).put("endCol", endCol);
        send(session, response.toString());
    }

    @Override
    public void onStart(Session session, String opponentName, boolean white) {
        JSONObject response = new JSONObject();
        response.put("type", "matchmaking").put("opponentName", opponentName).put("white", white);
        send(session, response.toString());
    }

    @Override
    public void onEnd(Session session, String gameStatus) {
        JSONObject response = new JSONObject();
        response.put("type", "end").put("gameStatus", gameStatus);
        send(session, response.toString());
    }

    /**
     * Check game status.
     *
     * @param sessionData the session data
     * @throws RemoteException the remote exception
     */
    private void checkGameStatus(SessionData sessionData) throws RemoteException {
        String gameStatus = sessionData.getGameProxy().gameStatus();
        if (!gameStatus.equals("active")){
            JSONObject response = new JSONObject();
            response.put("type", "end").put("gameStatus", gameStatus);
            send(sessionData.getSession(), response.toString());
        }
    }

    /**
     * Sends given response to the session remote.
     *
     * @param session  the session
     * @param response the response
     */
    private void send(Session session, String response) {
        try {
            System.out.println("sending: \"" + response + "\" to " + session.getId());
            session.getBasicRemote().sendText(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
