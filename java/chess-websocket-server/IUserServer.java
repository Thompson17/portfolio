package de.hsos.vs.chess.chessgame.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for user registration, login and logout.
 */
public interface IUserServer extends Remote {

    /**
     * Login to the user server.
     *
     * @param username    the username
     * @param hash        the hash
     * @param clientProxy the client proxy
     * @return the game proxy
     * @throws RemoteException the remote exception
     */
    public IGameProxy login(String username, String hash, IClientProxy clientProxy) throws RemoteException;

    /**
     * Register to the user server.
     *
     * @param username    the username
     * @param hash        the hash
     * @param clientProxy the client proxy
     * @return the game proxy
     * @throws RemoteException the remote exception
     */
    public IGameProxy register(String username, String hash, IClientProxy clientProxy) throws RemoteException;

    /**
     * Logout of the user server.
     *
     * @param username the username
     * @param hash     the hash
     * @return the boolean
     * @throws RemoteException the remote exception
     */
    public boolean logout(String username, String hash) throws RemoteException;

}
