package com.aljabari.mtg.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        GameServer server = new GameServer(5678);
        server.start();

        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = sysin.readLine();
            server.broadcast(in);
            if ("!exit".equalsIgnoreCase(in)) {
                server.stop(1000);
                break;
            }
        }
    }
}
