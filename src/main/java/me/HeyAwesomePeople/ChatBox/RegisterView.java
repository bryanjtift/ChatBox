package me.HeyAwesomePeople.ChatBox;

import javax.swing.*;
import java.awt.*;

public class RegisterView {

    private JLabel text = new JLabel("");
	public JButton regButton = new JButton("Register");
	public JButton loginButton = new JButton("Already Registered?");
	private JFrame frame = new JFrame("ChatterBox3000 - Register");

	private JTextField userText = new JTextField(20);
	private JPasswordField passwordText = new JPasswordField(20);

	public RegisterView() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize((int) dim.getWidth() / 2, (int) dim.getHeight() / 2);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		GridBagConstraints c = new GridBagConstraints();

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.gridy = 0;
        panel.add(title(), c);
        c.gridy = 1;
        panel.add(registerComponents(), c);
        c.gridy = 2;
        c.anchor = GridBagConstraints.SOUTHEAST;
        panel.add(loginButton(), c);
        c.gridx = 0;
        c.anchor = GridBagConstraints.SOUTHWEST;
        panel.add(textArea(), c);
		frame.add(panel);

		frame.setLocationRelativeTo(null);
	}

	public void setText(String str) {
	    text.setText(str);
    }

    public void clearText() {
	    text.setText("");
    }

    public void removeFrame() {
	    frame.setVisible(false);
    }

    public void showFrame() {
	    frame.setVisible(true);
    }

	public String getUsername() {
		return userText.getText();
	}

	public String getPassword() {
		return passwordText.getText();
	}

    private JPanel title() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel label = new JLabel("Register");
        label.setFont(new Font("Constantia", Font.PLAIN, 34));
        panel.add(label, c);

        return panel;
    }

	private JPanel textArea() {
	    JPanel panel = new JPanel();
	    panel.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

	    text.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    panel.add(text, c);

	    return panel;
    }

	private JPanel loginButton() {
	    JPanel panel = new JPanel();
	    panel.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

	    loginButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    panel.add(loginButton, c);

	    return panel;
    }

	private JPanel registerComponents() {
        JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);

		c.fill = GridBagConstraints.BOTH;

		c.gridx = 0;
		c.gridy = 0;
		JLabel userLabel = new JLabel("User");
        userLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
		panel.add(userLabel, c);

		c.gridx = 1;
		userText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(userText, c);

		c.gridy = 1;
		c.gridx = 0;
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));
		panel.add(passwordLabel, c);

		c.gridx = 1;
		passwordText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(passwordText, c);

		c.gridy = 2;
        panel.add(regButton, c);

		return panel;
	}

}
