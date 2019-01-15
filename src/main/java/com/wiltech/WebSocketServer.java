/*
 * (c) Midland Software Limited 2019
 * Name     : WebSocketServer.java
 * Author   : ferraciolliw
 * Date     : 15 Jan 2019
 */
package com.wiltech;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Web server socket end point. This class provides a web socket end point.
 */
@ServerEndpoint(value = "/socket")
public class WebSocketServer {

    /**
     * Method to handle each time a message is received.
     * @param message the message
     * @return the string
     */
    @OnMessage
    public String messageReceived(final String message) {
        System.out.println("Received : " + message);

        return "Message Received!";
    }

    /**
     * Method to run each time a socket is opened.
     * This can be used for a variety of purposes, such as gathering information about the running WebSocket session
     * but also to send synchronous/asynchronous messages to the other end of communication.
     * @param session the web socket session
     */
    @OnOpen
    public void myOnOpen(final Session session) {
        System.out.println("WebSocket opened: " + session.getId());
    }

    /**
     * Method to run each time a socket is closed
     * @param reason the reason the web socket was closed.
     */
    @OnClose
    public void myOnClose(final CloseReason reason) {
        System.out.println("Closing a due to " + reason.getReasonPhrase());
    }

    /**
     * Method to run each time an error is thorwn.
     * @param t The exception thrown.
     */
    @OnError
    public void error(final Throwable t) {

    }

}
