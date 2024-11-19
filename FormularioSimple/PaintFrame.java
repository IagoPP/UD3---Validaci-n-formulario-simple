package FormularioSimple;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PaintFrame extends JFrame {
    private ActionController eventClicks;

    private void execActions() {
        eventClicks = new ActionController(this);

        eventClicks.eventListener();
    }

    JPanel panel = new JPanel();

    JTextField nameField = new JTextField(15);
    JTextField emailField = new JTextField(15);
    JPasswordField passField = new JPasswordField(15);
    JButton button = new JButton("Enviar");

    JLabel nameLabel = new JLabel("Nombre: ");
    JLabel emailLabel = new JLabel("Email: ");
    JLabel passLabel = new JLabel("Contraseña: ");
    JLabel errorLabel = new JLabel();

    public PaintFrame() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 220);
        panelConfig();
        this.getContentPane().add(panel);
        //this.pack();
    }

    public void panelConfig() {
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(button);
        panel.add(errorLabel);

        execActions();
    }
}
