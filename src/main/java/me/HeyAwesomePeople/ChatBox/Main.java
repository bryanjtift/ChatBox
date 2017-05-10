package me.HeyAwesomePeople.ChatBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Main {

    public BufferedReader in;
    public PrintWriter out;

    private RegisterView register;
    private LoginView login;
    private ChatView chat;

    public Main() throws IOException {
        login = new LoginView();
        register = new RegisterView();
        chat = new ChatView();
        login.showFrame();

        login.regButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register.loginButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        login.showFrame();
                        register.removeFrame();
                    }
                });
                register.regButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        out.println("REGISTER " + register.getUsername() + ":" + register.getPassword());
                    }
                });
                register.showFrame();
                login.removeFrame();
            }
        });

        login.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                out.println("LOGIN " + login.getUsername() + ":" + login.getPassword());
            }
        });

        chat.logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chat.removeFrame();
                login.showFrame();
            }
        });
    }

    private void run() throws IOException {
        String serverAddress = "localhost";
        Socket socket = new Socket(serverAddress, 9001);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            String line = in.readLine();
            System.out.println("data: " + line);
            if (line.startsWith("REGISTERSUCCESS")) {
                login.showFrame();
                login.setText("Successfully Registered!");
                register.removeFrame();
            } else if (line.startsWith("LOGINACCEPTED")) {
                login.removeFrame();
                chat.showFrame();
            } else if (line.startsWith("PASSWORDINVALID")) {
                login.setText("Password invalid!");
            } else if (line.startsWith("USERNAMEINVALID")){
                login.setText("Username not found!");
            } else if (line.startsWith("USERNAMETAKEN")) {
                register.setText("Username taken!");
            } else if (line.startsWith("MESSAGE")) {
                chat.printLine(line.substring(8) + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.run();
    }

}
