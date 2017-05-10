package me.HeyAwesomePeople.ChatBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame {

    private Main main;

    public final JTextArea resultArea = new JTextArea();
    public final JTextField inputField = new JTextField();

    public Application(final Main main, final Container content) {
        super("ChatRoom");
        this.main = main;

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(300, 150);
        setPreferredSize(new Dimension((int) dim.getWidth() / 2, (int) dim.getHeight() / 2));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(content);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Application(final Main main) {
        super("ChatRoom");
        this.main = main;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setSize(new Dimension(300, 400));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container content = getContentPane();

        content.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        content.setLayout(new GridBagLayout());

        GridBagConstraints con = new GridBagConstraints();

        resultArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        inputField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        resultArea.setEditable(false);

        JScrollPane pane = new JScrollPane(inputField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane areaPane = new JScrollPane(resultArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        con.insets = new Insets(5, 5, 5, 5);
        con.weightx = 2;
        con.weighty = 1;
        con.gridy = 0;
        con.fill = GridBagConstraints.BOTH;
        content.add(areaPane, con);
        con.weighty = 0;
        con.gridy = 1;
        con.fill = GridBagConstraints.HORIZONTAL;
        content.add(pane, con);

        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.out.println(inputField.getText());
                inputField.setText("");
            }
        });

        setVisible(true);
    }

    public void setContent(Container content) {
        setContentPane(content);
        pack();
        validate();
        repaint();
    }

}
