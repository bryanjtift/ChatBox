package me.HeyAwesomePeople.ChatBox;

import javax.swing.*;
import java.awt.*;

public class ChatView {

    private JFrame frame = new JFrame("ChatterBox3000");
    JButton logout = new JButton("Logout");
    JTextArea chat = new JTextArea();

    private ClassLoader classLoader;

    public ChatView() {
        classLoader = Thread.currentThread().getContextClassLoader();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) dim.getWidth() / 2, (int) dim.getHeight() / 2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints fc = new GridBagConstraints();
        fc.fill = GridBagConstraints.BOTH;

        JPanel left = new JPanel();
        {
            left.setLayout(new GridBagLayout());
            left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1;
            c.weighty = 1;
            c.anchor = GridBagConstraints.NORTH;
            c.gridy = 0;
            left.add(userBox(), c);
            c.anchor = GridBagConstraints.SOUTH;
            c.gridy = 1;
            left.add(logoutButton(), c);
        }

        JPanel right = new JPanel();
        {
            right.setLayout(new GridBagLayout());
            right.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            GridBagConstraints c = new GridBagConstraints();

            c.gridy = 0;
            c.weighty = .95;
            c.weightx = 1;
            c.fill = GridBagConstraints.BOTH;
            right.add(chatBox(), c);
            c.gridy = 1;
            c.weighty = .05;
            right.add(inputBox(), c);
        }

        fc.gridy = 0;
        fc.gridx = 0;
        fc.weightx = 0.25;
        fc.weighty = 1;
        frame.add(left, fc);
        fc.gridx = 1;
        fc.weightx = 0.75;
        frame.add(right, fc);
        frame.setLocationRelativeTo(null);
    }

    void removeFrame() {
        frame.setVisible(false);
    }

    void showFrame() {
        frame.setVisible(true);
    }

    void printLine(String s) {
        chat.append(s);
    }

    void clearChat() {
        chat.setText(null);
    }

    private JPanel logoutButton() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1;

        panel.add(logout, c);

        return panel;
    }

    private JPanel userBox() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1;
        c.weightx = 1;

        c.gridx = 0;
        ImageIcon icon = new ImageIcon(classLoader.getResource("user.png"));
        Image img = icon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT);
        panel.add(new JLabel(new ImageIcon(img)), c);

        JLabel username = new JLabel("ThisIsUsername");
        c.gridx = 1;
        panel.add(username, c);

        return panel;
    }

    private JPanel chatBox() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.weightx = 1;

        chat.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        chat.setEditable(false);
        chat.setLineWrap(true);
        chat.setWrapStyleWord(true);

        JScrollPane areaPane = new JScrollPane(chat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(areaPane, c);

        return panel;
    }

    private JPanel inputBox() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        JTextField input = new JTextField();
        input.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JScrollPane inPane = new JScrollPane(input, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(inPane, c);

        return panel;
    }

}
