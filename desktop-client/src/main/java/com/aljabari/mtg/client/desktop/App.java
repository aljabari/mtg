package com.aljabari.mtg.client.desktop;

import java.io.IOException;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        Window window = new Window();

        GameClient gameClient = new GameClient(window);
        gameClient.connect();

        window.setClient(gameClient);
    }
}
