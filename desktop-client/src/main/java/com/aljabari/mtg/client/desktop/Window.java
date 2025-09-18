package com.aljabari.mtg.client.desktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Window {

    private GameClient gameClient;
    private JTextArea textArea;

    public void setClient(GameClient gameClient) {
        this.gameClient = gameClient;
    }

    public Window() {
        JFrame frame = new JFrame();

        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        frame.add(panel, BorderLayout.CENTER);

        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());
        frame.add(chatPanel, BorderLayout.EAST);

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(400, 0));
        textArea.setEditable(false);
        chatPanel.add(textArea, BorderLayout.CENTER);

        JTextField textField = new JTextField();
        chatPanel.add(textField, BorderLayout.SOUTH);

        textField.addActionListener((ActionEvent a) -> {
            gameClient.send(textField.getText());
            textField.setText("");
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();
    }

    public void addMessage(String message) {
        textArea.append(message + "\n");
    }

}
