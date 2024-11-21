package FormularioSimple;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PaintFrame extends JFrame {
    private ActionController eventClicks;

    private void execActions() {
        eventClicks = new ActionController(this);

        eventClicks.eventListener();
    }

    private void centerFrame(Dimension size){ //Este es un método que hice para centrar la ventana justo en el medio de la pantalla, util cuando el JFrame no tiene unas dimensiones predefinidas por ti
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

        int ancho = pantalla.width/2 - (int)size.getWidth()/2;
        int alto = pantalla.height/2 - (int)size.getHeight()/2;

        this.setLocation(ancho, alto);
    }

    JPanel panel = new JPanel();
    JPanel labelsPanel = new JPanel();
    JPanel fieldsPanel = new JPanel();

    JTextField nameField = new JTextField(15);
    JTextField emailField = new JTextField(15);
    JPasswordField passField = new JPasswordField(15);
    JButton button = new JButton("Enviar");

    JLabel title = new JLabel("Introduzca sus datos", SwingConstants.CENTER);
    JLabel nameLabel = new JLabel("Nombre: ");
    JLabel nameError = new JLabel("Este campo es obligatorio");
    JLabel emailLabel = new JLabel("Email: ");
    JLabel emailError = new JLabel("Email no reconocido");
    JLabel passLabel = new JLabel("Contraseña:  ");
    JLabel passError = new JLabel("La contraseña debe de tener al menos 8 caracteres");

    GridBagConstraints c = new GridBagConstraints();
    Color grey = new Color(112, 110, 110);
    Insets errorInsets = new Insets(5, 0, 0, 0);
    Insets labelInsets = new Insets(15, 0, 0, 0);

    public PaintFrame() {
        //this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelConfig();
        this.getContentPane().add(panel);
        this.pack();
        centerFrame(this.getSize());
    }

    public void panelConfig() {
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        //Title
        c.fill = GridBagConstraints.VERTICAL; //Setting it to vertical centers it along its cell Horizontally
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.ipadx = 10;
        c.ipady = 3;
        c.insets = new Insets(0, 0, 20, 0);

        title.setBorder(BorderFactory.createLineBorder(grey, 1));
        panel.add(title, c);

        //Name
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.insets = new Insets(0, 0, 0, 0);       

        panel.add(nameLabel, c);

        nameField.setAlignmentX(RIGHT_ALIGNMENT);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(nameField, c);

        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.insets = errorInsets;

        panel.add(nameError, c);

        //Email
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.insets = labelInsets;

        panel.add(emailLabel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(emailField, c);

        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.insets = errorInsets;

        panel.add(emailError, c);

        //Password

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 5;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.insets = labelInsets;

        panel.add(passLabel, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 5;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(passField, c);

        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 6;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.insets = errorInsets;

        panel.add(passError, c);

        //Button       
        c.fill = GridBagConstraints.VERTICAL; //Setting it to vertical centers it along its cell Horizontally
        c.gridx = 0;
        c.gridy = 7;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.insets = new Insets(18, 0, 0, 0);

        panel.add(button, c);

        //Colors
        title.setForeground(grey);
        nameError.setForeground(Color.RED);
        emailError.setForeground(Color.RED);
        passError.setForeground(Color.RED);

        //Fonts
        title.setFont(new Font("Dialog", Font.BOLD, 16));
        nameError.setFont(new Font("Arial", Font.ITALIC, 12));
        emailError.setFont(new Font("Arial", Font.ITALIC, 12));
        passError.setFont(new Font("Arial", Font.ITALIC, 12));

        //Hiding error mesages
        nameError.setVisible(false);
        emailError.setVisible(false);
        passError.setVisible(false);       

        execActions();
    }
}
