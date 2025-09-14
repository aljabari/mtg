package com.aljabari.mtg.client.desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        GameClient client = new GameClient();
        client.connect();

        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = sysin.readLine();
            if ("!exit".equalsIgnoreCase(in)) {
                client.close();
                break;
            }
            else {
                client.send(in);
            }
        }
    }
}
