package com.aljabari.mtg.client.desktop;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class GameClient extends WebSocketClient {

    public GameClient() throws URISyntaxException {
        super(new URI("ws://localhost:5678"));
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        this.send("Hey, it's me, a new client.");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("received: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        // The close codes are documented in class org.java_websocket.framing.CloseFrame
        System.out.println("Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: " + reason);
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
        // if the error is fatal then onClose will be called additionally
    }

}
